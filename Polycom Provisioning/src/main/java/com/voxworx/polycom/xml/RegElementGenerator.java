package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.SipRegistrar;
import com.voxworx.polycom.domain.SipPhone;

/**
 * Responsible for generating the reg tag
 * TODO:  Ability to have multiple reg lines (.1, .2, etc)
 * @author Ian
 *
 */
public class RegElementGenerator implements ElementGenerator {

	private final SipPhone sipPhone;
	private final SipRegistrar sipRegistrar;
	
	public RegElementGenerator(SipPhone sipPhone, SipRegistrar sipRegistrar) {
		super();
		this.sipPhone = sipPhone;
		this.sipRegistrar = sipRegistrar;
	}

	@Override
	public Element generateElement(Document dom) {

		Element reg = dom.createElement("reg");
/*
		<reg reg.1.displayName="102"/>
*/
		
		reg.setAttribute("reg.1.label", sipPhone.getUserId());
		reg.setAttribute("reg.1.address", sipPhone.getUserId());
		
		reg.setAttribute("reg.1.auth.userId", sipPhone.getUserId());
		reg.setAttribute("reg.1.auth.password", sipPhone.getPassword());

		reg.setAttribute("reg.1.ringType", Integer.valueOf(sipPhone.getRingTone().getRingToneIndex()).toString());
		reg.setAttribute("reg.1.type", "private");
		reg.setAttribute("reg.1.lineKeys", Integer.valueOf(sipPhone.getNumberLineKeys()).toString());
		
		reg.setAttribute("reg.1.server.1.address", sipRegistrar.getIpAddress());
		reg.setAttribute("reg.1.server.1.port", sipRegistrar.getPort());
		reg.setAttribute("reg.1.server.1.transport", "DNSnaptr");
		reg.setAttribute("reg.1.server.1.register", "1");
		
		return reg;
		
	}

}
