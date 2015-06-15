package com.voxworx.polycom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	@RequestMapping(value="/polycom/phone/{phoneId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSipPhone(@PathVariable int phoneId, HttpServletRequest req) {
		logger.info("REST PUT request for phone id="+phoneId);
		ObjectMapper mapper = new ObjectMapper();
		SipPhone phone = null;
		try {
			phone = mapper.readValue(req.getReader().readLine(), SipPhone.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("got phone="+phone);
		phoneDAO.addPhone(phone);
		// Response code DEPENDS on success of DAO action!
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/phones/")
				.buildAndExpand(phoneId).toUri());
        return new ResponseEntity<String>(null, headers, HttpStatus.CREATED);

	}
	
	@RequestMapping(value="/polycom/phones", method = RequestMethod.POST)
	public ResponseEntity<?> updateSipPhones(HttpServletRequest req) {
		logger.info("REST POST request for phones");
		ObjectMapper mapper = new ObjectMapper();
		List<SipPhone> phones = null;
		try {
			//body = req.getReader().readLine();
			//phones = mapper.readValue(body, SipPhone.class);
			phones = mapper.readValue(req.getReader().readLine(), mapper.getTypeFactory().constructCollectionType(List.class, SipPhone.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO:  USE DAO to update the record
		for (SipPhone phone : phones) {
			logger.info("got phone="+phone);
			phoneDAO.addPhone(phone);
		}
		// Response code DEPENDS on success of DAO action!
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(null, headers, HttpStatus.CREATED);

	}
	
}
