package com.thaison.xml.service;

import com.thaison.xml.entity.DeclarationReportEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeclarationRow {

    private final DeclarationReportEntity declaration;

    private final long itemCount;
}
