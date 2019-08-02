package com.metacube.get2019;

import java.util.*;

/**
 * It is a class Node.
 * @author Kritika
 *
 */
public class Node {
	String folderName;
	List<Node> children = new ArrayList<Node>();
	Node root;
	java.sql.Timestamp ts;

	/**
	 * It is a constructor.
	 * @param name
	 */
	public Node(String folderName){
		this.folderName = folderName;
	}
}