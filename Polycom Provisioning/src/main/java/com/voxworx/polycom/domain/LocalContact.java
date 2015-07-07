package com.voxworx.polycom.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.voxworx.polycom.RingTone;

/**
 * A local contact (speed dials, buddies)
 * @author Ian
 *
 */
@Entity
@Table(name="sip_local_contacts")
public class LocalContact implements Serializable {
	
	private static final long serialVersionUID = 4823502997797204251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_id")	
	private int id;
	
	@Column(name="first_name")	
	private String firstName;
	@Column(name="last_name")	
	private String lastName;
	@Column(name="label")	
	private String label;
	@Column(name="contact")	
	private final String contact;	// sip id
	@Enumerated(EnumType.STRING)
	@Column(name="ring_tone")	
	private RingTone ringTone;
	@Column(name="presence")	
	private boolean presence;	// if true then SIP SUBSCRIBE / NOTIFY (presence) will be activated (buddy watch)
	
	public LocalContact(String contact) {
		super();
		this.contact = contact;
	}

	public int getId() {
		return id;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
