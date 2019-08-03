package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Kritika
 *
 */
public class UniqueCharacterMain {

	/**
	 * It is a main method
	 * @param args unused
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		UniqueCharacter uniObj = new UniqueCharacter();
		boolean isExit = false;
		try {
			do {
				System.out.println("1. Find number of unique characters.");
				System.out.println("2. Exit");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case Constant.ONE:
					System.out.print("Enter a string : ");
					String str = sc.nextLine();
					int noOfUniChar = uniObj.noOfUniqueChar(str);
					System.out.println("No of unique characters : "+ noOfUniChar);
					break;
				case Constant.TWO:
					isExit = true;
					System.out.println("Exit!!!");
					break;
				default:
					System.out.println("Invalid choice!!");
				}
			} while (!isExit);
		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}