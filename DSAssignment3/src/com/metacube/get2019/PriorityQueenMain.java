package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Kritika
 *
 */
public class PriorityQueenMain {

	/**
	 * It is a main method.
	 * @param args Unused
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of queue : ");
		int queueSize = sc.nextInt();
		PriorityQueueOperations prioQueObj = new PriorityQueueOperations(queueSize);
		boolean isExit = false;
		try {
			do {
				System.out.println("-------------------------------------");
				System.out.println("1. Insert an element into the priority queue.");
				System.out.println("2. Delete an element from priority queue.");
				System.out.println("3. Get highest priority element from the priority queue.");
				System.out.println("4. Check whether queue is empty or not.");
				System.out.println("5. Check whether queue is full or not.");
				System.out.println("6. Show priority queue.");
				System.out.println("7. Exit");
				System.out.println("-------------------------------------");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println("-------------------------------------");
				switch (choice) {
				case 1 :
					System.out.print("Enter the value of data which you want to insert : ");
					int data = sc.nextInt();
					System.out.print("Enter priority of the element : ");
					int priority = sc.nextInt();
					prioQueObj.enqueue(data, priority);
					break;
				case 2 :
					int element = prioQueObj.dequeue();
					System.out.println("Deleted element : "+element);
					break;
				case 3 :
					int highPriority = prioQueObj.getHighestPriority();
					System.out.println("Highest priority element : "+highPriority);
					break;
				case 4 :
					boolean isFull = prioQueObj.isEmpty();
					System.out.println("Queue is empty : "+isFull);
					break;
				case 5 :
					boolean isEmpty = prioQueObj.isFull();
					System.out.println("Queue is full : "+isEmpty);
					break;
				case 6 :
					prioQueObj.show();
					break;
				case 7 :
					isExit = true;
					System.out.println("Successfully exit!!");
					break;
				default:
					System.out.println("Invalid choice!!");
				}
			}while(!isExit);
		} catch(InputMismatchException e) {
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}
