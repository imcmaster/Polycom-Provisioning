package com.voxworx.polycom.xml;

import com.voxworx.polycom.domain.SipPhone;

public interface MasterConfigurationGenerator {

	public String generateMasterConfiguration(String configFileName);
	public String generateFileName(SipPhone phone);

}
