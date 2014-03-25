package com.voxworx.polycom.xml;

import java.util.List;

import com.voxworx.polycom.domain.SipPhone;

public interface ConfigurationGenerator {

	public void generateMasterConfiguration(SipPhone phone);
	public String generateMasterFileName(SipPhone phone);

	public void generatePhoneConfiguration(List<ElementGenerator> elementGenerators, SipPhone phone);
	public String generatePhoneFileName(SipPhone phone);
	
	public void generateLocalContactConfiguration(SipPhone phone);
	public String generateLocalContactFileName(SipPhone phone);

}
