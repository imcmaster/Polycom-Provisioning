package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.CallState;
import com.voxworx.polycom.CustomSoftKey;
import com.voxworx.polycom.SoftKeyProfile;

/**
 * Given the soft key profile, generates the softkey configuration tag information
 * @author Ian
 *
 */
public class SoftKeyElementGenerator implements ElementGenerator {

	private final SoftKeyProfile softKeyProfile;
	
	public SoftKeyElementGenerator(SoftKeyProfile softKeyProfile) {
		super();
		this.softKeyProfile = softKeyProfile;
	}

	@Override
	public Element generateElement(Document dom) {

		Element softKeyTag = dom.createElement("softkey");

		// Custom soft keys
		int customSoftKeyIndex = 1;
		for (CustomSoftKey customSoftKey : softKeyProfile.getCustomSoftKeys()) {

			softKeyTag.setAttribute(generateSoftKeyWithIndex(customSoftKeyIndex, "action"), customSoftKey.getAction());
			softKeyTag.setAttribute(generateSoftKeyWithIndex(customSoftKeyIndex, "enable"), customSoftKey.isEnabled() ? "1" : "0");
			softKeyTag.setAttribute(generateSoftKeyWithIndex(customSoftKeyIndex, "label"), customSoftKey.getLabel());
			softKeyTag.setAttribute(generateSoftKeyWithIndex(customSoftKeyIndex, "precede"), 
					customSoftKey.isSoftKeyPositionPrecedesDefaultSoftKeys() ? "1" : "0");
			if (!customSoftKey.isSoftKeyPositionPrecedesDefaultSoftKeys()) {
				softKeyTag.setAttribute(generateSoftKeyWithIndex(customSoftKeyIndex, "insert"), 
						Integer.valueOf(customSoftKey.getSoftKeyPosition()).toString());
			}
			
			// Call states
			for (CallState callState : CallState.values()) {
				int state = 0;
				if (customSoftKey.getEnabledStates().contains(callState))
					state = 1;
				softKeyTag.setAttribute(generateUseSoftKeyWithIndex(customSoftKeyIndex, callState.getTagName()), Integer.valueOf(state).toString());
			}
			
			customSoftKeyIndex++;
		}
		
		// Default soft keys 'softkey.feature'
		Element featureTag = dom.createElement("softkey.feature");
		featureTag.setAttribute(generateFeatureTag("buddies"), "0");
		if (softKeyProfile.getPhoneModel().isUniqueCallersSoftKey()) {
			featureTag.setAttribute(generateFeatureTagIncludingModel("callers", softKeyProfile.getPhoneModel().getTagName()), 
					softKeyProfile.isCallersEnabled() ? "1" : "0");
			featureTag.setAttribute(generateFeatureTagIncludingModel("directories", softKeyProfile.getPhoneModel().getTagName()), 
					softKeyProfile.isDirectoriesEnabled() ? "1" : "0");
		} else {
			featureTag.setAttribute(generateFeatureTag("callers"), softKeyProfile.isCallersEnabled() ? "1" : "0");
			featureTag.setAttribute(generateFeatureTag("directories"), softKeyProfile.isDirectoriesEnabled() ? "1" : "0");
		}
		featureTag.setAttribute(generateFeatureTag("endcall"), softKeyProfile.isEndCallEnabled() ? "1" : "0");
		featureTag.setAttribute(generateFeatureTag("forward"), softKeyProfile.isForwardEnabled() ? "1" : "0");
		featureTag.setAttribute(generateFeatureTag("join"), softKeyProfile.isJoinEnabled() ? "1" : "0");
		featureTag.setAttribute(generateFeatureTag("mystatus"), softKeyProfile.isMyStatusEnabled() ? "1" : "0");
		featureTag.setAttribute(generateFeatureTag("newcall"), softKeyProfile.isNewCallEnabled() ? "1" : "0");
		featureTag.setAttribute(generateFeatureTag("split"), softKeyProfile.isSplitEnabled() ? "1" : "0");
		
		softKeyTag.appendChild(featureTag);
		
		// Default basic call mgt
		Element callMgtTag = dom.createElement("softkey.feature.basicCallManagement");
		callMgtTag.setAttribute("softkey.feature.basicCallManagement.redundant", "1");
		softKeyTag.appendChild(callMgtTag);
		
		return softKeyTag;
		
	}
	
	/**
	 * Generate 'softkey.feature.attribute'
	 * @param attributeName The attribute
	 * @return The full string ready for use as an attribute
	 */
	private String generateFeatureTag(String attributeName) {
		StringBuffer s = new StringBuffer();
		s.append("softkey.feature.");
		s.append(attributeName);
		return s.toString();
		
	}

	/**
	 * Generate 'softkey.feature.callers.model' tag
	 * @param attributeName callers, or directories
	 * @param model The short form of the phone model, used by this tag
	 * @return The full string ready for use as an attribute
	 */
	private String generateFeatureTagIncludingModel(String attributeName, String model) {
		StringBuffer s = new StringBuffer();
		s.append("softkey.feature.");
		s.append(attributeName);
		s.append(".");
		s.append(model);
		return s.toString();
	}

	/**
	 * Generate the string 'softkey.index.attributeName'
	 * @param index The index, starting with 1
	 * @param attributeName The attribute name, which follows the index
	 * @return The string ready to be used as a softkey attribute tag
	 */
	private String generateSoftKeyWithIndex(int index, String attributeName) {
		StringBuffer s = new StringBuffer();
		s.append("softkey.");
		s.append(index);
		s.append(".");
		s.append(attributeName);
		return s.toString();
	}

	/**
	 * Generate the string 'softkey.index.use.useName'
	 * @param index The index, starting with 1
	 * @param useName The useName (i.e. call state)
	 * @return The full string ready to be used as a tag name
	 */
	private String generateUseSoftKeyWithIndex(int index, String useName) {
		StringBuffer s = new StringBuffer();
		s.append("softkey.");
		s.append(index);
		s.append(".use.");
		s.append(useName);
		return s.toString();
	}

}
