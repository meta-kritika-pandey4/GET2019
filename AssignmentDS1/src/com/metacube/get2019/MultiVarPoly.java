package com.metacube.get2019;

/**
 * It is a class to find degree of multivariate polynomial.
 * @author Kritika
 *
 */
public class MultiVarPoly {

	private Node head;

	/**
	 * It is class used to create a node of linked list.
	 * @author Kritika
	 *
	 */
	class Node {
		public int data;
		public Node right;
		public Node down;

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
			right = null;
			down = null;
		}

	}

	/**
	 * It is a method which is used to create a linked list.
	 * @param coeff coefficient of polynomial
	 * @param expoArr array of exponent of particular coefficient.
	 */
	public void createLinkList(int coeff, int[] expoArr) {
		Node newNode = new Node(coeff);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = newNode;
		}
		for (int i = 1; i < expoArr.length ; i++) {
			Node newNode1 = new Node(expoArr[i]);
			newNode.down = newNode1;
			newNode = newNode1;
		}

	}
	
	/**
	 * It is a method used to show a linked list.
	 */
	public void show() {
		Node temp = head;
		if (head == null) {
			System.out.println("No elements are in the list!!!");
			return;
		}
		System.out.println("LINKED LIST  : ");
		while(temp != null) {
			System.out.print(temp.data + "->");
			Node temp1= temp.down;
			while (temp1 != null) {
				System.out.print(temp1.data + "->");
				temp1 = temp1.down;
			}
			temp = temp.right;
			System.out.println();
		}
	}
	
	/**
	 * It is a method used to find degree of the polynomial.
	 */
	public void findDegree() {
		int max = 0;
		if (head == null) {
			System.out.println("No items in the list!!!");
			return;
		}
		Node temp = head;
		while (temp != null) {
			int sum = 0;
			Node temp1 = temp;
			while (temp1.down != null) {
				sum = sum + temp1.down.data;
				temp1 =temp1.down;
			}
			if (sum > max) {
				max = sum;
			}
			temp = temp.right;
		}
		System.out.println("Degree of polynomial : "+max);
	}
}