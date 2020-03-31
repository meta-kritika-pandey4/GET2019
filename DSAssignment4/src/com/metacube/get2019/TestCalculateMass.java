package com.metacube.get2019;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculateMass {

	@Test
	public void testCalculateMass1() {
		CalculateMass c = new CalculateMass();
		String str = "COOH";
		assertEquals(45,c.calculateMass(str));
	}
	
	@Test(expected=AssertionError.class)
	public void testCalculateMass2() {
		CalculateMass c = new CalculateMass();
		String str = "XYZ";
		assertEquals(-1,c.calculateMass(str));
	}

}
