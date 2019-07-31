package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a main class.
 * @author Kritika
 *
 */
public class RotateMain {

	/**
	 * It is a main method. 
	 * @param args unused
	 */
	public static void main(String args[]) {
		
		boolean isExit = false;
		Scanner sc = new Scanner(System.in);
		RotateLinkedList rotObj = new RotateLinkedList();
		try {
			do {
				System.out.println("1. Insert an element into the linked list.");
				System.out.println("2. Rotate a linked list.");
				System.out.println("3. Show Linked List");
				System.out.println("4. Exit");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1 :
					System.out.print("Enter the value of element to be inserted : ");
					int data = sc.nextInt();
					rotObj.insert(data);
					break;
				case 2 :
					System.out.print("Enter left position of sublist : ");
					int left = sc.nextInt();
					System.out.print("Enter the right position of sublist : ");
					int right = sc.nextInt();
					System.out.print("Enter the number of steps by which u want to rotate your list : ");
					int numberOfrotation = sc.nextInt();
					rotObj.rotateLinkList(left, right, numberOfrotation);
					break;
				case 3 :
					rotObj.show();
					break;
				case 4:
					isExit = true;
					System.out.println("Successfully Exit!!!");
					break;
				default :
					System.out.println("Invalid choice.");
				}
			}while(!isExit);
		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}

}