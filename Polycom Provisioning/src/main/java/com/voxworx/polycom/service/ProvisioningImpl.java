package com.voxworx.polycom.service;

import java.util.ArrayList;
import java.util.List;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.SoftKeyProfile;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.util.PolycomUtils;
import com.voxworx.polycom.xml.ConfigurationGenerator;
import com.voxworx.polycom.xml.DigitMapElementGenerator;
import com.voxworx.polycom.xml.ElementGenerator;
import com.voxworx.polycom.xml.FeatureElementGenerator;
import com.voxworx.polycom.xml.RegElementGenerator;
import com.voxworx.polycom.xml.SoftKeyElementGenerator;

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
		
		// 3.  Features tag; to set the enhancedFeatureKeys
		FeatureElementGenerator featureElementGenerator = new FeatureElementGenerator();
		featureElementGenerator.setEnhancedFeatureKeysEnabled(true);
		
		// 4.  Soft key tag
		SoftKeyProfile softKeyProfile = new SoftKeyProfile(phone.getModel());
		softKeyProfile.addCustomSoftKey(PolycomUtils.createCustomSoftKeyPark("*5"));
		SoftKeyElementGenerator softKeyElementGenerator = new SoftKeyElementGenerator(softKeyProfile);
		
		elementGenerators.add(regGenerator);
		elementGenerators.add(digitMapGenerator);
		elementGenerators.add(featureElementGenerator);
		elementGenerators.add(softKeyElementGenerator);
		
		configurationGenerator.generatePhoneConfiguration(elementGenerators, phone);
		configurationGenerator.generateMasterConfiguration(phone);
		
	}

}
