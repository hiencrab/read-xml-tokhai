package com.thaison.xml.web;

import com.thaison.xml.entity.DeclarationReportEntity;
import com.thaison.xml.service.DeclarationFilter;
import com.thaison.xml.service.DeclarationRow;
import com.thaison.xml.service.ExcelExportService;
import com.thaison.xml.service.ImportResult;
import com.thaison.xml.service.XmlReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DeclarationController {

    private final XmlReportService reportService;
    private final ExcelExportService excelExportService;

    @GetMapping("/")
    public String list(@ModelAttribute("filter") DeclarationFilter filter, Model model) {
        List<DeclarationRow> rows = reportService.search(filter);
        model.addAttribute("rows", rows);
        model.addAttribute("totalItems", rows.stream().mapToLong(DeclarationRow::getItemCount).sum());
        return "declarations";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("files") List<MultipartFile> files, RedirectAttributes redirect) {
        Map<String, XmlReportService.InputOpener> xmlFiles = new LinkedHashMap<>();
        ImportResult rejected = new ImportResult();
        for (MultipartFile file : files) {
            String name = file.getOriginalFilename() == null ? "(không tên)" : file.getOriginalFilename();
            if (file.isEmpty()) {
                continue;
            }
            if (!name.toLowerCase().endsWith(".xml")) {
                rejected.getErrors().add(name + ": chỉ nhận file .xml");
                continue;
            }
            xmlFiles.put(name, file::getInputStream);
        }

        ImportResult result = xmlFiles.isEmpty() ? new ImportResult() : reportService.importFiles(xmlFiles);
        result.getErrors().addAll(0, rejected.getErrors());
        if (result.getImported().isEmpty() && result.getErrors().isEmpty()) {
            result.getErrors().add("Chưa chọn file nào.");
        }
        redirect.addFlashAttribute("importResult", result);
        return "redirect:/";
    }

    @GetMapping("/declarations/{id}")
    public String detail(@PathVariable Long id, Model model) {
        DeclarationReportEntity declaration = reportService.getDeclaration(id);
        model.addAttribute("declaration", declaration);
        model.addAttribute("header", reportService.getHeader(declaration.getHeaderId()));
        model.addAttribute("fields", reportService.nonEmptyColumns(declaration));
        model.addAttribute("items", reportService.getItems(id));
        return "detail";
    }

    @GetMapping("/export")
    public ResponseEntity<StreamingResponseBody> export(@ModelAttribute DeclarationFilter filter) {
        String fileName = "to-khai-" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) + ".xlsx";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.parseMediaType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(out -> excelExportService.write(filter, out));
    }
}
