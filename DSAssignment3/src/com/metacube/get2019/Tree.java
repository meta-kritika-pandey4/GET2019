package com.metacube.get2019;

import java.util.*;

/**
 * It is a class to implement command prompt commands.
 * @author Kritika
 *
 */
public class Tree {
	public String indicator = "R:";
	public Node root = new Node("R");
	private Node current = root;
	private Node searchedNode;

	/**
	 * It is a method to Add directory to tree
	 * @param folderName of the directory
	 */
	public void addNode(String folderName) {
		if (search(root, folderName)) {
			System.out.println("Directory already exists!");
		} else {
			Node n = new Node(folderName);
			current.children.add(n);
			n.root = current;
			n.ts = new java.sql.Timestamp(new Date().getTime());
		}
	}

	/**
	 * It is a method to Change the directory
	 * @param folderName of the directory
	 */
	public void changeCurrent(String folderName) {
		if (search(root, folderName)) {
			indicator = indicator + "\\" + folderName;
			current = searchedNode;
		} else {
			System.out.println("Directory doesn't exist!");
		}
	}

	/**
	 * It is a method to find a directory
	 * @param folderName of the directory
	 */
	public void find(String folderName) {
		Node node = current;
		if (search(node, folderName)) {
			String string = searchedNode.folderName;
			searchedNode = searchedNode.root;
			string = searchedNode.folderName + "\\" + string;
			System.out.println(string);
		} else {
			System.out.println("Directory doesn't exist!");
		}
	}

	/**
	 * It is a method to Search a directory
	 * @param node is the current directory
	 * @param folderName of the directory
	 * @return true or false accordingly
	 */
	public boolean search(Node node, String folderName) {
		if ("null".equals(node.children)) {
			return false;
		}
		for (Node i : node.children) {
			if (folderName.equals(i.folderName)) {
				searchedNode = i;
				return true;
			} else {
				if (search(i, folderName)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * It is a method for traversal of tree
	 * @param node is the root directory
	 */
	public void breadthFirstTraversal(Node node) {
		System.out.printf("  ");
		if ("null".equals(node.children)) {
			System.out.println();
			return;
		}
		for (Node i : node.children) {
			System.out.println("\u2514" + i.folderName);
			breadthFirstTraversal(i);
		}
	}

	/**
	 * It is a method to Move back to root
	 */
	public void moveToParent() {
			indicator = indicator.replaceFirst(current.folderName, "");
			current = current.root;
	}

	/**
	 * It is a method to display list of subdirectory.
	 */
	public void listOfAllChildren() {
		if ("null".equals(current.children)) {
			System.out.println(0);
		}
		System.out.println(current.children.size());
		for (Node n : current.children) {
			System.out.println(n.folderName + " " + n.ts);
		}
	}
}