package com.thaison.xml.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringDateXMLAdapter extends XmlAdapter<String, LocalDateTime> {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

	@Override
	public LocalDateTime unmarshal(String v) throws Exception {
		LocalDate date = LocalDate.parse(v, formatter);
		return date.atStartOfDay();
	}

	@Override
	public String marshal(LocalDateTime v) throws Exception {
		return v.toLocalDate().format(formatter);
	}

}
