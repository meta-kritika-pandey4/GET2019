package com.metacube.get2019;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Kritika
 *
 */
public class EmpIdSorterMain {

	/**
	 * It is a main method
	 * @param args unused.
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		EmpIdSorter empObj = new EmpIdSorter();
		List<EmpIdSorter> empList = new ArrayList<EmpIdSorter>();
		try {
			do {
				System.out.println("1. Insert an employee.");
				System.out.println("2. Sort according to employee Id.");
				System.out.println("3. Exit");
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
					empObj.makeEmpList(new EmpIdSorter(empId, empName, empAddress));
					break;
				case Constant.TWO: 
					empList = empObj.sortAccId();
					System.out.println("EMPID\t\tEMPNAME\t\tEMPADDRESS");
					for(EmpIdSorter i : empList) {
						System.out.println(i.empId + "\t\t" + i.empName + "\t\t" + i.empAddress);
					}
					break;
				case Constant.THREE:
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