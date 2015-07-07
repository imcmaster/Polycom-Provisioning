package com.voxworx.polycom.dao;

import java.util.List;

import com.voxworx.polycom.domain.LocalContact;
import com.voxworx.polycom.domain.NatParameters;
import com.voxworx.polycom.domain.SipPhone;

public interface PhoneDAO {

	public SipPhone addPhone(SipPhone phone);
	public void delete(SipPhone phone);
	public List<SipPhone> findAll();
	public SipPhone findByExtension(String domain, String extension);
	public SipPhone findById(int id);

	public NatParameters addNatParameter(NatParameters natParameter);
	public void deleteNatParameter(NatParameters natParameter);
	public List<NatParameters> findAllNatParameters();
	
	public LocalContact addLocalContact(LocalContact localContact);
	public void deleteLocalContact(LocalContact localContact);
	public List<LocalContact> findAllLocalContacts();
	
}
