package com.voxworx.polycom;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.voxworx.polycom.domain.Digit;
import com.voxworx.polycom.domain.DigitMap;
import com.voxworx.polycom.util.PolycomUtils;

public class DigitMapTest {

	@Test
	public void TestX11() {
		DigitMap m = new DigitMap();
		m.setDigitMapLength(3);
		m.addDigit(new Digit(2,9));
		m.addDigit(new Digit(1));
		m.addDigit(new Digit(1));
		assertEquals(m.generateDigitMapString(), "[2-9]11");
	}
	
	@Test
	public void Test0T() {
		DigitMap m = new DigitMap();
		m.addDigit(new Digit(0));
		m.setAddTimeout(true);
		assertEquals(m.generateDigitMapString(), "0T");
	}
	
	@Test
	public void Test011xxxOrLongerT() {
		DigitMap m = new DigitMap();
		m.addDigit(new Digit(0));
		m.addDigit(new Digit(1));
		m.addDigit(new Digit(1));
		m.setDigitMapLength(6);
		m.setLengthFixed(false);
		m.setAddTimeout(true);
		assertEquals(m.generateDigitMapString(), "011xxx.T");
	}
	
	@Test
	public void LongDistance() {
		DigitMap m = new DigitMap();
		m.addDigit(new Digit(0,1));
		m.addDigit(new Digit(2,9));
		m.setDigitMapLength(11);
		assertEquals(m.generateDigitMapString(), "[0-1][2-9]xxxxxxxxx");
	}
	
	@Test
	public void RegularNumber() {
		DigitMap m = new DigitMap();
		m.addDigit(new Digit(2,9));
		m.setDigitMapLength(10);
		assertEquals(m.generateDigitMapString(), "[2-9]xxxxxxxxx");
	}
	
	@Test
	public void Local4Extension() {
		DigitMap m = PolycomUtils.generateLocalExtension(2, 9, 4, false);
		assertEquals(m.generateDigitMapString(), "[2-9]xxx");
	}

	@Test
	public void Local3ExtensionWT() {
		DigitMap m = PolycomUtils.generateLocalExtension(2, 9, 3, true);
		assertEquals(m.generateDigitMapString(), "[2-9]xxT");
	}
	
	@Test
	public void TwoMaps() {
		DigitMap m = PolycomUtils.generateLocalExtension(2, 9, 3, true);
		DigitMap m2 = PolycomUtils.generateLocalExtension(2, 9, 4, false);
		List<DigitMap> maps = new ArrayList<DigitMap>();
		maps.add(m);
		maps.add(m2);
		assertEquals(PolycomUtils.generateDigitMapString(maps), "[2-9]xxT|[2-9]xxx");
	}

}
