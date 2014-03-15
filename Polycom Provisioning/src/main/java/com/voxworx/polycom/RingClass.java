package com.voxworx.polycom;

/**
 * Ring classes encapsulate a ring behaviour (ring and the ringer type, or auto answer, etc).
 * Used, for at least Alert-Info mapping (i.e. distinct ringing mappings)
 * @author Ian
 *
 */
public enum RingClass {
	
	DEFAULT("default"), 
	VISUAL("visual"), 
	ANSWERMUTE("answerMute"), 
	AUTOANSWER("autoAnswer"), 
	RINGANSWERMUTE("ringAnswerMute"), 
	RINGAUTOANSWER("ringAutoAnswer"), 
	INTERNAL("internal"), 
	EXTERNAL("external"), 
	EMERGENCY("emergency"), 
	PRECEDENCE("precedence"),
	SPLASH("splash"),
	CUSTOM1("custom1"),
	CUSTOM2("custom2"),
	CUSTOM3("custom3"),
	CUSTOM4("custom4"),
	CUSTOM5("custom5"),
	CUSTOM6("custom6"),
	CUSTOM7("custom7"),
	CUSTOM8("custom8"),
	CUSTOM9("custom9"),
	CUSTOM10("custom10"),
	CUSTOM11("custom11"),
	CUSTOM12("custom12"),
	CUSTOM13("custom13"),
	CUSTOM14("custom14"),
	CUSTOM15("custom15"),
	CUSTOM16("custom16"),
	CUSTOM17("custom17");
	
	private final String ringClassName;
	public String getRingClassName() {
		return ringClassName;
	}

	private RingClass(String ringClassName) {
		this.ringClassName = ringClassName;
	}
	
}
