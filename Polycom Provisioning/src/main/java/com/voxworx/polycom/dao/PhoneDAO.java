package com.voxworx.polycom.dao;

import java.util.List;

import com.voxworx.polycom.domain.SipPhone;

public interface PhoneDAO {

	public SipPhone addPhone(SipPhone phone);
	public void delete(SipPhone phone);
	
	public List<SipPhone> findAll();
	public SipPhone findByExtension(String extension);
	
}
