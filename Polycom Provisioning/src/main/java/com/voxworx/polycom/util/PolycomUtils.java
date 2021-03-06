package com.voxworx.polycom.util;

import java.util.List;

import com.voxworx.polycom.CustomSoftKey;
import com.voxworx.polycom.RingClass;
import com.voxworx.polycom.RingClassParameters;
import com.voxworx.polycom.RingTone;
import com.voxworx.polycom.domain.Digit;
import com.voxworx.polycom.domain.DigitMap;
import com.voxworx.polycom.domain.NatParameters;

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
		s.append("$Tdtmf$");		// dtmf to extension 'parkExtension'
		parkSoftKey.setAction(s.toString());
		parkSoftKey.setSoftKeyPositionPrecedesDefaultSoftKeys(true);
		return parkSoftKey;
	}
	
	/**
	 * Convenience method to create a Ring Class used for distinctive ringing
	 * @param ringClass The name of the ring class (fixed by enum)
	 * @param name A friendly name
	 * @param ringTone The ring tone to use for this class (which overrides the default Lowest Trill 2)
	 * @return The populated object (other data is defaulted)
	 */
	public static RingClassParameters createRingClassUsingRingTone(RingClass ringClass, String name, RingTone ringTone) {
		RingClassParameters rcp = new RingClassParameters(ringClass, name);
		rcp.setRingTone(ringTone);
		return rcp;
	}
	
	/**
	 * Creates the nat object needed to build the nat tag.
	 * The defaults are:
	 * keepalive = 30 seconds
	 * sip port = 5060
	 * rtp media port start = 10000
	 * @param ip
	 * @return
	 */
	public static NatParameters createDefaultNatParameters(String ip) {
		NatParameters nat = new NatParameters();
		nat.setIp(ip);
		nat.setKeepAliveInterval(30);
		nat.setRtpMediaPortStart(10000);
		nat.setSipPort(5060);
		return nat;
	}
	
}
