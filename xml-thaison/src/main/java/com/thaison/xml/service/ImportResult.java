package com.thaison.xml.service;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ImportResult {

    private final List<String> imported = new ArrayList<>();

    private final List<String> errors = new ArrayList<>();
}
