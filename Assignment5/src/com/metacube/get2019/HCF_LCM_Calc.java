package com.metacube.get2019;

/**
 * The class to calculate
 * HCF and LCM of numbers
 * @author Kritika
 *
 */
public class HCF_LCM_Calc {
	
	int temp = 1;
	
	/**
	 * This method calculates the HCF of two numbers
	 * @param x first number
	 * @param y second number
	 * @return hcf of the two numbers
	 */
	public int calHCF ( int x, int y ) {
		if( Math.abs(x) < Math.abs(y) ){
			int swap = x;
			x = y;
			y = swap;
		}
		if ( x == 0 || y == 0 ) {
			return 0;
		} 
		int rem = x % y;
		if ( rem == 0 ) {
			return Math.abs(y);
		} else {
			return calHCF( y, rem );
		}
	}

	/**
	 * This method calculates the LCM of two numbers
	 * @param x first number
	 * @param y second number
	 * @return lcm of the two numbers
	 */
	public int calLCM ( int x, int y ) {
		if ( x == 0 || y == 0) {
			return 0;
		}

		if (temp % x == 0 && temp % y == 0) {
			return temp;
		} else {
			temp++;
			return calLCM( x, y );
		}		
	}
}
