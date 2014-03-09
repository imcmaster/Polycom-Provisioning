package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class UserPreferenceElementGenerator implements ElementGenerator {

	private boolean enableVoiceMail = false;
	public void setEnableVoiceMail(boolean enableVoiceMail) {
		this.enableVoiceMail = enableVoiceMail;
	}

	@Override
	public Element generateElement(Document dom) {
		Element up = dom.createElement("up");
		if (enableVoiceMail) {
			up.setAttribute("up.oneTouchVoiceMail", "1");
			up.setAttribute("up.mwiVisible", "1");
		}
		return up;
	}

}
