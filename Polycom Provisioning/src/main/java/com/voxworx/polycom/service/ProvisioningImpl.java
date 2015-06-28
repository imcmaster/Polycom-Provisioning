package com.voxworx.polycom.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.voxworx.polycom.RingClass;
import com.voxworx.polycom.RingTone;
import com.voxworx.polycom.SipParameters;
import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.SoftKeyProfile;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.util.PolycomUtils;
import com.voxworx.polycom.xml.ConfigurationGenerator;
import com.voxworx.polycom.xml.DigitMapElementGenerator;
import com.voxworx.polycom.xml.ElementGenerator;
import com.voxworx.polycom.xml.FeatureElementGenerator;
import com.voxworx.polycom.xml.MessageWaitingElementGenerator;
import com.voxworx.polycom.xml.NatElementGenerator;
import com.voxworx.polycom.xml.RegElementGenerator;
import com.voxworx.polycom.xml.RingClassElementGenerator;
import com.voxworx.polycom.xml.SipElementGenerator;
import com.voxworx.polycom.xml.SoftKeyElementGenerator;
import com.voxworx.polycom.xml.UserPreferenceElementGenerator;

public class ProvisioningImpl implements ProvisioningService {

	private ConfigurationGenerator configurationGenerator;
	public void setConfigurationGenerator(
			ConfigurationGenerator configurationGenerator) {
		this.configurationGenerator = configurationGenerator;
	}

	@Override
	public void installConfigurationFiles(SipPhone phone, SipRegistrar registrar) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		List<ElementGenerator> elementGenerators = new ArrayList<ElementGenerator>();

		// 1.  Registration tag
		ElementGenerator regGenerator = new RegElementGenerator(phone, registrar);
		elementGenerators.add(regGenerator);

		// 2.  Digitmap tag
		DigitMapElementGenerator digitMapGenerator = new DigitMapElementGenerator();
		digitMapGenerator.addDigitMap(PolycomUtils.generateLocalExtension(1, 2, 3, false));
		//TODO:  Add the ability to dial to PSTN (10 digit w/ area code)
		elementGenerators.add(digitMapGenerator);
		
		// 3.  Features tag; to set the enhancedFeatureKeys
		FeatureElementGenerator featureElementGenerator = new FeatureElementGenerator();
		featureElementGenerator.setEnhancedFeatureKeysEnabled(true);
		// TODO:  Should be enabled if a SipPhone.contact has bw=1
		featureElementGenerator.setPresenceEnabled(true);
		elementGenerators.add(featureElementGenerator);
		
		// 4.  Soft key tag
		//TODO:  Can' hardcode soft key *5
		if (phone.isEnablePark()) {
			SoftKeyProfile softKeyProfile = new SoftKeyProfile(phone.getModel());
			softKeyProfile.addCustomSoftKey(PolycomUtils.createCustomSoftKeyPark("*5"));
			SoftKeyElementGenerator softKeyElementGenerator = new SoftKeyElementGenerator(softKeyProfile);
			elementGenerators.add(softKeyElementGenerator);
		}
		
		// 5.  Voice Mail
		if (phone.isEnableVoiceMail()) {
			UserPreferenceElementGenerator up = new UserPreferenceElementGenerator();
			up.setEnableVoiceMail(true);
			MessageWaitingElementGenerator msg = new MessageWaitingElementGenerator(phone);
			elementGenerators.add(up);
			elementGenerators.add(msg);
		}
		
		// 6.  Create a ring class (for distinctive ring); in future this XML may move to a shared file
		RingClassElementGenerator ringClassElementGenerator = new RingClassElementGenerator();
		ringClassElementGenerator.addRingClassParameter(PolycomUtils.createRingClassUsingRingTone(RingClass.CUSTOM1, "Custom 1", RingTone.Beeble));
		elementGenerators.add(ringClassElementGenerator);
		
		// 7.  Create a few alert-info mapping (voIpProt.SIP.alertInfo)
		SipParameters sipParameters = new SipParameters();
		sipParameters.addAlertInfoMapping(RingClass.CUSTOM1);
		sipParameters.addAlertInfoMapping(RingClass.AUTOANSWER);
		sipParameters.addAlertInfoMapping(RingClass.RINGAUTOANSWER);

		SipElementGenerator sipElementGenerator = new SipElementGenerator(sipParameters);
		elementGenerators.add(sipElementGenerator);
		
		// 8.  NAT
		NatElementGenerator natElementGenerator = new NatElementGenerator(PolycomUtils.createDefaultNatParameters("70.49.151.241"));
		elementGenerators.add(natElementGenerator);
		
		/*
		 * Final step - build the phone's configuration files
		 */
		configurationGenerator.generatePhoneConfiguration(elementGenerators, phone);
		configurationGenerator.generateMasterConfiguration(phone);
		if (phone.getLocalContacts() != null && phone.getLocalContacts().size() > 0)
			configurationGenerator.generateLocalContactConfiguration(phone);
		
	}

}
