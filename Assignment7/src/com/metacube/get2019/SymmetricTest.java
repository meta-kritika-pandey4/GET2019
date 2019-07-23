package com.metacube.get2019;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * It is to run the test cases
 * @author Kritika
 *
 */
	
public class SymmetricTest{
	
	@Test
	public void testSymmetric1() {
		SparseMatrix s1 = new SparseMatrix(3, 3, new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
		assertEquals(true,  s1.symmetric());
	}

	@Test
	public void testSymmetric2() {
		SparseMatrix s2 = new SparseMatrix(2, 2, new int[][] {{1, 2}, {0, 4}});
		assertEquals(false, s2.symmetric());
	}
	
	@Test(expected = AssertionError.class)
	public void testSymmetric3() {
		SparseMatrix s = new SparseMatrix(0, 0, new int[][] {} );
		assertEquals(false, s.symmetric());
	}
}