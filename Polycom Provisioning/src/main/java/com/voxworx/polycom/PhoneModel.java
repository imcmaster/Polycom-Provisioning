package com.voxworx.polycom;

public enum PhoneModel {

	SoundPointIP320(2),
	SoundPointIP321(2),
	SoundPointIP331(2),
	SoundPointIP335(2),
	SoundPointIP450(3),
	SoundPointIP550(4),
	SoundPointIP560(4),
	SoundPointIP650(6),
	SoundPointIP670(6);
	
	private final int maxLineKeys;	// Max number of 'Line' buttons enabled
	public int getMaxLineKeys() {
		return maxLineKeys;
	}

	private PhoneModel(int maxLineKeys) {
		this.maxLineKeys = maxLineKeys;
	}
	
}
