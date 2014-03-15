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
