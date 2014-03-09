package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.voxworx.polycom.domain.SipPhone;

/**
 * a)  Causes the phone to SUBSCIBE for messages<br>
 * b)  Assigns a behavior to the retrieval button (either call own extension, or a system extension)
 * @author Ian
 *
 */
public class MessageWaitingElementGenerator implements ElementGenerator {

	private enum RETRIEVAL_MODE {
		SYSTEM_VOICEMAIL_EXTENSION,
		PHONE_DIALS_OWN_EXTENSION;
	}
	
	private final SipPhone sipPhone;
	private RETRIEVAL_MODE mode = RETRIEVAL_MODE.PHONE_DIALS_OWN_EXTENSION;
	private String systemVoiceMailExtension = "";
	
	public MessageWaitingElementGenerator(SipPhone sipPhone) {
		super();
		this.sipPhone = sipPhone;
	}
	
	/**
	 * By default, pressing the Messages key will cause the phone to 'dial its own extension'.
	 * To override this behaviour and dial a fixed voicemail extension, use this method.
	 * @param systemVoiceMailExtension The system voice mail extension
	 */
	public void setSystemVoiceMailExtension(String systemVoiceMailExtension) {
		mode = RETRIEVAL_MODE.SYSTEM_VOICEMAIL_EXTENSION;
		this.systemVoiceMailExtension = systemVoiceMailExtension;
	}

	@Override
	public Element generateElement(Document dom) {

		Element msg = dom.createElement("msg");
		
		msg.setAttribute("msg.mwi.1.subscribe", sipPhone.getUserId());	// SIP SUBSCRIBE (for NOTIFY messages)
		if (mode == RETRIEVAL_MODE.SYSTEM_VOICEMAIL_EXTENSION) {
			msg.setAttribute("msg.mwi.1.callBackMode", "contact");
			msg.setAttribute("msg.mwi.1.callBack", systemVoiceMailExtension);
		} else {
			msg.setAttribute("msg.mwi.1.callBackMode", "registration");
		}
		
		return msg;
		
	}

}
