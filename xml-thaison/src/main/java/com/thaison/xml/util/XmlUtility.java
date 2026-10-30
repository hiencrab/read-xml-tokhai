package com.thaison.xml.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public final class XmlUtility {

    private XmlUtility() {
    }

    public static <T> T fromXml(InputStream inputStream, Class<T> clazz) throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();
        return clazz.cast(unmarshaller.unmarshal(inputStream));
    }
}
