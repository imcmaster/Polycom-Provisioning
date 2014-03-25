package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FeatureElementGenerator implements ElementGenerator {

	private boolean callParkEnabled = false;
	public void setCallParkEnabled(boolean callParkEnabled) {
		this.callParkEnabled = callParkEnabled;
	}
	
	private boolean enhancedFeatureKeysEnabled = false;
	public void setEnhancedFeatureKeysEnabled(boolean enhancedFeatureKeysEnabled) {
		this.enhancedFeatureKeysEnabled = enhancedFeatureKeysEnabled;
	}
	
	private boolean presenceEnabled = false;
	public void setPresenceEnabled(boolean presenceEnabled) {
		this.presenceEnabled = presenceEnabled;
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
		
		if (enhancedFeatureKeysEnabled) {
			Element enhancedFeatureKeys = dom.createElement("feature.enhancedFeatureKeys");
			enhancedFeatureKeys.setAttribute("feature.enhancedFeatureKeys.enabled", "1");
			feature.appendChild(enhancedFeatureKeys);
		}
		
		if (presenceEnabled) {
			Element enhancedFeatureKeys = dom.createElement("feature.presence");
			enhancedFeatureKeys.setAttribute("feature.presence.enabled", "1");
			feature.appendChild(enhancedFeatureKeys);
		}
		
		return feature;
		
	}

}
