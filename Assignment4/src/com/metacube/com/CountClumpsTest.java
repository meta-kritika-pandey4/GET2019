package com.metacube.com;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * It is to run the test cases
 * for countClump() of ArrayOperations
 * class
 * @author Kritika
 *
 */
@RunWith(Parameterized.class)
public class CountClumpsTest {

	private int[] actual;
	private int expected;
	private ArrayOperations arrayOperations;

	@Before
	public void initialize() {
		arrayOperations = new ArrayOperations();
	}

	public CountClumpsTest(int expected, int[] actual) {
		this.expected = expected;
		this.actual = actual;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 2, new int[] { 1, 2, 2, 3, 4, 4 } },
				{ 2, new int[] { 1, 1, 2, 1, 1 } },
				{ 1, new int[] { 1, 1, 1, 1 } },
				{ 0, new int[] { 1, 2, 3, 4,5 } } });
	}

	@Test
	public void testCountClumps() {
		assertEquals(expected,arrayOperations.countClumps(actual));
	}
}
