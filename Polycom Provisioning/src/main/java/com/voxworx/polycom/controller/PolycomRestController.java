package com.voxworx.polycom.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.voxworx.polycom.dao.PhoneDAO;
import com.voxworx.polycom.domain.SipPhone;

@Controller
public class PolycomRestController {

	private static final Logger logger = Logger.getLogger(PolycomRestController.class);
	
	private PhoneDAO phoneDAO;
	@Autowired
	public void setPhoneDAO(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}
	
	@RequestMapping(value="/polycom/phones", method = RequestMethod.GET)
	@ResponseBody
	public List<SipPhone> getSipPhones() {
		logger.info("REST GET request for phones");
		return phoneDAO.findAll();
	}

	@RequestMapping(value="/polycom/phone/{phoneId}", method = RequestMethod.GET)
	@ResponseBody
	public SipPhone getSipPhone(@PathVariable int phoneId) {
		logger.info("REST GET request for phone id="+phoneId);
		return phoneDAO.findById(phoneId);
	}
	 
}
