package com.voxworx.polycom.xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.RingClassParameters;

/**
 * Builds XML for a ring class (i.e. se.rt.classname.xxxx)
 * Used for (at least) distinctive ringing
 * @author Ian
 *
 */
public class RingClassElementGenerator implements ElementGenerator {

	private final List<RingClassParameters> ringClassParameters = new ArrayList<RingClassParameters>();

	public void addRingClassParameter(RingClassParameters ringClassParameter) {
		ringClassParameters.add(ringClassParameter);
	}
	
	@Override
	public Element generateElement(Document dom) {
		
		Element se = dom.createElement("se");
		Element seRingTone = dom.createElement("se.rt");
		se.appendChild(seRingTone);
		
		for (RingClassParameters rcp : ringClassParameters) {
			Element rcpTag = dom.createElement(buildTagName(rcp.getRingClass().getRingClassName()));
			rcpTag.setAttribute(buildAttributeName(rcp.getRingClass().getRingClassName(), "callWait"), rcp.getCallProgressCallWait().getCallProgressName());
			rcpTag.setAttribute(buildAttributeName(rcp.getRingClass().getRingClassName(), "micMute"), rcp.isMicMute() ? "1" : "0");
			rcpTag.setAttribute(buildAttributeName(rcp.getRingClass().getRingClassName(), "name"), rcp.getName());
			rcpTag.setAttribute(buildAttributeName(rcp.getRingClass().getRingClassName(), "ringer"), rcp.getRingTone().getRingerName());
			rcpTag.setAttribute(buildAttributeName(rcp.getRingClass().getRingClassName(), "timeout"), Integer.valueOf(rcp.getRingTimeout()).toString());
			rcpTag.setAttribute(buildAttributeName(rcp.getRingClass().getRingClassName(), "type"), rcp.getAnswerMode().getAnswerModeType());
			seRingTone.appendChild(rcpTag);
		}
		
		return se;
	}

	private String buildTagName(String rtName) {
		StringBuffer s = new StringBuffer();
		s.append("se.rt.");
		s.append(rtName);
		return s.toString();
	}
	
	private String buildAttributeName(String rtName, String rtAttribute) {
		StringBuffer s = new StringBuffer(buildTagName(rtName));
		s.append(".");
		s.append(rtAttribute);
		return s.toString();
	}

}
