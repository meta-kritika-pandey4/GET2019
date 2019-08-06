package com.metacube.get2019;

/**
 * It is class used to create a node of linked list.
 * @author Kritika
 *
 */
public class Node {

	Employee data;
	Node next = null;

	/**
	 * It is default constructor of class.
	 */
	Node() {}

	/**
	 * It is a constructor used to initialize a node.
	 * @param data value of data field of node.
	 */
	Node(Employee data) {
		this.data = data;
		next = null;
	}
}