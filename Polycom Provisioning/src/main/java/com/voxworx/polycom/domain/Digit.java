package com.voxworx.polycom.domain;

import com.voxworx.polycom.DigitMapGenerator;

public class Digit implements DigitMapGenerator {

	private boolean isRange = false;
	private int startDigit = 0;
	private int endDigit = 0;
	
	public Digit(int exactDigit) {
		this.isRange = false;
		this.startDigit = exactDigit;
	}
	
	public Digit(int startDigit, int endDigit) {
		this.isRange = true;
		this.startDigit = startDigit;
		this.endDigit = endDigit;
	}
	
	@Override
	public String generateDigitMapString() {
		StringBuffer s = new StringBuffer();
		if (isRange)
			s.append("[");
		s.append(startDigit);
		if (isRange) {
			s.append("-");
			s.append(endDigit);
			s.append("]");
		}
		return s.toString();
	}

}
