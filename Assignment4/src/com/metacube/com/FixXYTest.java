package com.metacube.com;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;

/**
 * It is to run the test cases
 * for fixXY() of ArrayOperations
 * class
 * @author Kritika
 *
 */
@RunWith(Parameterized.class)
public class FixXYTest {
	
	private int[] expected;
	private int[] actual;
	private int X,Y;
	private ArrayOperations arrayOperations;
	
	@Before
	public void initialize(){
		arrayOperations = new ArrayOperations() ;
	}
	
	public FixXYTest(int[] actual,int[] expected, int X, int Y){
		this.expected = expected;
		this.actual = actual;
		this.X = X;
		this.Y = Y;
		
	}


	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection inputFixXY() {
		return Arrays.asList(new Object[][] {
				{ new int[] {5,4,9,4,5,9},new int[] {9, 4, 5, 4, 5, 9}, 4, 5 },
				{ new int[] {1, 4, 1, 5},new int[] {1, 4, 5, 1}, 4, 5 },
				{ new int[] {1, 4, 1, 5, 5, 4, 1}, new int[] {1, 4, 5, 1, 1, 4, 5}, 4, 5 } } );
	}
	
	@Test
	public void testFixXY() {
		assertArrayEquals(expected,arrayOperations.fixXY(actual,X,Y));
	}
	
	

}
