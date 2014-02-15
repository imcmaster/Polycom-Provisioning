package com.voxworx.polycom.service;

import java.util.ArrayList;
import java.util.List;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.xml.ConfigurationGenerator;
import com.voxworx.polycom.xml.ElementGenerator;
import com.voxworx.polycom.xml.RegElementGenerator;

public class ProvisioningImpl implements ProvisioningService {

	private ConfigurationGenerator configurationGenerator;
	public void setConfigurationGenerator(
			ConfigurationGenerator configurationGenerator) {
		this.configurationGenerator = configurationGenerator;
	}

	@Override
	public void installConfigurationFiles(SipPhone phone, SipRegistrar registrar) {
		
		List<ElementGenerator> elementGenerators = new ArrayList<ElementGenerator>();

		ElementGenerator regGenerator = new RegElementGenerator(phone, registrar);
		elementGenerators.add(regGenerator);
		
		configurationGenerator.generatePhoneConfiguration(elementGenerators, phone);
		configurationGenerator.generateMasterConfiguration(phone);
		
	}

}
