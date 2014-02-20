package com.voxworx.polycom.domain;

import java.util.ArrayList;
import java.util.List;

import com.voxworx.polycom.DigitMapGenerator;

public class DigitMap implements DigitMapGenerator {

	public static final String ANY_DIGIT = "x";
	public static final String OR_LONGER = ".";
	public static final String TIMEOUT = "T";
	
	private List<Digit> digits;				// A list of specific digits to start the digit map
	private boolean addTimeout = false;		// if true, a 'T' is appended	
	private int digitMapLength = 0;			// Allows for 'x' to supplement any specific digits
	private boolean isLengthFixed = true;	// If false, a '.' is appended

	public boolean isAddTimeout() {
		return addTimeout;
	}

	/**
	 * If set to true, will append a 'T' to the digitmap.
	 * A timeout is used to 'wait' for another digit.  If you are using an exact map, set to 'false'
	 * @param addTimeout
	 */
	public void setAddTimeout(boolean addTimeout) {
		this.addTimeout = addTimeout;
	}

	public int getDigitMapLength() {
		return digitMapLength;
	}

	/**
	 * Set to the total number of digits which will be used in the map, and represented by a symbol (either a digit, or the symbol 'x')
	 * @param digitMapLength
	 */
	public void setDigitMapLength(int digitMapLength) {
		this.digitMapLength = digitMapLength;
	}

	public boolean isLengthFixed() {
		return isLengthFixed;
	}

	/**
	 * Set to true for a fixed length pattern, or false to append the '.' character after the initial mapping digits (i.e. or longer)
	 * @param isLengthFixed
	 */
	public void setLengthFixed(boolean isLengthFixed) {
		this.isLengthFixed = isLengthFixed;
	}

	/**
	 * Add a digit to the digit map sequence.  Order does matter; output will be based on order entered
	 * @param digit The digit in the digit map
	 */
	public void addDigit(Digit digit) {
		if (digits == null)
			digits = new ArrayList<Digit>();
		digits.add(digit);
	}
	
	@Override
	public String generateDigitMapString() {
		StringBuffer s = new StringBuffer();
		for (Digit digit : digits) {
			s.append(digit.generateDigitMapString());
		}
		for (int i = digits.size(); i < digitMapLength; i++)
			s.append(ANY_DIGIT);
		if (!isLengthFixed)
			s.append(OR_LONGER);
		if (addTimeout)
			s.append(TIMEOUT);
		return s.toString();
	}
	
}
