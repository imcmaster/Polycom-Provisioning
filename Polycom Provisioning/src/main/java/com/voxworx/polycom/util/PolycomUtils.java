package com.voxworx.polycom.util;

import java.util.List;

import com.voxworx.polycom.CustomSoftKey;
import com.voxworx.polycom.domain.Digit;
import com.voxworx.polycom.domain.DigitMap;

public class PolycomUtils {

	/**
	 * Creates the digit map string, including delimter '|' between unique digit maps.  Order counts!
	 * @param digitMaps The ordered list of the digit maps
	 * @return The string used by the digitmap tag
	 */
	public static String generateDigitMapString(List<DigitMap> digitMaps) {
		StringBuffer s = new StringBuffer();
		boolean addSeparator = false;
		for (DigitMap digitMap : digitMaps) {
			if (addSeparator)
				s.append("|");
			s.append(digitMap.generateDigitMapString());
			addSeparator = true;
		}
		return s.toString();
	}
	
	/**
	 * Create a DigitMap for a local extension
	 * @param startRange The first digit lowest number (ie. 2 if 2-9)
	 * @param endRange The first digit highest number (i.e. 9 if 2-9)
	 * @param totalNumber The length of the local extension
	 * @param addTimeout true if a timeout should be appended
	 * @return The DigitMap that represents a local extension
	 */
	public static DigitMap generateLocalExtension(int startRange, int endRange, int totalNumber, boolean addTimeout) {
		DigitMap m = new DigitMap();
		m.addDigit(new Digit(startRange, endRange));
		m.setDigitMapLength(totalNumber);
		m.setAddTimeout(addTimeout);
		return m;
	}
	
	/**
	 * Convenience method to create a Park soft key (using *1$Tdtmf$)
	 * Will place the Park soft key before the default keys ('precede')
	 * @return The instance of a new park soft key
	 */
	public static CustomSoftKey createCustomSoftKeyPark(String starCode) {
		CustomSoftKey parkSoftKey = new CustomSoftKey("Park");
		parkSoftKey.enableForActiveState();
		StringBuffer s = new StringBuffer(starCode);
		s.append("$dtmf$");		// SIP INVITE packet to extension 'parkExtension'
		parkSoftKey.setAction(s.toString());
		parkSoftKey.setSoftKeyPositionPrecedesDefaultSoftKeys(true);
		return parkSoftKey;
	}
	
}
