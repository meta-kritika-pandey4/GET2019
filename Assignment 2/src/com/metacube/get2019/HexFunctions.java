package com.metacube.get2019;


import java.util.*;

/**
 * This class all the methods
 * to perform operations on
 * the Hexadecimal Numbers
 * @author Admin
 *
 */
class HexFunctions {
	
	/**
	 * It is method to convert character into decimal value
	 * @param c Character to be converted
	 * @return decimal value
	 */
	 int value(char c) {
		if (c >= '0' && c <= '9') {
			return (int) c - '0';
		} else {
			return (int) c - 'A' + 10;
		}
	}

	/**
	 * It is method to convert decimal value into character.
	 * @param value value to be converted
	 * @return char value
	 */
	char reval(int value) {
		if (value >= 0 && value <= 9) {
			return (char) (value + 48);
		} else {
			return (char) (value - 10 + 65);
		}
	}

	/**
	 * It is method used to convert hexadecimal into decimal number.
	 * @param hex hexadecimal number
	 * @param base 
	 * @return decimal value
	 */
	public int hexToDec(String hex, int base) {
		int decimalValue = 0;
		try{
			hex = hex.toUpperCase();
			int len = hex.length();
			int power = 1;
			for (int i = len - 1; i >= 0; i--) {
				if (value(hex.charAt(i)) >= base) {
					System.out.println("Invalid String");
				} else {
					decimalValue += (value(hex.charAt(i)) * power);
					power *= base;
				}
			}
			return decimalValue;
		}
		catch(NullPointerException e){
			System.out.println("Null string is sent!!");
			return decimalValue;
		}
	}

	/**
	 * It is a method to decimal value into hexadecimal value 
	 * @param value
	 * @param base
	 * @return hexadecimal value
	 */
	public String decTohex(int value, int base) {
		String hex = "";
		StringBuilder hex1 = new StringBuilder();
		try{
			if (value == 0) {
				return "0";
			}
			int value1 = value >= 0 ? value : -value;
			while (value1 > 0) {
				hex += reval(value1 % base);
				value1 /= base;
			}
			hex += (value < 0 ? "-" : "");
			hex1.append(hex);
			return new String(hex1.reverse());
		}
		catch(ArithmeticException e){
			System.out.println("Can't have base 0");
			String res="Not defined";
			return res;
		}
	}

	/**
	 * It is a method to add hexadecimal values
	 * @param n number of hexadecimal numbers to be added.
	 * @param base
	 */
	public void hexAddition(int n,int base) {
		
		Scanner sc = new Scanner(System.in);
		String[] hex = new String[n];
		int[] dec = new int[n];
		int addition = 0;
		try {
			System.out.println("Enter the  Hexadecimal Numbers to be added");
			for(int i=0; i<n; i++)
				hex[i]=sc.nextLine();
			for(int i=0; i<n; i++){
				dec[i] = hexToDec(hex[i], base);
				addition += dec[i];
			}
			String hexResult = decTohex(addition, base);
			System.out.println("------------------------");
			System.out.println("Addition of " + n + " hexadecimal number is = " + hexResult);
			System.out.println("------------------------");
		}
		catch(InputMismatchException e){
			System.out.println(e.getStackTrace());
		}
		catch(NullPointerException e){
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * It is a method which is used to find subtraction of 2 hexadecimal number.
	 * @param hex1 first hexadecimal string 
	 * @param hex2 second hexadecimal string
	 * @param base 
	 */
	public void hexSubtraction(String hex1, String hex2, int base) {

		int value1 = hexToDec(hex1, base);
		int value2 = hexToDec(hex2, base);
		int subtraction = value1 - value2;
		String hexResult = decTohex(subtraction, base);
		System.out.println("------------------------");
		System.out.println("Subtraction of 2 hexadecimal number is = "+ hexResult);
		System.out.println("------------------------");
	}

	/**
	 * It is method to find multiplication of hexadecimal numbers.
	 * @param n number of hexadecimal number to be multiplied.
	 * @param base
	 */
	public void hexMultiplication(int n,int base){
		
		Scanner sc = new Scanner(System.in);
		String[] hex = new String[n];
		int[] dec = new int[n];
		int multiplication = 1;
		try{
			System.out.println("Enter the  Hexadecimal Numbers to be multiplied ");
			for(int i=0; i<n; i++)
				hex[i] = sc.nextLine();
			for(int i=0; i<n; i++){
				dec[i] = hexToDec(hex[i],base);
				multiplication *= dec[i];
			}
			String hexResult = decTohex(multiplication, base);
			System.out.println("------------------------");
			System.out.println("Multiplication of "+n+" hexadecimal number is `= " + hexResult);
			System.out.println("------------------------");
		}
		catch(InputMismatchException e){
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * It is a method used to find division of 2 hexadecimal numbers.
	 * @param hex1 first hexadecimal string 
	 * @param hex2 second hexadecimal string
	 * @param base
	 */
	public void hexDivision(String hex1, String hex2, int base) {
		
		try{
			int value1 = hexToDec(hex1, base);
			int value2 = hexToDec(hex2, base);
			int division = value1 / value2;
			String hexResult = decTohex(division, base);
			System.out.println("------------------------");
			System.out.println("Division of 2 hexadecimal number is =  " + hexResult);
			System.out.println("------------------------");
		}
		catch(ArithmeticException e){
			System.out.println("Can't divide by zero!!");
		}
	}

	/**
	 * It is a method which is used to compare 2 strings.
	 * @param hex1 first hexadecimal string
	 * @param hex2 second hexadecimal string
	 */
	public void compareHexStringss(String hex1, String hex2) {
		int value = hex1.compareTo(hex2);
		switch(value) {
			case 0:
				showMessage("Both are equal");
				break;
			case -1:
				showMessage("First is smaller than second");
				break;
			case 1:
				showMessage("First is greater than second");
				break;
		}
	}
	
	public void showMessage(String msg){
		
		System.out.println("------------------------");
		System.out.println(msg);
		System.out.println("------------------------");
	}
}
