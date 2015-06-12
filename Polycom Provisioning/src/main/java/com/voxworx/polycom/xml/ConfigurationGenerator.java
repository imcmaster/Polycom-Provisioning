package com.voxworx.polycom.xml;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.voxworx.polycom.domain.SipPhone;

public interface ConfigurationGenerator {

	public void generateMasterConfiguration(SipPhone phone) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException;
	public String generateMasterFileName(SipPhone phone);

	public void generatePhoneConfiguration(List<ElementGenerator> elementGenerators, SipPhone phone) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException;
	public String generatePhoneFileName(SipPhone phone);
	
	public void generateLocalContactConfiguration(SipPhone phone) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException;
	public String generateLocalContactFileName(SipPhone phone);

}
