package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method
 * @author Kritika
 *
 */
public class EmpMain {

	/**
	 * It is a main method.
	 * @param args unused
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		Node head;
		SortLinkList sortObj = new SortLinkList();
		try {
			do {
				System.out.println("1. Insert an employee into the linked list.");
				System.out.println("2. Sort the linked list.");
				System.out.println("3. Show linked list.");
				System.out.println("4. Exit");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1 :
					System.out.print("Enter the name of employee : ");
					String empName = sc.nextLine();
					System.out.print("Enter the age of employee : ");
					int age = sc.nextInt();
					System.out.print("Enter the salary of employee : ");
					int salary = sc.nextInt();
					sortObj.insert(new Employee(empName, age, salary));
					System.out.println("Employee added");
					break;
				case 2 :
					head = sortObj.getHead();
					sortObj.insertionSort(head);
					break;
				case 3:
					head = sortObj.getHead();
					System.out.println("EmpName\t\tEmpAge\t\tEmpSalary");
					sortObj.show(head);
					break;
				case 4:
					isExit = true;
					System.out.println("Successfully Exit!!!");
					break;
				default :
					System.out.println("Invalid choice.");
					
				}
			} while(!isExit);
		} catch(InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}finally { 
			sc.close();
		}
	}
}
