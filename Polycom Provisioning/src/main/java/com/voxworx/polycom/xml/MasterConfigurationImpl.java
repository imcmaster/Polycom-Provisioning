package com.voxworx.polycom.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.domain.SipPhone;

public class MasterConfigurationImpl implements MasterConfigurationGenerator {

	@Override
	public String generateMasterConfiguration(String configFileName) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
		
			db = dbf.newDocumentBuilder();
			Document dom = db.newDocument();
			dom.setXmlStandalone(true);
			
			Element root = dom.createElement("APPLICATION");
			root.setAttribute("APP_FILE_PATH", "sip.ld");
			root.setAttribute("CONFIG_FILES", configFileName);
			root.setAttribute("LOG_FILE_DIRECTORY", "");
			dom.appendChild(root);
			
			return XmlUtils.generateStringResult(dom, true);
			
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

	@Override
	public String generateFileName(SipPhone phone) {
		
		StringBuilder s = new StringBuilder();
		s.append(phone.getMac());
		s.append(".cfg");
		return s.toString();

	}

}
