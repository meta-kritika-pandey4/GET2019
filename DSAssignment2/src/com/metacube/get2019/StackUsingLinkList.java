package com.metacube.get2019;

/**
 * It is a class which is used to implement a stack using linked list.
 * @author Kritika
 *
 */
public class StackUsingLinkList implements Stack {
	private Node head;
	
	/**
	 * Node class used to create a new node of linked list.
	 * @author Kritika
	 *
	 */
	class Node {
		public String data;
		public Node next = null;
		
		/**
		 * It is a default constructor.
		 */
		public Node() {
		}
		
		/**
		 * It is node class constructor used to initialize data fields of node.
		 * @param data
		 */
		public Node (String data) {
			this.data = data;
			next = null;
		}
	}
	
	/**
	 * It is method to push an element on to the stack.
	 * @param data element to be pushed.
	 */
	public void push(String data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	/**
	 * It is method used to pop an element from the stack.
	 * @return popped element.
	 */
	public String pop() {
		if (head == null) {
			System.out.println("Stack is empty!!");
			return "0";
		}
		else {
			String element = head.data;
			head = head.next;
			return element;
		}
	}
	
	/**
	 * It is a method used to return top of stack.
	 * @return top of stack
	 */
	public String peek() {
		if (head == null) {
			return "0";
		}
		return head.data;
	}
	
	/**
	 * It is a method used to check whether stack is empty or not.
	 * @return boolean value.
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * It is a method used to show elements of the stack.
	 */
	public void showStack() {
		if (head == null) {
			System.out.println("No elements in the stack!!");
		}
		else {
			Node temp;
			temp = head;
			while (temp != null) {
				System.out.println("| "+temp.data+" |");
				System.out.println("|---|");
				temp = temp.next;
			}
		}
	}
}