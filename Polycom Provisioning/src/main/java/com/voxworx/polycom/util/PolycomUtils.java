package com.voxworx.polycom.util;

import java.util.List;

import com.voxworx.polycom.domain.DigitMap;

public class PolycomUtils {

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
	
}
