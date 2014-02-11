package com.voxworx.test;

import java.util.ArrayList;
import java.util.List;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.xml.ElementGenerator;
import com.voxworx.polycom.xml.MasterConfigurationGenerator;
import com.voxworx.polycom.xml.MasterConfigurationImpl;
import com.voxworx.polycom.xml.PhoneConfigurationGenerator;
import com.voxworx.polycom.xml.PhoneConfigurationImpl;
import com.voxworx.polycom.xml.RegElementGenerator;

public class RegTest {

	public static void main(String[] args) {

		SipPhone phone = new SipPhone();
		phone.setUserId("1001");
		phone.setPassword("123");
		phone.setMac("00041f2c0112");
		
		SipRegistrar registrar = new SipRegistrar();
		registrar.setIpAddress("192.168.1.2");
		registrar.setPort("5060");
		
		ElementGenerator regGenerator = new RegElementGenerator(phone, registrar);
		List<ElementGenerator> elementGenerators = new ArrayList<ElementGenerator>();
		elementGenerators.add(regGenerator);
		
		PhoneConfigurationGenerator configGenerator = new PhoneConfigurationImpl();
		
		String xmlOutput = configGenerator.generateXMLConfiguration(elementGenerators);
		String configFileName = configGenerator.generateFileName(phone);
		
		MasterConfigurationGenerator masterGenerator = new MasterConfigurationImpl();
		String masterXmlOutput = masterGenerator.generateMasterConfiguration(configFileName);
		String masterFileName = masterGenerator.generateFileName(phone);
		System.out.println(masterFileName);
		System.out.println(masterXmlOutput);
		
		System.out.println(configFileName);
		System.out.println(xmlOutput);
		
	}

}
