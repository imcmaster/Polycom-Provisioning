package com.voxworx.polycom.xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.domain.DigitMap;
import com.voxworx.polycom.util.PolycomUtils;

/**
 * DigitMaps are used to allow users to dial OFFHOOK<br>
 * The digitmap is a series of allowable patterns.  If a pattern is matched, the digit sequence is sent to the SIP server
 * @author Ian
 *
 */
public class DigitMapElementGenerator implements ElementGenerator {

	private List<DigitMap> digitMaps;
	public void setDigitMaps(List<DigitMap> digitMaps) {
		this.digitMaps = digitMaps;
	}

	/**
	 * Build up the allowable dialing patterns.  The order is maintained.
	 * Polycom will match left to right (so enter accordingly)
	 * @param digitMap The pattern sequence to add next
	 */
	public void addDigitMap(DigitMap digitMap) {
		if (digitMaps == null)
			digitMaps = new ArrayList<DigitMap>();
		digitMaps.add(digitMap);
	}
	
	@Override
	public Element generateElement(Document dom) {
		Element digitMap = dom.createElement("digitmap");
		digitMap.setAttribute("dialplan.digitmap", PolycomUtils.generateDigitMapString(digitMaps));
		//TODO:  add dialplan.digitmap.timeOut
		return digitMap;
	}

}
