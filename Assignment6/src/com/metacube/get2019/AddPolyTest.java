package com.metacube.get2019;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * It is to run the test cases
 
 * @author Kritika
 *
 */
	
public class AddPolyTest{
	
	@Test
	public void testAddPoly1() {
		Poly p = new Poly(new int[] { 2, 2, 2 }, new int[] { 2, 1, 0 }, 3  );
		Poly p1 = new Poly(new int[] {1, 1, 1}, new int[] {4, 1, 0 }, 3  );
		Poly p2 = p.addPoly(p, p1);
		assertArrayEquals(new int[] { 1, 2, 3, 3}, p2.getcoeff() );
		assertArrayEquals(new int[] { 4, 2, 1, 0}, p2.getExpo() );
	}
	
	@Test
	public void testAddPoly2() {
		Poly p = new Poly(new int[] {1, 1, 3, 4}, new int[] {5, 3, 2, 0}, 4 );
		Poly p1 = new Poly(new int[] {1}, new int[] {1}, 1  );
		Poly p2 = p.addPoly(p, p1);
		assertArrayEquals(new int[] {1, 1, 3, 1, 4}, p2.getcoeff() );
		assertArrayEquals(new int[] { 5, 3, 2, 1, 0}, p2.getExpo() );
	}
	
	@Test
	public void testAddPoly3() {
		Poly p = new Poly(new int[] {1, 1, 3, 4}, new int[] {5, 3, 2, 0}, 4 );
		Poly p1 = new Poly(new int[] {}, new int[] {}, 0 );
		Poly p2 = p.addPoly(p, p1);
		assertArrayEquals(new int[] {1, 1, 3, 4}, p2.getcoeff() );
		assertArrayEquals(new int[] { 5, 3, 2, 0}, p2.getExpo() );
	}

}
