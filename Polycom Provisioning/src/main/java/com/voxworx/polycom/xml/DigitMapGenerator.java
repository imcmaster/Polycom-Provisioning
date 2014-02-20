package com.voxworx.polycom.xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.domain.DigitMap;
import com.voxworx.polycom.util.PolycomUtils;

public class DigitMapGenerator implements ElementGenerator {

	List<DigitMap> digitMaps;
	
	public void addDigitMap(DigitMap digitMap) {
		if (digitMaps == null)
			digitMaps = new ArrayList<DigitMap>();
		digitMaps.add(digitMap);
	}
	
	@Override
	public Element generateElement(Document dom) {
		Element digitMap = dom.createElement("digitmap");
		digitMap.setAttribute("dialplan.digitmap", PolycomUtils.generateDigitMapString(digitMaps));
		return digitMap;
	}

}
