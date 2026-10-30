package com.thaison.xml.service;

import com.thaison.xml.entity.DeclarationReportEntity;
import com.thaison.xml.entity.GoodItemEntity;
import com.thaison.xml.entity.HeaderReportEntity;
import com.thaison.xml.repository.DeclarationReportRepository;
import com.thaison.xml.repository.GoodItemRepository;
import com.thaison.xml.repository.HeaderReportRepository;
import com.thaison.xml.util.EntityColumns;
import com.thaison.xml.util.XmlUtility;
import com.thaison.xml.xml.DeclarationReport;
import com.thaison.xml.xml.GoodItemReport;
import com.thaison.xml.xml.RootReport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class XmlReportService {

    static final int IN_CLAUSE_CHUNK = 1000;

    private final HeaderReportRepository headerRepository;
    private final DeclarationReportRepository declarationRepository;
    private final GoodItemRepository goodItemRepository;

    @FunctionalInterface
    public interface InputOpener {
        InputStream open() throws IOException;
    }

    /** Parses every file, then saves all parsed declarations in one transaction. */
    @Transactional(rollbackFor = Exception.class)
    public ImportResult importFiles(Map<String, InputOpener> files) {
        ImportResult result = new ImportResult();
        Map<String, RootReport> parsed = new LinkedHashMap<>();
        files.forEach((name, opener) -> {
            try (InputStream in = opener.open()) {
                RootReport root = XmlUtility.fromXml(in, RootReport.class);
                if (root.getHeader() == null || root.getBody() == null || root.getBody().getDeclaration() == null
                        || !StringUtils.hasText(root.getBody().getDeclaration().getDeclarationNo())) {
                    result.getErrors().add(name + ": không tìm thấy <Header> hoặc <Body><Declaration><DeclarationNo>");
                    return;
                }
                parsed.put(name, root);
            } catch (Exception e) {
                log.warn("Failed to parse {}: {}", name, e.toString());
                result.getErrors().add(name + ": không đọc được XML (" + rootCauseMessage(e) + ")");
            }
        });

        if (!parsed.isEmpty()) {
            deactivateExisting(parsed.values().stream()
                    .map(r -> r.getBody().getDeclaration().getDeclarationNo())
                    .collect(Collectors.toList()));
            parsed.forEach((name, root) -> {
                int items = save(root);
                result.getImported().add(name + " → tờ khai " + root.getBody().getDeclaration().getDeclarationNo()
                        + " (" + items + " dòng hàng)");
            });
        }
        return result;
    }

    private int save(RootReport report) {
        HeaderReportEntity header = new HeaderReportEntity();
        BeanUtils.copyProperties(report.getHeader(), header);
        header = headerRepository.saveAndFlush(header);

        DeclarationReport xmlDeclaration = report.getBody().getDeclaration();
        DeclarationReportEntity declaration = new DeclarationReportEntity();
        BeanUtils.copyProperties(xmlDeclaration, declaration);
        declaration.setHeaderId(header.getId());
        declaration = declarationRepository.saveAndFlush(declaration);

        List<GoodItemReport> xmlItems = xmlDeclaration.getGoodItems() == null
                ? Collections.emptyList() : xmlDeclaration.getGoodItems();
        Long declarationId = declaration.getId();
        List<GoodItemEntity> goodItems = xmlItems.stream().map(xmlItem -> {
            GoodItemEntity item = new GoodItemEntity();
            BeanUtils.copyProperties(xmlItem, item);
            item.setDeclarationReportId(declarationId);
            return item;
        }).collect(Collectors.toList());
        goodItemRepository.saveAll(goodItems);

        log.info("Saved declaration {} (id={}) with {} good items",
                declaration.getDeclarationNo(), declarationId, goodItems.size());
        return goodItems.size();
    }

    private void deactivateExisting(List<String> declarationNos) {
        List<DeclarationReportEntity> existing =
                declarationRepository.findByDeclarationNoInAndActive(declarationNos, true);
        if (existing.isEmpty()) {
            return;
        }
        List<Long> declarationIds = existing.stream().map(DeclarationReportEntity::getId).collect(Collectors.toList());
        List<Long> headerIds = existing.stream().map(DeclarationReportEntity::getHeaderId).collect(Collectors.toList());
        List<Long> goodItemIds = goodItemRepository.findByDeclarationReportIdInAndActive(declarationIds, true)
                .stream().map(GoodItemEntity::getId).collect(Collectors.toList());

        declarationRepository.updateActiveByIds(declarationIds, false);
        headerRepository.updateActiveByIds(headerIds, false);
        if (!goodItemIds.isEmpty()) {
            goodItemRepository.updateActiveByIds(goodItemIds, false);
        }
        log.info("Deactivated {} previously imported declaration(s): {}", existing.size(),
                existing.stream().map(DeclarationReportEntity::getDeclarationNo).collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public List<DeclarationReportEntity> findDeclarations(DeclarationFilter filter) {
        return declarationRepository.findAll(toSpecification(filter), Sort.by(Sort.Direction.DESC, "id"));
    }

    @Transactional(readOnly = true)
    public List<DeclarationRow> search(DeclarationFilter filter) {
        List<DeclarationReportEntity> declarations = findDeclarations(filter);
        Map<Long, Long> counts = new HashMap<>();
        List<Long> ids = declarations.stream().map(DeclarationReportEntity::getId).collect(Collectors.toList());
        for (int i = 0; i < ids.size(); i += IN_CLAUSE_CHUNK) {
            for (Object[] row : goodItemRepository.countActiveByDeclarationIds(
                    ids.subList(i, Math.min(ids.size(), i + IN_CLAUSE_CHUNK)))) {
                counts.put((Long) row[0], (Long) row[1]);
            }
        }
        return declarations.stream()
                .map(d -> new DeclarationRow(d, counts.getOrDefault(d.getId(), 0L)))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DeclarationReportEntity getDeclaration(Long id) {
        return declarationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy tờ khai id=" + id));
    }

    @Transactional(readOnly = true)
    public HeaderReportEntity getHeader(Long id) {
        return id == null ? null : headerRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<GoodItemEntity> getItems(Long declarationId) {
        return goodItemRepository.findByDeclarationReportIdOrderByIdAsc(declarationId);
    }

    /** All non-empty {@code @Column} values of the declaration, keyed by column name. */
    public Map<String, Object> nonEmptyColumns(DeclarationReportEntity declaration) {
        Map<String, Object> values = new LinkedHashMap<>();
        for (Field field : EntityColumns.of(DeclarationReportEntity.class, Set.of("id", "headerId"))) {
            Object value = EntityColumns.value(field, declaration);
            if (value instanceof LocalDateTime) {
                value = ((LocalDateTime) value).toLocalDate();
            }
            if (value != null && StringUtils.hasText(value.toString())) {
                values.put(EntityColumns.label(field), value);
            }
        }
        return values;
    }

    public void printActiveDeclarations() {
        List<DeclarationRow> rows = search(new DeclarationFilter());
        System.out.printf("%n%-6s %-14s %-18s %-12s %-14s %6s%n",
                "ID", "DeclarationNo", "InvoiceNo", "InvoiceDate", "TotalInvoice", "Items");
        for (DeclarationRow row : rows) {
            DeclarationReportEntity d = row.getDeclaration();
            System.out.printf("%-6d %-14s %-18s %-12s %-14s %6d%n",
                    d.getId(), d.getDeclarationNo(), d.getInvoiceNo(),
                    d.getInvoiceDate() == null ? "" : d.getInvoiceDate().toLocalDate(),
                    d.getTotalInvoicePrice(), row.getItemCount());
        }
        System.out.printf("Total active declarations: %d%n%n", rows.size());
    }

    private static Specification<DeclarationReportEntity> toSpecification(DeclarationFilter f) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.isTrue(root.get("active")));
            if (StringUtils.hasText(f.getDeclarationNo())) {
                predicates.add(cb.like(root.<String>get("declarationNo"), "%" + f.getDeclarationNo().trim() + "%"));
            }
            if (StringUtils.hasText(f.getInvoiceNo())) {
                predicates.add(cb.like(root.<String>get("invoiceNo"), "%" + f.getInvoiceNo().trim() + "%"));
            }
            if (f.getFromDate() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.<LocalDateTime>get("invoiceDate"),
                        f.getFromDate().atStartOfDay()));
            }
            if (f.getToDate() != null) {
                predicates.add(cb.lessThan(root.<LocalDateTime>get("invoiceDate"),
                        f.getToDate().plusDays(1).atStartOfDay()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private static String rootCauseMessage(Throwable e) {
        Throwable t = e;
        while (t.getCause() != null) {
            t = t.getCause();
        }
        return t.getMessage() == null ? t.getClass().getSimpleName() : t.getMessage();
    }
}
