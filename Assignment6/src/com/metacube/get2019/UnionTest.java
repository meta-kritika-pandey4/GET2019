package com.metacube.get2019;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * It is to run the test cases
 * @author Kritika
 *
 */
	
public class UnionTest{
	
	@Test
	public void testUnion1() {
		IntSet s = new IntSet(new int[] { 1, 2, 3 ,4 ,5 ,6} , 6);
		IntSet s1 = new IntSet(new int[] { 1, 2, 3 } , 3);
		IntSet actual = s.union(s, s1);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, actual.getSet());
	}
	
	@Test
	public void testUnion2() {
		IntSet s = new IntSet(new int[] { 45, 23, 76, 12, 65, 9, 49, 0, 2, 4} , 10);
		IntSet s1 = new IntSet(new int[] {}, 0);
		IntSet actual = s.union(s, s1);
		assertArrayEquals( new int[] { 0, 2, 4, 9, 12, 23, 45, 49, 65, 76 } , actual.getSet());
	}
	

}
