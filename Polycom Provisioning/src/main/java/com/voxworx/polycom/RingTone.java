package com.voxworx.polycom;

/**
 * Collection of ring tones available for phones.
 * Used to set the ringType in the configuration files reg.1.ringType
 * @author Ian
 *
 */
public enum RingTone {

	SilentRing(1, "Silent Ring"),
	LowTrill(2, "Low Trill"),
	LowDoubleTrill(3, "Low Double Trill"),
	MediumTrill(4, "Medium Trill"),
	MediumDoubleTrill(5, "Medium Double Trill"),
	HighTrill(6, "High Trill"),
	HighDoubleTrill(7, "High Double Trill"),
	HighestTrill(8, "Highest Trill"),
	HighestDoubleTrill(9, "Highest Double Trill"),
	Beeble(10, "Beeble"),
	Triplet(11, "Triplet"),
	RingbackStyle(12, "Ringback style"),
	LowTrillPrecedence(13, "Low Trill Precedence"),
	RingSplash(14, "Splash");
	
	private final int ringToneIndex;	// Code used in the XML conf files
	private final String description;	// Friendly description
	
	public int getRingToneIndex() {
		return ringToneIndex;
	}
	public String getDescription() {
		return description;
	}

	private RingTone(int ringToneIndex, String description) {
		this.ringToneIndex = ringToneIndex;
		this.description = description;
	}
	
	
}
