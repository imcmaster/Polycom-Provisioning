package com.voxworx.polycom.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.voxworx.polycom.domain.LocalContact;
import com.voxworx.polycom.domain.NatParameters;
import com.voxworx.polycom.domain.SipPhone;

public class HibernatePhoneDAOImpl implements PhoneDAO {

	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public SipPhone addPhone(SipPhone phone) {
		if (phone.getId() > 0)
			hibernateTemplate.merge(phone);
		else
			hibernateTemplate.saveOrUpdate(phone);
		return phone;
	}

	@Override
	public void delete(SipPhone phone) {
		hibernateTemplate.delete(phone);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SipPhone> findAll() {
		return hibernateTemplate.find("from SipPhone");
	}

	@SuppressWarnings("unchecked")
	@Override
	public SipPhone findByExtension(String domain, String extension) {
		List<SipPhone> result = hibernateTemplate.find("from SipPhone where domain = ? and userId = ?", domain, extension);
		return result.size() > 0 ? result.get(0) : null;
	}

	@Override
	public SipPhone findById(int id) {
		return hibernateTemplate.get(SipPhone.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NatParameters> findAllNatParameters() {
		return hibernateTemplate.find("from NatParameters");
	}

	@Override
	public NatParameters addNatParameter(NatParameters natParameter) {
		if (natParameter.getId() > 0)
			hibernateTemplate.merge(natParameter);
		else
			hibernateTemplate.saveOrUpdate(natParameter);

		return natParameter;
	}

	@Override
	public void deleteNatParameter(NatParameters natParameter) {
		hibernateTemplate.delete(natParameter);
	}

	@Override
	public LocalContact addLocalContact(LocalContact localContact) {
		if (localContact.getId() > 0)
			hibernateTemplate.merge(localContact);
		else
			hibernateTemplate.saveOrUpdate(localContact);
		return localContact;
	}

	@Override
	public void deleteLocalContact(LocalContact localContact) {
		hibernateTemplate.delete(localContact);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocalContact> findAllLocalContacts() {
		return hibernateTemplate.find("from LocalContact");
	}

}
