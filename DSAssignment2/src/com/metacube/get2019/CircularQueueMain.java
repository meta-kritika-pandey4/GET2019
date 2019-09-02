package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Kritika
 *
 */
public class CircularQueueMain {
 
	/**
	 * It is a main method.
	 * @param args unused
	 */
	public static void main(String args[]) {
		boolean isExit = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of queue : ");
		int size = sc.nextInt();
		CircularQueue queueObj = new CircularQueue(size);
		try {
			do {
				System.out.println("1. Insert an element into the queue.");
				System.out.println("2. Delete an element into the queue.");
				System.out.println("3. Check queue is full or not.");
				System.out.println("4. Check queue is empty or not.");
				System.out.println("5. Show the items of the queue.");
				System.out.println("6. Exit");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1 :
					System.out.print("Enter the data item which u want to insert into the queue : ");
					int data = sc.nextInt();
					queueObj.enqueue(data);
					break;
				case 2 :
					int item = queueObj.dequeue();
					System.out.println("Deleted element is : "+item);
					break;
				case 3 :
					boolean isFull = queueObj.isFull();
					System.out.println("Queue is full : "+isFull);
					break;
				case 4 :
					boolean isEmpty = queueObj.isEmpty();
					System.out.println("Queue is empty  : "+isEmpty);
					break;
				case 5:
					queueObj.show();
					break;
				case 6:
					isExit = true;
					System.out.println("Successfully exit!!!");
					break;
				default :
					System.out.println("Invalid choice!!");
				}
			}while (!isExit);
		}catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}
		finally {
			sc.close();
		}
	}
}
