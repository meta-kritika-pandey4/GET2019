package com.metacube.get2019;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * It is to run the test cases
 * for isMember() of IntSet
 * class
 * @author Kritika
 *
 */
	
public class IsMemberTest{
	
	@Test
	public void testIsMember1() {
		IntSet s = new IntSet(new int[] { 1, 2, 3 ,4 ,5 ,6} , 6);
		assertEquals( true , s.isMember( 3 ));
	}
	
	@Test
	public void testIsMember2() {
		IntSet s = new IntSet(new int[] { 45, 23, 76, 12, 65, 9, 49, 0, 2, 4} , 10);
		assertEquals( false , s.isMember( 1 ));
	}
	
	@Test
	public void testIsMember3() {
		IntSet s = new IntSet(new int[] {} , 0 );
		assertEquals( false , s.isMember( 3 ));
	}
	
	@Test
	public void testIsMember4() {
		IntSet s = new IntSet(new int[] { 89, 1000, 0, 12, 143, 7, 211, 12} , 8);
		assertEquals( true , s.isMember( 12 ));
	}
}
