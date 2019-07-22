package com.metacube.get2019;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * It is to run the test cases
 * @author Kritika
 *
 */
	
public class IsSubsetTest{
	
	@Test
	public void testIsSubset1() {
		IntSet s = new IntSet(new int[] { 1, 2, 3 ,4 ,5 ,6} , 6);
		IntSet s1 = new IntSet(new int[] { 1, 2, 3 } , 3);
		assertEquals( true , s.isSubSet(s1));
	}
	
	@Test
	public void testIsSubset2() {
		IntSet s = new IntSet(new int[] { 45, 23, 76, 12, 65, 9, 49, 0, 2, 4} , 10);
		IntSet s1 = new IntSet(new int[] { 45, 23, 76, 81, 65, 99} , 6);
		assertEquals( false , s.isSubSet(s1));
	}
	
	@Test
	public void testIsSubset3() {
		IntSet s = new IntSet(new int[] {} , 0 );
		IntSet s1 = new IntSet(new int[] {} , 0 );
		assertEquals( true , s.isSubSet(s1));
	}
	
	@Test
	public void testIsSubset4() {
		IntSet s = new IntSet(new int[] { 89, 1000, 0, 12, 143, 7, 211} , 7);
		IntSet s1 = new IntSet(new int[] { 89, 1000, 7, 211 } , 4);
		assertEquals( true , s.isMember( 12 ));
	}
}
