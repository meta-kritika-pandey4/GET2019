package com.metacube.get2019;

/**
 * It is a class used to implement operations need to rotate a linked list.
 * @author Kritika
 *
 */
public class RotateLinkedList {

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
	 * It is a method used to rotate a subList of a linked list
	 * @param left left position of sublist.
	 * @param right right position of sublist.
	 * @param numberOfRotation number of rotation of linked list.
	 */
	public void rotateLinkList(int left, int right, int numberOfRotation) {
		if ( left < 0 || right > noOfNodes() || left <= right ) {
			System.out.println("Invalid window size is given for the sublist");
		} else {
			Node temp = new Node();
			Node temp1 = new Node();
			Node temp2 = new Node();
			Node prev = new Node();
			int count = 0;
			if (head == null) {
				System.out.println("Empty list");
				return;
			} else {
				while (count != numberOfRotation) {
					temp = head;	// used to iterate linked list upto left position
					temp1 = head;	// used to iterate linked list upto right position
					prev = head;
					for( int i = 1, j = 1; i <= left || j <= right; i++, j++) {
						if( i <= left ){
							prev = temp;
							temp = temp.next;
						}
						if( j <= right ) {
							temp1 = temp1.next;
						}
					}
					temp2 = temp.next;
					temp.next = temp1.next;
					temp1.next = temp;
					prev.next = temp2;
					count++;
				}
			}
		}
	}
	
	/**
	 * It is method used to insert an element at the starting of linked list.
	 * @param data element to be inserted.
	 */
	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.data = data;
		newNode.next = head;
		head = newNode;

	}
	
	/**
	 * It is a method used to show elements of a linked list.
	 */
	public void show() {
		if (head == null) {
			System.out.println("No elements in the list!!!");
			return;
		}
		Node temp = new Node();
		temp = head;
		System.out.print("LINKED LIST : ");
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}
	
	private int noOfNodes() {
		Node p = new Node();
		p = head;
		int count = 0;
		while ( p.next != null) {
			p = p.next;
			count++;
		}
		return count;
	}
 
}