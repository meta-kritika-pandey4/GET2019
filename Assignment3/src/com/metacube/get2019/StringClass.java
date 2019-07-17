package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Admin
 *
 */
public class StringClass {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str;
		Utility u=new Utility();
		boolean flag = true;
		boolean con;
		try {
			do {
				String result;
				StringOperations obj = new StringOperations();
				System.out.println("1. Reverse a string");
				System.out.println("2. Reverse the case of string");
				System.out.println("3. Comapre two strings");
				System.out.println("4. Find largest word in a string");
				System.out.println("5. Exit the program");
				System.out.println("--------------------------");
				System.out.print("Enter your choice = ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.print("Enter a string = ");
					str = sc.nextLine();
					con=u.isValidString(str);
					if(con){
						result = obj.reverse(str);
						System.out.println("Reverse of string = " + result);
						System.out.println("-----------------------------");
					}
					break;
				case 2:
					System.out.print("Enter a string = ");
					str = sc.nextLine();
					con=u.isValidString(str);
					if(con){
						result = obj.reverseCase(str);
						System.out.println("Reversed case string = " + result);
						System.out.println("-----------------------------");
					}
					break;
				case 3:
					System.out.print("Enter a string = ");
					str = sc.nextLine();
					con=u.isValidString(str);
					if(con){
						System.out.print("Enter one more string to compare = ");
						String str2 = sc.nextLine();
						con=u.isValidString(str2);
						if(con){
							int result1 = obj.compare2String(str, str2);
							System.out.println("Result of comparison of 2 string is = "+ result1);
							System.out.println("-----------------------------");
						}
					}
					break;
				case 4:
					System.out.print("Enter a string = ");
					str = sc.nextLine();
					con=u.isValidString(str);
					if(con){
						result = obj.largestWordOfString(str);
						System.out.println("Largest word of string = " + result);
						System.out.println("-----------------------------");
					}
					break;
				case 5:
					flag = false;
					System.out.println("Successfully exit");
					System.out.println("-----------------------------");
					break;
				default:
					System.out.println("Invalid input");
				}
			} while (flag);
		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}
		finally{
			sc.close();
		}
	}
}
