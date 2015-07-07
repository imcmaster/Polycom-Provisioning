package com.voxworx.polycom;

import java.util.ArrayList;
import java.util.List;

/**
 * Information needed to build voIpProt.SIP
 * @author Ian
 *
 */
public class SipParameters {


	private final List<RingClass> alertInfoMappings = new ArrayList<RingClass>();

	/**
	 * If set, the voIpProt.SIP.requestValidation tag will be added, with a method=source, and request=INVITE
	 * This will protect the phone from receiving INVITES from unauthorized sources (i.e. Internet robots).
	 * The protection was required for a NAT phone, where the local router needed to add PORT FORWARDING
	 * of sip:5060 directly to the IP address of the phone (leaving it wide open to an Internet INVITE)
	 * @return true if a request validation tag will be generated, false otherwise
	 */
	public List<RingClass> getAlertInfoMappings() {
		return alertInfoMappings;
	}

	/**
	 * Add an alert-info mapping (i.e. alert-info header will map to a ring class)
	 * Used for distinctive ringing
	 * @param headerValue The alert-info header value (as populated by the SIP server)
	 * @param mappedRingClass The ring class to map this request to
	 */
	public void addAlertInfoMapping(RingClass mappedRingClass) {
		alertInfoMappings.add(mappedRingClass);
	}
	
}
