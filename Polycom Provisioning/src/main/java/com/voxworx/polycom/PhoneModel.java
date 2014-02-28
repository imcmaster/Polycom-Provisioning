package com.voxworx.polycom;

public enum PhoneModel {

	SoundPointIP320(2, true, "SPIP320"),
	SoundPointIP321(2, true, "SPIP321"),
	SoundPointIP330(2, true, "SPIP330"),
	SoundPointIP331(2, true, "SPIP331"),
	SoundPointIP335(2, true, "SPIP335T"),
	SoundPointIP450(3, false, "SPIP450"),
	SoundPointIP550(4, false, "SPIP550"),
	SoundPointIP560(4, false, "SPIP560"),
	SoundPointIP600(2, false, "SPIP600"),
	SoundPointIP650(6, false, "SPIP650"),
	SoundPointIP670(6, false, "SPIP670");
	
	private final int maxLineKeys;	// Max number of 'Line' buttons enabled
	private final boolean uniqueCallersSoftKey;	// configuration tag 'softkey' requires unique tag name
	private final String tagName;	// Refer to softkey.feature.callers tag
	
	public int getMaxLineKeys() {
		return maxLineKeys;
	}
	public boolean isUniqueCallersSoftKey() {
		return uniqueCallersSoftKey;
	}
	public String getTagName() {
		return tagName;
	}

	private PhoneModel(int maxLineKeys, boolean uniqueCallersSoftKey,
			String tagName) {
		this.maxLineKeys = maxLineKeys;
		this.uniqueCallersSoftKey = uniqueCallersSoftKey;
		this.tagName = tagName;
	}
	
}
