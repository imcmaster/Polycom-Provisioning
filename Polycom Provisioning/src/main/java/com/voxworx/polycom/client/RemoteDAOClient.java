package com.voxworx.polycom.client;

import java.util.List;

import com.voxworx.polycom.RingTone;
import com.voxworx.polycom.dao.PhoneDAO;
import com.voxworx.polycom.domain.LocalContact;
import com.voxworx.polycom.domain.NatParameters;
import com.voxworx.polycom.domain.SipPhone;
import com.voxworx.polycom.util.PolycomUtils;
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
		
		SipPhone p = client.findById(2);
		System.out.println(p.getCallerIdName());
		System.out.println("contact size="+p.getLocalContacts().size());
		
		LocalContact lc = client.findLocalContactByContactName("103");
		p.addLocalContact(lc);
		System.out.println("lc="+lc);
		
		NatParameters np = client.findNatParametersByIp("70.49.151.241");
		p.setNatParameter(np);
		p.setSourceInviteOnly(true);
		client.addPhone(p);
		
	}

	private LocalContact createLocalContact(String contactName) {
		LocalContact contact = new LocalContact("103");
		contact.setLabel("Pharmacy");
		contact.setRingTone(RingTone.LowDoubleTrill);
		contact.setPresence(false);
		return contact;
	}
}
