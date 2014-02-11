package com.voxworx.polycom.xml;

import java.util.List;

public interface PhoneXmlConfigurationGenerator {

	public String generateXMLConfiguration(List<ElementGeneratorInterface> elementGenerators);
	
}
