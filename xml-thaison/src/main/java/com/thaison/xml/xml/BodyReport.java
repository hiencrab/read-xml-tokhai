package com.thaison.xml.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class BodyReport {

	@XmlElement(name = "Declaration")
	private DeclarationReport declaration;

}
