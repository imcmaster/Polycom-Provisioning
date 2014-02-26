package com.voxworx.polycom;

/**
 * The states the phone can be in, based on phone activity (i.e. Idle, active, etc)
 * @author Ian
 *
 */
public enum CallState {
	
	Active("active"),		// Call is connected (and not put into another state)
	Alerting("alerting"),	// Phone is ringing
	DialTone("dialtone"),	// You hear a dial tone
	Hold("hold"),		// Locally put on hold
	Idle("idle"),		// No active calls
	Proceeding("proceeding"),	// Request has been sent to phone (ends when connected)
	Setup("setup");		// Phone number is being entered, when entered state moves
				// to proceeding
	
	private final String tagName;
	public String getTagName() {
		return tagName;
	}
	private CallState(String tagName) {
		this.tagName = tagName;
	}

}
