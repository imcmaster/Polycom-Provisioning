package com.voxworx.polycom.service;

import java.util.ArrayList;
import java.util.List;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.util.PolycomUtils;
import com.voxworx.polycom.xml.ConfigurationGenerator;
import com.voxworx.polycom.xml.DigitMapElementGenerator;
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

		// 1.  Registration tag
		ElementGenerator regGenerator = new RegElementGenerator(phone, registrar);

		// 2.  Digitmap tag
		DigitMapElementGenerator digitMapGenerator = new DigitMapElementGenerator();
		digitMapGenerator.addDigitMap(PolycomUtils.generateLocalExtension(1, 2, 3, false));
		//TODO:  Add the ability to dial to PSTN (10 digit w/ area code)
		
		
		elementGenerators.add(regGenerator);
		elementGenerators.add(digitMapGenerator);
		
		configurationGenerator.generatePhoneConfiguration(elementGenerators, phone);
		configurationGenerator.generateMasterConfiguration(phone);
		
	}

}
