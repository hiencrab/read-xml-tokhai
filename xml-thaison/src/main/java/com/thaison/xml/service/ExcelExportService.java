package com.thaison.xml.service;

import com.thaison.xml.entity.DeclarationReportEntity;
import com.thaison.xml.entity.GoodItemEntity;
import com.thaison.xml.entity.HeaderReportEntity;
import com.thaison.xml.repository.GoodItemRepository;
import com.thaison.xml.repository.HeaderReportRepository;
import com.thaison.xml.util.EntityColumns;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExcelExportService {

    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final XmlReportService reportService;
    private final HeaderReportRepository headerRepository;
    private final GoodItemRepository goodItemRepository;

    /** One row per active good item, followed by every column of its declaration. */
    public void write(DeclarationFilter filter, OutputStream out) throws IOException {
        List<DeclarationReportEntity> declarations = reportService.findDeclarations(filter);
        declarations.sort(Comparator.comparing(DeclarationReportEntity::getId));

        Map<Long, HeaderReportEntity> headers = headerRepository.findAllById(
                        declarations.stream().map(DeclarationReportEntity::getHeaderId).collect(Collectors.toSet()))
                .stream().collect(Collectors.toMap(HeaderReportEntity::getId, Function.identity()));
        Map<Long, List<GoodItemEntity>> itemsByDeclaration = loadItems(declarations);

        List<Field> declarationFields = EntityColumns.of(DeclarationReportEntity.class, Set.of("id", "headerId"));
        List<Field> itemFields = EntityColumns.of(GoodItemEntity.class, Set.of("id", "declarationReportId"));

        try (SXSSFWorkbook workbook = new SXSSFWorkbook(200)) {
            SXSSFSheet sheet = workbook.createSheet("ToKhai");
            CellStyle bold = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            bold.setFont(font);

            Row head = sheet.createRow(0);
            int col = 0;
            head.createCell(col++).setCellValue("STT");
            head.createCell(col++).setCellValue("HEADER_DATE");
            for (Field f : declarationFields) {
                head.createCell(col++).setCellValue(EntityColumns.label(f));
            }
            for (Field f : itemFields) {
                head.createCell(col++).setCellValue(EntityColumns.label(f));
            }
            head.forEach(c -> c.setCellStyle(bold));
            sheet.createFreezePane(0, 1);

            int rowIndex = 1;
            for (DeclarationReportEntity declaration : declarations) {
                HeaderReportEntity header = headers.get(declaration.getHeaderId());
                for (GoodItemEntity item : itemsByDeclaration.getOrDefault(declaration.getId(), List.of())) {
                    Row row = sheet.createRow(rowIndex);
                    col = 0;
                    row.createCell(col++).setCellValue(rowIndex);
                    row.createCell(col++).setCellValue(format(header == null ? null : header.getDate()));
                    for (Field f : declarationFields) {
                        row.createCell(col++).setCellValue(format(EntityColumns.value(f, declaration)));
                    }
                    for (Field f : itemFields) {
                        row.createCell(col++).setCellValue(format(EntityColumns.value(f, item)));
                    }
                    rowIndex++;
                }
            }
            workbook.write(out);
            workbook.dispose();
        }
    }

    private Map<Long, List<GoodItemEntity>> loadItems(List<DeclarationReportEntity> declarations) {
        List<Long> ids = declarations.stream().map(DeclarationReportEntity::getId).collect(Collectors.toList());
        List<GoodItemEntity> items = new ArrayList<>();
        for (int i = 0; i < ids.size(); i += XmlReportService.IN_CLAUSE_CHUNK) {
            items.addAll(goodItemRepository.findByDeclarationReportIdInAndActive(
                    ids.subList(i, Math.min(ids.size(), i + XmlReportService.IN_CLAUSE_CHUNK)), true));
        }
        items.sort(Comparator.comparing(GoodItemEntity::getId));
        return items.stream().collect(Collectors.groupingBy(GoodItemEntity::getDeclarationReportId));
    }

    private static String format(Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof LocalDateTime) {
            return ((LocalDateTime) value).format(DATE);
        }
        return value.toString();
    }
}
