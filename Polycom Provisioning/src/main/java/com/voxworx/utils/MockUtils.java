package com.voxworx.utils;

import com.voxworx.polycom.PhoneModel;
import com.voxworx.polycom.domain.SipPhone;

public class MockUtils {

	public static SipPhone createSipPhone() {
		SipPhone p = new SipPhone();
		p.setMac("00041fbc1012");
		p.setModel(PhoneModel.SoundPointIP335);
		p.setUserId("103");
		p.setPassword("123");
		return p;
	}
	
}
