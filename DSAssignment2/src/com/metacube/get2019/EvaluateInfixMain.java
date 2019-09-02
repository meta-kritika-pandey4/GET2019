package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Kritika
 *
 */
public class EvaluateInfixMain {

	/**
	 * It is a main method.
	 * @param args unused
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		EvaluateInfix infixObj = new EvaluateInfix();
		try {
			System.out.print("Enter a String : ");
			String s = sc.nextLine();
			String postfix = infixObj.infixToPostfix(s);
			infixObj.evaluatePostfix(postfix);

		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}
		finally{
			sc.close();
		}
	}
}