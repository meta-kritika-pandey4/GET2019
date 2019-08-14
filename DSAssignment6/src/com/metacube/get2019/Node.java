package com.metacube.get2019;

/**
 * It is a class of nodes
 * @author Kritika
 *
 */
public class Node {
	private Employee data;
	private Node next = null;

	/**
	 * It is default constructor of class.
	 */
	Node() {}

	/**
	 * It is a constructor used to initialize a node.
	 * @param data value of data field of node.
	 */
	Node(Employee data) {
		this.setData(data);
		setNext(null);
	}


	/**
	 * getter method for next
	 * @return next
	 */
	public Node getNext() {
		return next;
	}


	/**
	 * setter method for next
	 * 
	 */
	public void setNext(Node next) {
		this.next = next;
	}


	/**
	 * getter method for data
	 * @return data
	 */
	public Employee getData() {
		return data;
	}


	/**
	 * setter method for data
	 * 
	 */
	public void setData(Employee data) {
		this.data = data;
	}
}