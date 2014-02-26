package com.voxworx.polycom;

import java.util.HashSet;
import java.util.Set;

/**
 * Used to hold the information for a custom soft key (i.e. park, DND, etc)
 * @author Ian
 *
 */
public class CustomSoftKey {

	private final String label;
	private boolean enabled = true;
	private String action;
	private final Set<CallState> enabledStates;
	private boolean softKeyPositionPrecedesDefaultSoftKeys = false;		// Set to true to have soft key displayed first, OR use 'insertPosition'
	private int softKeyPosition = 0;		// If not using the above flag, you can specify where to insert this soft key
	
	public CustomSoftKey(String label) {
		super();
		this.label = label;
		enabledStates = new HashSet<CallState>();
	}

	/**
	 * Allows soft key to be enabled when a call is active
	 */
	public void enableForActiveState() {
		enabledStates.add(CallState.Active);
	}
	/**
	 * Allows soft key to be enabled when the phone is ringing
	 */
	public void enableForAlertingState() {
		enabledStates.add(CallState.Alerting);
	}
	/**
	 * Allows soft key to be enabled when the phone has a dial tone
	 */
	public void enableForDialToneState() {
		enabledStates.add(CallState.DialTone);
	}
	/**
	 * Allows soft key to be enabled when the call has been put on hold
	 */
	public void enableForHoldState() {
		enabledStates.add(CallState.Hold);
	}
	/**
	 * Allows soft key to be enabled when the phone is idle (i.e. no current call activity)
	 */
	public void enableForIdleState() {
		enabledStates.add(CallState.Idle);
	}
	/**
	 * Allows soft key to be enabled when the a request has been sent to the server to make a call (ends when connected)
	 */
	public void enableForProceedingState() {
		enabledStates.add(CallState.Proceeding);
	}
	/**
	 * Allows soft key to be enabled when a phone number is being entered; when complete the state moves
	 * to proceeding
	 */
	public void enableForSetupState() {
		enabledStates.add(CallState.Setup);
	}
	
	public String getLabel() {
		return label;
	}

	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Must be set to true to have this soft key activated (true by default)
	 * @param enabled true to activate this soft key, false otherwise
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAction() {
		return action;
	}

	/**
	 * Define the action to take when this soft key is pressed (i.e. the dial string)
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	public Set<CallState> getEnabledStates() {
		return enabledStates;
	}

	public boolean isSoftKeyPositionPrecedesDefaultSoftKeys() {
		return softKeyPositionPrecedesDefaultSoftKeys;
	}

	/**
	 * Set to true to have the soft key precede the default soft keys.  
	 * Set to false to have the soft key appear in the first empty position, or if you wish to set the position manually.<br>
	 * An alternative approach is to set the display position explicitly (NB: this boolean flag OVERRIDES any attempt 
	 * to manually set the display position)
	 * @param softKeyPositionPrecedesDefaultSoftKeys
	 */
	public void setSoftKeyPositionPrecedesDefaultSoftKeys(
			boolean softKeyPositionPrecedesDefaultSoftKeys) {
		this.softKeyPositionPrecedesDefaultSoftKeys = softKeyPositionPrecedesDefaultSoftKeys;
	}

	public int getSoftKeyPosition() {
		return softKeyPosition;
	}

	/**
	 * If you want full control over the position, you may set the order using this method.
	 * NB:  You can't use this method, and the setSoftKeyPositionPrecedesDefaultSoftKeys method together.
	 * @param softKeyPosition The ordinal position to display this soft key
	 */
	public void setSoftKeyPosition(int softKeyPosition) {
		this.softKeyPosition = softKeyPosition;
	}
	
}
