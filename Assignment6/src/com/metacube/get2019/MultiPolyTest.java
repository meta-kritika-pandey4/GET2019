package com.metacube.get2019;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * It is to run the test cases
 
 * @author Kritika
 *
 */
	
public class MultiPolyTest{
	
	@Test
	public void testMultiPoly1() {
		Poly p = new Poly(new int[] { 2, 2, 2 }, new int[] { 4, 1, 0 }, 3  );
		Poly p1 = new Poly(new int[] {3, 3, 3, 3}, new int[] {3, 2, 1, 0}, 4  );
		Poly p2 = p.multiPoly(p, p1);
		assertArrayEquals(new int[] {6, 12, 12, 12, 12, 6, 6, 6}, p2.getcoeff() );
		assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7}, p2.getExpo() );
	}
	
	@Test
	public void testMultiPoly2() {
		Poly p = new Poly(new int[] {1, 1}, new int[] {5, 0}, 2 );
		Poly p1 = new Poly(new int[] {1}, new int[] {1}, 1  );
		Poly p2 = p.multiPoly(p, p1);
		assertArrayEquals(new int[] {0, 1, 0, 0, 0, 0, 1}, p2.getcoeff() );
		assertArrayEquals(new int[] {0, 1, 0, 0, 0, 0, 6}, p2.getExpo() );
	}
	
	@Test(expected = AssertionError.class)
	public void testMultiPoly3() {
		Poly p = new Poly(new int[] {1, 1, 3, 4}, new int[] {5, 3, 2, 0}, 4 );
		Poly p1 = new Poly(new int[] {}, new int[] {}, 0 );
		Poly p2 = p.multiPoly(p, p1);
		assertArrayEquals(new int[] {0}, p2.getcoeff() );
		assertArrayEquals(new int[] {0}, p2.getExpo() );
	}
}
