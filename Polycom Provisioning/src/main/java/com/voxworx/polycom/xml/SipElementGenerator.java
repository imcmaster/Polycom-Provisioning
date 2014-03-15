package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.SipParameters;

/**
 * Generates the voIpProt tag 
 * (For now just the alertInfo tags)
 * @author Ian
 *
 */
public class SipElementGenerator implements ElementGenerator {

	private final SipParameters sipParameters;
	public SipElementGenerator(SipParameters sipParameters) {
		super();
		this.sipParameters = sipParameters;
	}

	@Override
	public Element generateElement(Document dom) {
		Element voipTag = dom.createElement("voIpProt");
		Element sipTag = dom.createElement("voIpProt.SIP");
		voipTag.appendChild(sipTag);
		Element alertInfoTag = dom.createElement("voIpProt.SIP.alertInfo");
		sipTag.appendChild(alertInfoTag);
		int i = 1;
		for (SipParameters.AlertInfo alertInfo : sipParameters.getAlertInfoMappings()) {
			alertInfoTag.setAttribute(buildAttributeName(i, "value"), alertInfo.getHeaderValue());
			alertInfoTag.setAttribute(buildAttributeName(i, "class"), alertInfo.getRingClass().getRingClassName());
			i++;
		}
		return voipTag;
	}
	
	private String buildAttributeName(int index, String attributeName) {
		StringBuffer s = new StringBuffer();
		s.append("voIpProt.SIP.alertInfo.");
		s.append(index);
		s.append(".");
		s.append(attributeName);
		return s.toString();
	}

}
