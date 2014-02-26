package com.voxworx.polycom;

import java.util.ArrayList;
import java.util.List;

/**
 * The state of default soft keys, and any user defined soft keys.
 * Once populated, used to generate the softkey configuration tag<br>
 * Usage:  a)  Turn on/off the default soft keys
 * b)  Create and add any custom soft keys
 * @author Ian
 *
 */
public class SoftKeyProfile {

	private final PhoneModel phoneModel;

	private boolean newCallEnabled = true;	// 'New Call' soft key
	private boolean endCallEnabled = true;	// 'End Call' soft key
	private boolean splitEnabled = false;	// 'Split' soft key (conference)
	private boolean joinEnabled = true;		// 'Join' soft key (conference)
	private boolean forwardEnabled = true;	// 'Forward' soft key
	private boolean directoriesEnabled = true;	// 'Dir' soft key
	private boolean callersEnabled = true;	// 'Callers' soft key
	private boolean myStatusEnabled = true;	// 'MyStatus' soft key (?)
	private boolean holdTransferConferenceEnabled = true;	// Represents 3 key
															// Must be true for 32x/33x phones
	private final List<CustomSoftKey> customSoftKeys;
	
	public SoftKeyProfile(PhoneModel phoneModel) {
		super();
		this.phoneModel = phoneModel;
		this.customSoftKeys = new ArrayList<CustomSoftKey>();
	}
	
	/**
	 * Add a custom soft key (in addition to the default soft keys)
	 * @param customSoftKey The custom soft key to add
	 */
	public void addCustomSoftKey(CustomSoftKey customSoftKey) {
		customSoftKeys.add(customSoftKey);
	}

	public PhoneModel getPhoneModel() {
		return phoneModel;
	}

	public boolean isNewCallEnabled() {
		return newCallEnabled;
	}

	public void setNewCallEnabled(boolean newCallEnabled) {
		this.newCallEnabled = newCallEnabled;
	}

	public boolean isEndCallEnabled() {
		return endCallEnabled;
	}

	public void setEndCallEnabled(boolean endCallEnabled) {
		this.endCallEnabled = endCallEnabled;
	}

	public boolean isSplitEnabled() {
		return splitEnabled;
	}

	public void setSplitEnabled(boolean splitEnabled) {
		this.splitEnabled = splitEnabled;
	}

	public boolean isJoinEnabled() {
		return joinEnabled;
	}

	public void setJoinEnabled(boolean joinEnabled) {
		this.joinEnabled = joinEnabled;
	}

	public boolean isForwardEnabled() {
		return forwardEnabled;
	}

	public void setForwardEnabled(boolean forwardEnabled) {
		this.forwardEnabled = forwardEnabled;
	}

	public boolean isDirectoriesEnabled() {
		return directoriesEnabled;
	}

	public void setDirectoriesEnabled(boolean directoriesEnabled) {
		this.directoriesEnabled = directoriesEnabled;
	}

	public boolean isCallersEnabled() {
		return callersEnabled;
	}

	public void setCallersEnabled(boolean callersEnabled) {
		this.callersEnabled = callersEnabled;
	}

	public boolean isMyStatusEnabled() {
		return myStatusEnabled;
	}

	public void setMyStatusEnabled(boolean myStatusEnabled) {
		this.myStatusEnabled = myStatusEnabled;
	}

	public boolean isHoldTransferConferenceEnabled() {
		return holdTransferConferenceEnabled;
	}

	public void setHoldTransferConferenceEnabled(
			boolean holdTransferConferenceEnabled) {
		this.holdTransferConferenceEnabled = holdTransferConferenceEnabled;
	}

	public List<CustomSoftKey> getCustomSoftKeys() {
		return customSoftKeys;
	}


}
