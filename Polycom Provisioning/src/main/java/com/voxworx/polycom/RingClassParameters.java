package com.voxworx.polycom;

/**
 * The values needed to build a ring tone tag (i.e. se.rt.ringclass.xxxx)
 * Used for controlling distinctive ringing, etc
 * @author Ian
 *
 */
public class RingClassParameters {

	private final RingClass ringClass;
	private final String name;
	private CallProgress callProgressCallWait;
	private boolean micMute;
	private RingTone ringTone;
	private int ringTimeout;
	private AnswerMode answerMode;
	
	public RingClassParameters(RingClass ringClass, String name) {
		super();
		this.ringClass = ringClass;
		this.name = name;
		this.callProgressCallWait = CallProgress.CALLWAITING;
		this.micMute = false;
		this.ringTone = RingTone.LowTrill;
		this.ringTimeout = 2000;
		this.answerMode = AnswerMode.RING;
	}

	public CallProgress getCallProgressCallWait() {
		return callProgressCallWait;
	}

	public void setCallProgressCallWait(CallProgress callProgressCallWait) {
		this.callProgressCallWait = callProgressCallWait;
	}

	public boolean isMicMute() {
		return micMute;
	}

	public void setMicMute(boolean micMute) {
		this.micMute = micMute;
	}

	public RingTone getRingTone() {
		return ringTone;
	}

	public void setRingTone(RingTone ringTone) {
		this.ringTone = ringTone;
	}

	public int getRingTimeout() {
		return ringTimeout;
	}

	/**
	 * Timeout is in milliseconds (i.e. 2000 = 2 seconds)
	 * @param ringTimeout Timer in milliseconds
	 */
	public void setRingTimeout(int ringTimeout) {
		this.ringTimeout = ringTimeout;
	}

	public AnswerMode getAnswerMode() {
		return answerMode;
	}

	public void setAnswerMode(AnswerMode answerMode) {
		this.answerMode = answerMode;
	}

	public RingClass getRingClass() {
		return ringClass;
	}

	public String getName() {
		return name;
	}
	
	
}
