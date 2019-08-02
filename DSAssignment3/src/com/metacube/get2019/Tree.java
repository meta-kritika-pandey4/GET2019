package com.metacube.get2019;

import java.util.*;

/**
 * It is a class to implement command prompt commands.
 * @author Kritika
 *
 */
public class Tree {
	String indicator = "R:";
	Node root = new Node("R");
	Node current = root;
	Node searchedNode;

	/**
	 * It is a method to Add directory to tree
	 * @param folderName of the directory
	 */
	public void addNode(String folderName) {
		try {
			if (search(root, folderName)) {
				System.out.println("Directory already exists!");
			} else {
				Node n = new Node(folderName);
				current.children.add(n);
				n.root = current;
				n.ts = new java.sql.Timestamp(new Date().getTime());
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * It is a method to Change the directory
	 * @param folderName of the directory
	 */
	public void changeCurrent(String folderName) {
		try {
			if (search(root, folderName)) {
				indicator = indicator + "\\" + folderName;
				current = searchedNode;
			} else {
				System.out.println("Directory doesn't exist!");
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * It is a method to find a directory
	 * @param folderName of the directory
	 */
	public void find(String folderName) {
		try {
			Node node = current;
			if (search(node, folderName)) {
				String string = searchedNode.folderName;
				searchedNode = searchedNode.root;
				string = searchedNode.folderName + "\\" + string;
				System.out.println(string);
			} else {
				System.out.println("Directory doesn't exist!");
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * It is a method to Search a directory
	 * @param node is the current directory
	 * @param folderName of the directory
	 * @return true or false accordingly
	 */
	public boolean search(Node node, String folderName) {
		try {
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
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return false;
	}

	/**
	 * It is a method for traversal of tree
	 * @param node is the root directory
	 */
	public void breadthFirstTraversal(Node node) {
		try {
			System.out.printf("  ");
			if ("null".equals(node.children)) {
				System.out.println();
				return;
			}
			for (Node i : node.children) {
				System.out.println("\u2514" + i.folderName);
				breadthFirstTraversal(i);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * It is a method to Move back to root
	 */
	public void moveToParent() {
		try {
			indicator = indicator.replaceFirst(current.folderName, "");
			current = current.root;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * It is a method to display list of subdirectory.
	 */
	public void listOfAllChildren() {
		try {
			if ("null".equals(current.children)) {
				System.out.println(0);
			}
			System.out.println(current.children.size());
			for (Node n : current.children) {
				System.out.println(n.folderName + " " + n.ts);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}