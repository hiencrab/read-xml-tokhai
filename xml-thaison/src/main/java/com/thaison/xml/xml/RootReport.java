package com.thaison.xml.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootReport {

	@XmlElement(name = "Header")
	private HeaderReport header;

	@XmlElement(name = "Body")
	private BodyReport body;

}
