package com.metacube.get2019;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * It is to run the test cases
 
 * @author Kritika
 *
 */
	
public class DegreeTest{
	
	@Test
	public void testDegree1() {
		Poly p = new Poly(new int[] { 2, 2, 2 }, new int[] { 2, 1, 0 }, 3  );
		assertEquals( 2, p.degree());
	}
	
	@Test
	public void testDegree2() {
		Poly p = new Poly(new int[] {}, new int[] {},  0  );
		assertEquals( -1, p.degree());
	}
	

}
