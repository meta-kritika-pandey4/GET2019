package com.metacube.get2019;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * It is to run the test cases
 * @author Kritika
 *
 */
	
public class TransposeTest{
	
	@Test
	public void testTranspose1() {
		SparseMatrix s1 = new SparseMatrix(4, 4, new int[][] { { 0, 10, 0, 12}, { 0, 0, 0, 0 }, {0, 0, 5, 0}, {15, 12, 0, 0}});
		SparseMatrix s2 = s1.transpose();
		assertArrayEquals(new int[][] {{0, 3, 15}, {1, 0, 10}, {1, 3, 12}, {2, 2, 5}, {3, 0, 12} },  s2.getResult());
	}

	@Test(expected = AssertionError.class)
	public void testTransposeSparseMatrix3() {
		SparseMatrix s = new SparseMatrix(0, 0, new int[][] {} );
		SparseMatrix s2 = s.transpose();
		assertArrayEquals(new int[][] {}, s2.getResult());
	}

}