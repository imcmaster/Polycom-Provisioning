package com.voxworx.polycom;

import java.io.Serializable;

/**
 * A local contact (speed dials, buddies)
 * @author Ian
 *
 */
public class LocalContact implements Serializable {
	
	private static final long serialVersionUID = 4823502997797204251L;

	private String firstName;
	private String lastName;
	private final String contact;	// sip id
	private RingTone ringTone;
	private boolean presence;	// if true then SIP SUBSCRIBE / NOTIFY (presence) will be activated (buddy watch)
	
	public LocalContact(String contact) {
		super();
		this.contact = contact;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RingTone getRingTone() {
		return ringTone;
	}

	public void setRingTone(RingTone ringTone) {
		this.ringTone = ringTone;
	}

	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	public String getContact() {
		return contact;
	}
	
	
	
}
