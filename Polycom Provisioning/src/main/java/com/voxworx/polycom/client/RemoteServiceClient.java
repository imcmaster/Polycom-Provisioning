package com.voxworx.polycom.client;

import com.voxworx.polycom.LocalContact;
import com.voxworx.polycom.RingTone;
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

		SipPhone sipPhone = daoClient.findByExtension(host, "101");

		sipPhone.addLocalContact(createLocalContact("103"));
		
		System.out.println("Model="+sipPhone.getModel());
		System.out.println("LK="+sipPhone.getNumberLineKeys());

		SipRegistrar registrar = new SipRegistrar();
		registrar.setIpAddress(host);
		registrar.setPort("5060");
		s.installConfigurationFiles(sipPhone, registrar);
		
		System.out.println("Complete");
	}

	private LocalContact createLocalContact(String contactName) {
		LocalContact contact = new LocalContact("103");
		contact.setLastName("Pharmacy");
		contact.setRingTone(RingTone.LowDoubleTrill);
		contact.setPresence(true);
		return contact;
	}
	
}
