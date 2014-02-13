package com.voxworx.polycom.client;

import com.voxworx.polycom.dao.PhoneDAO;
import com.voxworx.utils.MockUtils;
import com.voxworx.utils.SpringRemotingClient;

public class RemoteDAOClient {

	private static final String host = "192.168.2.7";

	public static void main(String[] args) {
		new RemoteDAOClient().go();
	}

	private void go() {
		
		PhoneDAO client = SpringRemotingClient.getPolycomPhoneDAORemotingClient(host);
		client.addPhone(MockUtils.createSipPhone());
		
	}

}
