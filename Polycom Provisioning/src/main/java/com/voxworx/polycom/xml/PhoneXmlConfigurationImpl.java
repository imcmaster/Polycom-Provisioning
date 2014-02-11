package com.voxworx.polycom.xml;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PhoneXmlConfigurationImpl implements PhoneXmlConfigurationGenerator {

	@Override
	public String generateXMLConfiguration(List<ElementGeneratorInterface> elementGenerators) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
		
			db = dbf.newDocumentBuilder();
			Document dom = db.newDocument();
			
			Element root = dom.createElement("polycomConfig");
			root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			root.setAttribute("xsi:noNamespaceSchemaLocation", "polycomConfig.xsd");
			dom.appendChild(root);

			for (ElementGeneratorInterface elementGenerator : elementGenerators) {
				root.appendChild(elementGenerator.generateElement(dom));
			}

			return XmlUtils.generateStringResult(dom);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	
	}

}
