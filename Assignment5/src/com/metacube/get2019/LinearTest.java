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
public class LinearTest{
	
	private int expected;
	private int[] actual;
	private int ele;
	private int index;
	private Search linear;
	
	@Before
	public void initialize() {
		linear=new Search();
	}
	
	public LinearTest( int expected, int[] actual, int ele, int index) {
		this.expected = expected;
		this.actual = actual;
		this.ele = ele;
		this.index = index;
	}
	
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection inputLinear() {
		return Arrays.asList(new Object[][] {
				{4, new int[] { 1, 2, 3, 4, 5, 6}, 5, 6 },
				{-1, new int[] { 7, 11, 8, 23}, 56, 4 },
				{ 0, new int[] { 10, 20, 30, 40}, 10, 4 },
				{ -1, new int[] {}, 6, 0 }});
	}
	
	@Test
	public void testLinear() {
		assertEquals(expected,linear.linearSearch ( actual, ele, index ) );
	}
}
