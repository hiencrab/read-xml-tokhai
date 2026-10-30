package com.thaison.xml.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateXMLAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDate.parse(v, FORMATTER).atStartOfDay();
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return v.format(FORMATTER);
    }

}
