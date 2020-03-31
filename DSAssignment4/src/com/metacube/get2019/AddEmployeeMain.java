package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Kritika
 *
 */
public class AddEmployeeMain {

	/**
	 * It is a main method
	 * @param args unused
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		AddEmployee empObj = new AddEmployee();
		try {
			do {
				System.out.println("1. Insert an employee.");
				System.out.println("2. Exit");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case Constant.ONE:
					System.out.print("Enter the Id of employee : ");
					int empId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the name of employee : ");
					String empName = sc.nextLine();
					System.out.print("Enter the address of employee : ");
					String empAddress = sc.nextLine();
					boolean hasDuplicate = empObj.createEmpList(new AddEmployee(empId, empName, empAddress));
					System.out.println(hasDuplicate);
					break;
				case Constant.TWO:
					isExit = true;
					System.out.println("Successfully exit!!!");
					break;
				default:
					System.out.println("Invalid choice!!!");
				}
			} while (!isExit);
		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}finally {
			sc.close();
		}
	}
}