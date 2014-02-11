package com.voxworx.polycom.xml;

import java.util.List;

import com.voxworx.polycom.domain.SipPhone;

public interface PhoneConfigurationGenerator {

	public String generateXMLConfiguration(List<ElementGenerator> elementGenerators);
	public String generateFileName(SipPhone phone);
	
}
