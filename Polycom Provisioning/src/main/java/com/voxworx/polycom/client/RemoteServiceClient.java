package com.voxworx.polycom.client;

import com.voxworx.polycom.PhoneModel;
import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.service.ProvisioningService;
import com.voxworx.utils.SpringRemotingClient;

public class RemoteServiceClient {

	private static final String host = "192.168.2.7";

	public static void main(String[] args) {
		new RemoteServiceClient().go();
	}

	private void go() {
		ProvisioningService s = SpringRemotingClient.getPolycomProvisioningServiceClient(host);
		SipPhone sipPhone = new SipPhone();
		sipPhone.setMac("0004f21b37aa");
		sipPhone.setModel(PhoneModel.SoundPointIP321);
		sipPhone.setUserId("103");
		sipPhone.setPassword("test");
		SipRegistrar registrar = new SipRegistrar();
		registrar.setIpAddress(host);
		registrar.setPort("5060");
		s.installConfigurationFiles(sipPhone, registrar);
	}

}
