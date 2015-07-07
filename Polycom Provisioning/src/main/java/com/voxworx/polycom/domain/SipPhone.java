package com.voxworx.polycom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.voxworx.polycom.PhoneModel;
import com.voxworx.polycom.RingTone;

/**
 * Represents a phone / user of a phone
 * @author Ian
 *
 */
@Entity
@Table(name = "sip_phone")
public class SipPhone implements Serializable {
	
	private static final long serialVersionUID = -8355500931726150623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;		// Auto-generating ID

	@Column(name="user_id")
	private String userId;			// Phone extension (also used for sip registration)
	@Column(name="domain")
	private String domain;			// Sip registration domain (i.e. userName@domain.com)
	@Column(name="password")
	private String password;		// Sip password

	@Column(name="mac")
	private String mac;				// MAC address
	@Enumerated(EnumType.STRING)
	@Column(name="model")
	private PhoneModel model;		// i.e. 320, 321, 450, 550, etc
	@Enumerated(EnumType.STRING)
	@Column(name="ring_tone")
	private RingTone ringTone;		// Default ring tone
	@Column(name="no_line_keys")
	private int numberLineKeys;		// Number of enabled 'Line' keys on the phone (subject to maximum based on phone model)

	@Column(name="vm_password")
	private String vmPassword;		// Voicemail password (for FS voicemail - ext 4000)
	@Column(name="dial_plan_context")
	private String dialPlanContext;	// the inbound dialplan context to find the extension / routing information
	@Column(name="callerid_name")
	private String callerIdName;	// Outbound calling; name presented
	@Column(name="callerid_number")
	private String callerIdNumber;	// Outbound calling; number presented
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="sip_phone_local_contacts",
            joinColumns=
            @JoinColumn(name="phone_id", referencedColumnName="id"),
      inverseJoinColumns=
            @JoinColumn(name="local_contact_id", referencedColumnName="contact_id"))
	private List<LocalContact> localContacts;
	
	//Features
	@Column(name="enable_park")
	private boolean enablePark;		// Soft key park
	@Column(name="enable_voicemail")
	private boolean enableVoiceMail;	// Enable 'Messages' button, and MWI
	
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
		int lineKeys = numberLineKeys <= getModel().getMaxLineKeys() ? 
				numberLineKeys : getModel().getMaxLineKeys();
		this.numberLineKeys = lineKeys;
	}
	/**
	 * Add a contact to the local contact list
	 * @param contact The contact to add
	 */
	public void addLocalContact(LocalContact contact) {
		if (localContacts == null)
			localContacts = new ArrayList<LocalContact>();
		localContacts.add(contact);
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getVmPassword() {
		return vmPassword;
	}
	public void setVmPassword(String vmPassword) {
		this.vmPassword = vmPassword;
	}
	public String getDialPlanContext() {
		return dialPlanContext;
	}
	public void setDialPlanContext(String dialPlanContext) {
		this.dialPlanContext = dialPlanContext;
	}
	public String getCallerIdName() {
		return callerIdName;
	}
	public void setCallerIdName(String callerIdName) {
		this.callerIdName = callerIdName;
	}
	public String getCallerIdNumber() {
		return callerIdNumber;
	}
	public void setCallerIdNumber(String callerIdNumber) {
		this.callerIdNumber = callerIdNumber;
	}
	public boolean isEnablePark() {
		return enablePark;
	}
	public void setEnablePark(boolean enablePark) {
		this.enablePark = enablePark;
	}
	public boolean isEnableVoiceMail() {
		return enableVoiceMail;
	}
	public void setEnableVoiceMail(boolean enableVoiceMail) {
		this.enableVoiceMail = enableVoiceMail;
	}
	public List<LocalContact> getLocalContacts() {
		return localContacts;
	}
	public void setLocalContacts(List<LocalContact> localContacts) {
		this.localContacts = localContacts;
	}
	
	@Override
	public String toString() {
		return "id="+id+"; userId="+userId+"@"+domain;
	}

}
