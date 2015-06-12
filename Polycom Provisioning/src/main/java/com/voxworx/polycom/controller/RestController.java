package com.voxworx.polycom.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voxworx.polycom.dao.PhoneDAO;
import com.voxworx.polycom.domain.SipPhone;

@Controller
public class RestController {

	private static final Logger logger = Logger.getLogger(RestController.class);
	
	private PhoneDAO phoneDAO;
	@Autowired
	public void setPhoneDAO(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}
	
	@RequestMapping(value="/polycom/phones", method = RequestMethod.GET)
	public List<SipPhone> getSipPhone() {
		logger.info("REST GET request for phones");
		return phoneDAO.findAll();
	}
	 
}
