package com.voxworx.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.xml.ElementGenerator;
import com.voxworx.polycom.xml.ConfigurationGenerator;
import com.voxworx.polycom.xml.ConfigurationImpl;
import com.voxworx.polycom.xml.RegElementGenerator;

public class RegTest {

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

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
		
		ConfigurationGenerator configGenerator = new ConfigurationImpl();
		
		configGenerator.generatePhoneConfiguration(elementGenerators, phone);
		String configFileName = configGenerator.generatePhoneFileName(phone);
		
		configGenerator.generateMasterConfiguration(phone);
		String masterFileName = configGenerator.generateMasterFileName(phone);

		System.out.println(masterFileName);
		System.out.println(configFileName);
		
	}

}
