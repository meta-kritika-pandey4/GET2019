package com.metacube.com;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;

import static org.junit.Assert.*;

/**
 * It is to run the test cases
 * for maxMirror() of ArrayOperations
 * class
 * @author Kritika
 *
 */
@RunWith(Parameterized.class)
public class MaxMirrorTest {
	private int[] actual;
	private int expected;
	private ArrayOperations arrayOperations;

	@Before
	public void initialize() {
		arrayOperations = new ArrayOperations();
	}

	public MaxMirrorTest(int expected, int[] actual) {
		this.expected = expected;
		this.actual = actual;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] { 1, 2, 3, 8, 9, 3, 2, 1 } },
				{ 2, new int[] { 7, 1, 4, 9, 7, 4, 1 } },
				{ 3, new int[] { 1, 2, 1, 4} },
				{ 7, new int[] { 1, 4, 5, 3, 5, 4, 1} },
				{ 1, new int[] { 1, 2, 3, 4, 5, 6} } } );
	}

	@Test
	public void testCountClumps() {
		assertEquals(expected,arrayOperations.maxMirror(actual));
	}
}


