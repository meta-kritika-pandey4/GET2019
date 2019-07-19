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
 * for linearSearch() of Search
 * class
 * @author Kritika
 *
 */
@RunWith(Parameterized.class)
public class LCMTest{
	
	private int expected;
	private int x, y;
	private HCF_LCM_Calc lcm;
	
	@Before
	public void initialize() {
		lcm = new HCF_LCM_Calc();
	}
	
	public LCMTest( int expected, int x, int y) {
		this.expected = expected;
		this.x = x;
		this.y = y;
		
	}
	
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection inputLCM() {
		return Arrays.asList(new Object[][] {
				{ 36, 12, 36 },
				{ 0, 0, 76 },
				{ 35, 5, 7 }, 
				{ 35, -5, 7 }});
	}
	
	@Test
	public void testLCM() {
		assertEquals(expected,lcm.calLCM( x, y));
	}
}
