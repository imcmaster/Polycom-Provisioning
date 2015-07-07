package com.voxworx.polycom.client;

import java.util.List;

import com.voxworx.polycom.dao.PhoneDAO;
import com.voxworx.polycom.domain.NatParameters;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.utils.MockUtils;
import com.voxworx.utils.SpringRemotingClient;

public class RemoteDAOClient {

	private static final String host = "192.168.2.7";
	//private static final String host = "67.213.75.234";

	public static void main(String[] args) {
		new RemoteDAOClient().go();
	}

	private void go() {
		
		PhoneDAO client = SpringRemotingClient.getPolycomPhoneDAORemotingClient(host);
		
		List<NatParameters> nps = client.findAllNatParameters();
		System.out.println("Size="+nps.size());
		//System.exit(0);
		
		//client.addPhone(MockUtils.createSipPhone());
		for (SipPhone p : client.findAll())
			System.out.println("id="+p.getUserId());
		
		SipPhone p = client.findById(1);
		p.setPassword("test1");
		p.setNumberLineKeys(3);
		//client.addPhone(p);
		System.out.println(p.getCallerIdName());
		System.out.println("contact size="+p.getLocalContacts().size());
		
	}

}
