package com.metacube.com;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;

/**
 * It is to run the test cases
 * for splitArray() of ArrayOperations
 * class
 * @author Kritika
 *
 */
@RunWith(Parameterized.class)
public class SplitArrayTest{
	
	private int expected;
	private int[] actual;
	private ArrayOperations arrayOperations;
	
	@Before
	public void initialize() {
		arrayOperations=new ArrayOperations();
	}
	
	public SplitArrayTest( int expected, int[] actual) {
		this.expected=expected;
		this.actual=actual;
	}
	
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection inputSplitArray() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] {1,1,1,2,1} },
				{ -1, new int[] {2,1,1,2,1} },
				{ 1, new int[] {10,10} } });
	}
	
	@Test
	public void testSplitArray() {
		assertEquals(expected,arrayOperations.splitArray(actual));
	}
}
