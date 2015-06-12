package com.voxworx.polycom.xml;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.LocalContact;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.utils.XmlUtils;

public class ConfigurationImpl implements ConfigurationGenerator {

	@Override
	public void generateMasterConfiguration(SipPhone phone) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
			db = dbf.newDocumentBuilder();
			Document dom = db.newDocument();
			dom.setXmlStandalone(true);
			
			Element root = dom.createElement("APPLICATION");
			root.setAttribute("APP_FILE_PATH", "sip.ld");
			root.setAttribute("CONFIG_FILES", generatePhoneFileName(phone));
			root.setAttribute("LOG_FILE_DIRECTORY", "");
			dom.appendChild(root);
			
			XmlUtils.generateFileResult(dom, buildAbsoluteFileName(generateMasterFileName(phone)), true);
			

	}

	@Override
	public String generateMasterFileName(SipPhone phone) {
		
		StringBuilder s = new StringBuilder();
		s.append(phone.getMac());
		s.append(".cfg");
		return s.toString();

	}

	@Override
	public void generatePhoneConfiguration(List<ElementGenerator> elementGenerators, SipPhone phone) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
		db = dbf.newDocumentBuilder();
		Document dom = db.newDocument();
		dom.setXmlStandalone(true);
		
		Element root = dom.createElement("polycomConfig");
		root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:noNamespaceSchemaLocation", "polycomConfig.xsd");
		dom.appendChild(root);

		for (ElementGenerator elementGenerator : elementGenerators) {
			root.appendChild(elementGenerator.generateElement(dom));
		}
		
		XmlUtils.generateFileResult(dom, buildAbsoluteFileName(generatePhoneFileName(phone)), true);
	
	}

	@Override
	public String generatePhoneFileName(SipPhone phone) {
		
		StringBuilder s = new StringBuilder();
		s.append("phone");
		s.append(phone.getMac());
		s.append(".cfg");
		return s.toString();
		
	}

	@Override
	public void generateLocalContactConfiguration(SipPhone phone) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
		db = dbf.newDocumentBuilder();
		Document dom = db.newDocument();
		dom.setXmlStandalone(true);
		
		Element dir = dom.createElement("directory");
		dom.appendChild(dir);
		
		Element itemList = dom.createElement("item_list");
		dir.appendChild(itemList);
		
		int speedDialIndex = 1;
		for (LocalContact contact : phone.getLocalContacts()) {
			
			Element itemTag = dom.createElement("item");
			itemList.appendChild(itemTag);
			
			Element label = dom.createElement("lb");
			label.setTextContent(contact.getLabel());
			itemTag.appendChild(label);
			
			Element lastName = dom.createElement("ln");
			lastName.setTextContent(contact.getLastName());
			itemTag.appendChild(lastName);
			
			Element firstName = dom.createElement("fn");
			firstName.setTextContent(contact.getFirstName());
			itemTag.appendChild(firstName);
			
			Element contactTag = dom.createElement("ct");
			contactTag.setTextContent(contact.getContact());
			itemTag.appendChild(contactTag);
			
			Element ringTone = dom.createElement("rt");
			ringTone.setTextContent(Integer.valueOf(contact.getRingTone().getRingToneIndex()).toString());
			itemTag.appendChild(ringTone);
			
			Element speedDial = dom.createElement("sd");
			speedDial.setTextContent(Integer.valueOf(speedDialIndex).toString());
			itemTag.appendChild(speedDial);
			
			Element buddyWatch = dom.createElement("bw");
			buddyWatch.setTextContent(contact.isPresence() ? "1" : "0");
			itemTag.appendChild(buddyWatch);
			
			speedDialIndex++;
		}
	
		XmlUtils.generateFileResult(dom, buildAbsoluteFileName(generateLocalContactFileName(phone)), true);
			
		
	}

	@Override
	public String generateLocalContactFileName(SipPhone phone) {
		
		StringBuilder s = new StringBuilder();
		s.append(phone.getMac());
		s.append("-directory.xml");
		return s.toString();
	}

	/**
	 * Prepends the /tftpboot/ directory to the filename
	 * @param baseFileName The base file name, not including the directory
	 * @return The full absolute filename, including /tftpboot + filename
	 */
	private String buildAbsoluteFileName(String baseFileName) {
		StringBuffer s = new StringBuffer();
		s.append("/tftpboot/");
		s.append(baseFileName);
		return s.toString();
	}
	
}
