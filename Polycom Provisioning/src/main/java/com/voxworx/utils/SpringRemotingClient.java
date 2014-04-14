package com.voxworx.utils;

import com.voxworx.polycom.dao.PhoneDAO;
import com.voxworx.polycom.service.ProvisioningService;

public class SpringRemotingClient {

	private static final String LOCALHOST = "localhost";
	
	enum REMOTE_URLS {
		
		POLYCOM_DAO("http/polycom/phonedao"),
		POLYCOM_SERVICE("http/polycom/phoneservice");
		
		private REMOTE_URLS(String url) {
			this.url = url;
		}

		private final String url;

		public String getUrl() {
			return url;
		}
		
	}
	
	public static PhoneDAO getPolycomPhoneDAORemotingClient() {
		return getPolycomPhoneDAORemotingClient(LOCALHOST);
	}

	public static PhoneDAO getPolycomPhoneDAORemotingClient(String host) {
		return SpringRemotingUtils.getRemotingClient(host, REMOTE_URLS.POLYCOM_DAO.getUrl(), PhoneDAO.class);
	}

	public static ProvisioningService getPolycomProvisioningServiceClient() {
		return getPolycomProvisioningServiceClient(LOCALHOST);
	}

	public static ProvisioningService getPolycomProvisioningServiceClient(String host) {
		return SpringRemotingUtils.getRemotingClient(host, REMOTE_URLS.POLYCOM_SERVICE.getUrl(), ProvisioningService.class);
	}
	
}
