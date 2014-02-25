package com.voxworx.polycom.client;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.dao.PhoneDAO;
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
		PhoneDAO daoClient = SpringRemotingClient.getPolycomPhoneDAORemotingClient(host);

		SipPhone sipPhone = daoClient.findByExtension("103");

		SipRegistrar registrar = new SipRegistrar();
		registrar.setIpAddress(host);
		registrar.setPort("5060");
		s.installConfigurationFiles(sipPhone, registrar);
		
		System.out.println("Complete");
	}

}
