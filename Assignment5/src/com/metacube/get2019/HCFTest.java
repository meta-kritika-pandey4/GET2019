package com.metacube.get2019;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;

/**
 * It is to run the test cases
 * for calHCF() of Search
 * class
 * @author Kritika
 *
 */
@RunWith(Parameterized.class)
public class HCFTest{
	
	private int expected;
	private int x, y;
	private HCF_LCM_Calc hcf;
	
	@Before
	public void initialize() {
		hcf = new HCF_LCM_Calc();
	}
	
	public HCFTest( int expected, int x, int y) {
		this.expected = expected;
		this.x = x;
		this.y = y;
		
	}
	
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection inputHCF() {
		return Arrays.asList(new Object[][] {
				{ 12, 24, 36 },
				{ 0, 0, 76 },
				{ 1, 5, 7 },
				{ 3, -3, -6 }});
	}
	
	@Test
	public void testHCF() {
		assertEquals(expected,hcf.calHCF( x, y));
	}
}
