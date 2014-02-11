package com.voxworx.polycom.xml;

import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XmlUtils {
	
	public static String generateStringResult(Document dom) throws TransformerFactoryConfigurationError, TransformerException {
		Transformer tr = generateTransformer();
        StringWriter outWriter = new StringWriter();
        StreamResult sr = new StreamResult(outWriter);
        tr.transform(new DOMSource(dom), sr);
		return outWriter.getBuffer().toString();

	}
	
	public static Transformer generateTransformer() throws TransformerConfigurationException, TransformerFactoryConfigurationError {
		Transformer tr = TransformerFactory.newInstance().newTransformer();
		tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");			
		tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty(OutputKeys.METHOD, "xml");
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        return tr;

	}
	
}
