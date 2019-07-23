package com.metacube.get2019;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * It is to run the test cases
 * @author Kritika
 *
 */
	
public class MultiTest{
	
	@Test
	public void testMultiSparseMatrix1() {
		SparseMatrix s = new SparseMatrix(2, 2, new int[][] {{ 2, 1}, {0 , 0} } );
		SparseMatrix s1 = new SparseMatrix(2, 2, new int[][] { { 1, 0}, { 0, 1 }});
		SparseMatrix s2 = s.multiply(s1);
		assertArrayEquals(new int[][] { {0, 0, 2}, {0, 1, 1}, },  s2.getResult());
	}
	
	@Test(expected = AssertionError.class)
	public void testMultiSparseMatrix3() {
		SparseMatrix s = new SparseMatrix(0, 0, new int[][] {} );
		SparseMatrix s1 = new SparseMatrix(0, 0, new int[][] {});
		SparseMatrix s2 = s.multiply(s1);
		assertArrayEquals(new int[][] {}, s2.getResult());
	}
}