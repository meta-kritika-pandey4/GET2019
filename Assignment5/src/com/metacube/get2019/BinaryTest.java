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
 * for binarySearch() of Search
 * class
 * @author Kritika
 *
 */
@RunWith(Parameterized.class)
public class BinaryTest{
	
	private int expected;
	private int[] actual;
	private int ele, start, end;
	private Search binary;
	
	@Before
	public void initialize() {
		binary=new Search();
	}
	
	public BinaryTest( int expected, int[] actual, int start, int end, int ele) {
		this.expected=expected;
		this.actual=actual;
		this.ele=ele;
		this.start=start;
		this.end=end;
	}
	
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection inputBinary() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] { 1, 2, 3, 4, 5, 6 },0, 6, 4  },
				{ 0, new int[] { 2, 7, 11, 23, 99}, 0, 5, 2 },
				{ -1, new int[]{}, 0, 0, 1} } );
	}
	
	@Test
	public void testBinary() {
		assertEquals(expected, binary.binarySearch(actual, start, end, ele));
	}
}
