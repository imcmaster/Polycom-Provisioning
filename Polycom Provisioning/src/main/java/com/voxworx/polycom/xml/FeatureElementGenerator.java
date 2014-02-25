package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FeatureElementGenerator implements ElementGenerator {

	private boolean callParkEnabled = false;
	public void setCallParkEnabled(boolean callParkEnabled) {
		this.callParkEnabled = callParkEnabled;
	}

	@Override
	public Element generateElement(Document dom) {

		Element feature = dom.createElement("feature");
		feature.setAttribute("feature.autoLocalHold", "0");
		
		// Call park/retrieve
		if (callParkEnabled) {
			Element callPark = dom.createElement("feature.callPark");
			callPark.setAttribute("feature.callPark.enabled", "1");
			feature.appendChild(callPark);
		}
		
		return feature;
		
	}

}
