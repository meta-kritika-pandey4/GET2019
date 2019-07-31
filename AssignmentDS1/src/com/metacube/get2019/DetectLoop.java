package com.metacube.get2019;


/**
 * It is a class which is used to detect a loop in the linked list
 * @author Kritika
 *
 */
public class DetectLoop {

	private Node head;

	/**
	 * It is class used to create a node of linked list.
	 * @author Kritika
	 *
	 */
	class Node {

		public int data;
		public Node next = null;

		/**
		 * It is default constructor of class.
		 */
		public Node() {
		}

		/**
		 * It is a constructor used to initialize a node.
		 * @param data value of data field of node.
		 */
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	/**
	 * It is a method used to check whether there is a loop in linked list or not.
	 * @return boolean value
	 */
	public boolean detectLoop() {
		if (head == null) {
			System.out.println("No elements are there in the list!!!");
			return false;
		}
		Node slowPtr = head;
		Node fastPtr = head;
		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * It is method used to insert an element at the starting of linked list.
	 * @param data element to be inserted.
	 */
	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.data = data;
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	/**
	 * It is used to create a loop into the linked list at kth position.
	 * @param k position where to create a loop.
	 */
	public void makeLoop(int k) {
		int count = 1;
		if (head == null) {
			System.out.println("No items in  the list!!!");
			return;
		}
		Node temp = head;
		Node temp1 = head;
		while (count != k) {
			if (temp == null) {
				System.out.println("No further items in the list!!!!");
				return;
			}
			temp = temp.next;
			count++;
		}
		while (temp1.next != null) {
			temp1 = temp1.next;
		}
		temp1.next = temp;
	}
	
	/**
	 * It is a method used to show elements of a linked list.
	 */
	public void show() {
		if (head == null) {
			System.out.println("No elemets in the list!!!");
			return;
		}
		Node temp = new Node();
		temp = head;
		System.out.print("LINKED LIST : ");
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
 
}