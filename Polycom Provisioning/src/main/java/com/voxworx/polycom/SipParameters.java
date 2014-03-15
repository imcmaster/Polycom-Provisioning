package com.voxworx.polycom;

import java.util.ArrayList;
import java.util.List;

/**
 * Information needed to build voIpProt.SIP
 * @author Ian
 *
 */
public class SipParameters {

	/**
	 * The SIP server may send an Alert-Info header.  The name provided will map to an internal ring class
	 * @author Ian
	 *
	 */
	public class AlertInfo {
		private final String headerValue;		// The string that will appear in the Alert-Info header
		private final RingClass ringClass;	// The ring class to use for this Alert-Info header
		public AlertInfo(String headerValue, RingClass ringClass) {
			super();
			this.headerValue = headerValue;
			this.ringClass = ringClass;
		}
		public String getHeaderValue() {
			return headerValue;
		}
		public RingClass getRingClass() {
			return ringClass;
		}
	}

	private final List<AlertInfo> alertInfoMappings = new ArrayList<AlertInfo>();
	public List<AlertInfo> getAlertInfoMappings() {
		return alertInfoMappings;
	}

	/**
	 * Add an alert-info mapping (i.e. alert-info header will map to a ring class)
	 * Used for distinctive ringing
	 * @param headerValue The alert-info header value (as populated by the SIP server)
	 * @param mappedRingClass The ring class to map this request to
	 */
	public void addAlertInfoMapping(String headerValue, RingClass mappedRingClass) {
		alertInfoMappings.add(new AlertInfo(headerValue, mappedRingClass));
	}
	
}
