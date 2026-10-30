package com.thaison.xml.xml;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Getter;
import lombok.Setter;
import com.thaison.xml.util.DateXMLAdapter;

@Getter
@Setter
@XmlRootElement(name = "Header")
@XmlAccessorType(XmlAccessType.FIELD)
public class HeaderReport {

	@XmlElement(name = "App")
	private String app;

	@XmlElement(name = "DBVersion")
	private String dbVersion;

	@XmlElement(name = "LastUpdate")
	@XmlJavaTypeAdapter(DateXMLAdapter.class)
	private LocalDateTime lastUpdate;

	@XmlElement(name = "VersionMessage")
	private String versionMessage;

	@XmlElement(name = "Date")
	@XmlJavaTypeAdapter(DateXMLAdapter.class)
	private LocalDateTime date;

}
