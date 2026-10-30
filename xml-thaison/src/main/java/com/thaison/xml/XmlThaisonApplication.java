package com.thaison.xml;

import com.thaison.xml.service.ImportResult;
import com.thaison.xml.service.XmlReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class XmlThaisonApplication implements CommandLineRunner {

    private final XmlReportService xmlReportService;

    @Value("${server.port:8080}")
    private int port;

    /** No arguments: start the web UI. With arguments: run a CLI command and exit. */
    public static void main(String[] args) {
        new SpringApplicationBuilder(XmlThaisonApplication.class)
                .web(args.length == 0 ? WebApplicationType.SERVLET : WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            log.info("Web UI: http://localhost:{}", port);
            return;
        }
        switch (args[0].toLowerCase()) {
            case "import":
                if (args.length < 2) {
                    throw new IllegalArgumentException("import needs a file or folder path");
                }
                importPath(new File(args[1]));
                xmlReportService.printActiveDeclarations();
                break;
            case "list":
                xmlReportService.printActiveDeclarations();
                break;
            default:
                System.out.println("Usage:");
                System.out.println("  (no arguments)               start web UI at http://localhost:" + port);
                System.out.println("  import <file.xml | folder>   read declaration XML(s) and save to PostgreSQL");
                System.out.println("  list                         show active declarations in the database");
        }
    }

    private void importPath(File path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Path not found: " + path.getAbsolutePath());
        }
        File[] files = path.isDirectory()
                ? path.listFiles((dir, name) -> name.toLowerCase().endsWith(".xml"))
                : new File[]{path};
        Arrays.sort(files, Comparator.comparing(File::getName));

        Map<String, XmlReportService.InputOpener> inputs = new LinkedHashMap<>();
        for (File file : files) {
            inputs.put(file.getName(), () -> new FileInputStream(file));
        }
        ImportResult result = xmlReportService.importFiles(inputs);
        result.getImported().forEach(line -> log.info("Imported {}", line));
        result.getErrors().forEach(line -> log.error("Skipped {}", line));
    }
}
