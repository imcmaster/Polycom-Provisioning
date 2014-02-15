package com.voxworx.polycom;

import java.io.Serializable;

public class SipRegistrar implements Serializable {

	private static final long serialVersionUID = -914902924591550923L;

	private String ipAddress;
	private String port;
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
}
