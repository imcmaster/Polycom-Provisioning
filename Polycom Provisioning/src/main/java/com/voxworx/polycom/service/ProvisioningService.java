package com.voxworx.polycom.service;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.domain.SipPhone;

public interface ProvisioningService {

	public void installConfigurationFiles(SipPhone sipPhone, SipRegistrar registrar);
	
}
