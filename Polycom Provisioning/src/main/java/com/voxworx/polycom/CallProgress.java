package com.voxworx.polycom;

/**
 * Call Progress tones available for use with polycom
 * Used (at least for) creating distinct ring patterns
 * @author Ian
 *
 */
public enum CallProgress {
	
	ALERTING("alerting", "Alerting tone"),
	BARGEIN("bargeIn", "Barge-in tone"),
	BUSYTONE("busyTone", "Busy tone"),
	CALLWAITING("callWaiting", "Call waiting tone"),
	CALLWAITINGLONG("callWaitingLong", "Call waiting tone long (distinctive)"),
	CONFIRMATION("confirmation", "Confirmation tone"),
	DIALTONE("dialTone", "Dial tone"),
	HOWLER("howler", "Howler tone (off-hook warning)"),
	INTERCOM("intercom", "Intercom announcement tone"),
	MSGWAITING("msgWaiting", "Message waiting tone"),
	PRECEDENCECALLWAITING("precedenceCallWaiting", "Precedence call waiting tone"),
	PRECEDENCERINGBACK("precedenceRingback", "Precedence ringback tone"),
	PREEMPTION("preemption", "Preemption tone"),
	PRECEDENCE("precedence", "Precedence tone"),
	RECWARNING("recWarning", "Record warning"),
	REORDER("reorder", "Reorder tone"),
	RINGBACK("ringback", "Ringback tone"),
	SECONDARYDIALTONE("secondaryDialTone", "Secondary dial tone"),
	STUTTER("stutter", "Stuttered dial tone");
	
	private final String callProgressName;
	private final String callProgressDescription;
	public String getCallProgressName() {
		return callProgressName;
	}
	public String getCallProgressDescription() {
		return callProgressDescription;
	}
	private CallProgress(String callProgressName, String callProgressDescription) {
		this.callProgressName = callProgressName;
		this.callProgressDescription = callProgressDescription;
	}
	
}
