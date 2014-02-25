package com.voxworx.polycom.domain;

import java.io.Serializable;

import com.voxworx.polycom.PhoneModel;
import com.voxworx.polycom.RingTone;

public class SipPhone implements Serializable {
	
	private static final long serialVersionUID = -8355500931726150623L;

	private int id;		// Auto-generating ID
	private PhoneModel model;		// i.e. 320, 321, 450, 550, etc
	private RingTone ringTone;		// Default ring tone
	private String mac;				// MAC address
	private String userId;			// Phone extension (also used for sip registration)
	private String password;		// Sip password
	private int numberLineKeys;		// Number of enabled 'Line' keys on the phone (subject to maximum based on phone model)

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
	public int getNumberLineKeys() {
		return numberLineKeys;
	}
	/**
	 * Set the number of enabled line keys.  The number may not exceed the maximum based on the phone model
	 * @param numberLineKeys The number of line keys to enable on the phone
	 */
	public void setNumberLineKeys(int numberLineKeys) {
		int lineKeys = getNumberLineKeys() <= getModel().getMaxLineKeys() ? 
				getNumberLineKeys() : getModel().getMaxLineKeys();
		this.numberLineKeys = lineKeys;
	}

}
