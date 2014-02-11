package com.voxworx.polycom.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

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

	@Override
	public SipPhone findByExtension(String extension) {
		return null;
	}

}
