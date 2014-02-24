package com.voxworx.polycom.domain;

import java.io.Serializable;

import com.voxworx.polycom.PhoneModel;
import com.voxworx.polycom.RingTone;

public class SipPhone implements Serializable {
	
	private static final long serialVersionUID = -8355500931726150623L;

	private int id;		// Auto-generating ID
	private PhoneModel model;
	private RingTone ringTone;
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
	public RingTone getRingTone() {
		return ringTone;
	}
	public void setRingTone(RingTone ringTone) {
		this.ringTone = ringTone;
	}

}
