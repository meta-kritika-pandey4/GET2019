package com.metacube.get2019;

import java.util.Scanner;

/**
 * This class has methods for performing
 * operations on polynomials
 * @author Kritika
 *
 */
public final class Poly {
	private int[] coefficient = new int[20];
	private int[] exponent = new int[20];
	private int length;
	Scanner sc = new Scanner(System.in);

	/**
	 * It is an default constructor.
	 */
	public Poly() {
		this.length = 0;
	}

	/**
	 * It is an constructor used to get polynomial.
	 * @param n number of terms in polynomial.
	 */
	public Poly(int[] coefficient, int[] exponent, int n) {
		int i = 0;
		for (i = 0; i < n; i++) {
			this.coefficient[i] = coefficient[i];
			this.exponent[i] = exponent[i];
		}
		this.length = n;
	}

	/**
	 * It is a method used to evaluate the polynomial for any value of x.
	 * @param x value of x.
	 * @return result of polynomial for value x.
	 */
	public float evaluate(float x) {
		float evaluate = 0;
		if (length == 0) 
			return -1;
		for (int i = 0; i < coefficient.length; i++) {
			evaluate += coefficient[i] * Math.pow(x, exponent[i]);
		}
		return evaluate;
	}

	/**
	 * It is a method used to return degree of polynomial.
	 * @return degree of polynomial.
	 */
	public int degree() {
		if (length == 0){
			return -1;
		}
		int max = 0;
		for (int i = 0; i < exponent.length; i++) {
			if (exponent[i] > max) {
				max = exponent[i];
			}
		}
		return max;
	}

	/**
	 * It is a method used to return addition of 2 polynomial.
	 * @param p1 1st polynomial
	 * @param p2 2nd Polynomial
	 * @return sum of Polynomials.
	 */
	public Poly addPoly(Poly p1, Poly p2) {
		Poly p3 = new Poly();
		for (int i = 0, k = 0, j = 0; i < p1.length || i < p2.length; j++) {
			if (p1.exponent[i] == p2.exponent[k]) {
				p3.coefficient[j] = p1.coefficient[i] + p2.coefficient[k];
				p3.exponent[j] = p1.exponent[i];
				i++;
				k++;
			} else if (p1.exponent[i] > p2.exponent[k]) {
				p3.coefficient[j] = p1.coefficient[i];
				p3.exponent[j] = p1.exponent[i];
				i++;
			} else {
				p3.coefficient[j] = p2.coefficient[k];
				p3.exponent[j] = p2.exponent[k];
				k++;
			}
			p3.length = j;
		}
		return p3;
	}

	/**
	 * It is a method used to return multiplication of polynomials.
	 * @param p1 first polynomial.
	 * @param p2 second polynomial.
	 * @return multiplication of polynomial.
	 */
	public Poly multiPoly(Poly p1, Poly p2) {
		if (p1.length == 0 || p2.length == 0)
			throw new AssertionError("Polynomial do not exist");
		Poly p3 = new Poly();
		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < p2.length; j++) {
				p3.coefficient[p1.exponent[i] + p2.exponent[j]] += (p1.coefficient[i] * p2.coefficient[j]);
				p3.exponent[p1.exponent[i] + p2.exponent[j]] = p1.exponent[i] + p2.exponent[j];
			}
		}
		int max=p3.exponent[0];
		for(int i = 0; i < p3.exponent.length; i++){
			if( max < p3.exponent[i]){
				max = p3.exponent[i];
			}
		}
		p3.length = max;
		return p3;
	}

	/**
	 * A getter method to have the coefficient array of the polynomial
	 * @return arr
	 */
	public int[] getcoeff(){
		int[] arr = new int[this.length + 1];
		for(int i = 0; i < this.length + 1; i++){
			arr[i] = coefficient[i];
		}
		return arr;
	}
	
	/**
	 * A getter method to have the exponent array of the polynomial
	 * @return arr
	 */
	public int[] getExpo(){
		int[] arr = new int[this.length + 1] ;
		for(int i = 0; i < this.length + 1; i++){
			arr[i] = exponent[i];
		}
		return arr;
	}
	
}
