package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.domain.NatParameters;

public class NatElementGenerator implements ElementGenerator {

	private final NatParameters natParameters;
	public NatElementGenerator(NatParameters nat) {
		super();
		this.natParameters = nat;
	}

	@Override
	public Element generateElement(Document dom) {

		Element nat = dom.createElement("nat");
		nat.setAttribute("nat.ip", natParameters.getIp());
		nat.setAttribute("nat.mediaPortStart", Integer.valueOf(natParameters.getRtpMediaPortStart()).toString());
		nat.setAttribute("nat.signalPort", Integer.valueOf(natParameters.getSipPort()).toString());
		
		Element keepalive = dom.createElement("nat.keepalive");
		keepalive.setAttribute("nat.keepalive.interval", Integer.valueOf(natParameters.getKeepAliveInterval()).toString());
		
		nat.appendChild(keepalive);
		
		return nat;
	}

}
