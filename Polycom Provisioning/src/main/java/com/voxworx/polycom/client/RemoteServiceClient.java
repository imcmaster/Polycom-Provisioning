package com.voxworx.polycom.client;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.dao.PhoneDAO;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.service.ProvisioningService;
import com.voxworx.utils.SpringRemotingClient;

public class RemoteServiceClient {

	private static final String host = "192.168.2.7";
	private static final String colocation = "67.213.75.234";

	public static void main(String[] args) {
		new RemoteServiceClient().go();
	}

	private void go() {

		ProvisioningService s = SpringRemotingClient.getPolycomProvisioningServiceClient(host);
		PhoneDAO daoClient = SpringRemotingClient.getPolycomPhoneDAORemotingClient(host);

		SipPhone sipPhone = daoClient.findByExtension(host, "101");

		System.out.println("Model="+sipPhone.getModel());
		System.out.println("LK="+sipPhone.getNumberLineKeys());

		SipRegistrar registrar = new SipRegistrar();
		registrar.setIpAddress(colocation);
		registrar.setPort("5060");
		
			try {
				s.installConfigurationFiles(sipPhone, registrar);
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Complete");
	}

}
