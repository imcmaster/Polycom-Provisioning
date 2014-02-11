package com.voxworx.polycom.domain;

import com.voxworx.polycom.PhoneModel;

public class SipPhone {
	
	private int id;		// Auto-generating ID
	private PhoneModel model;
	private String mac;
	private String userId;
	private String password;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PhoneModel getModel() {
		return model;
	}
	public void setModel(PhoneModel model) {
		this.model = model;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
