package com.voxworx.polycom.service;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.domain.SipPhone;

public interface ProvisioningService {

	public void installConfigurationFiles(SipPhone sipPhone, SipRegistrar registrar) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException;
	
}
