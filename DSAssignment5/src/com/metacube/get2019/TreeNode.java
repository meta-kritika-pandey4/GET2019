package com.metacube.get2019;

/**
 * It is a class to represent the tree of a node.
 * @author Kritika
 *
 */
public class TreeNode {

	String key;
	String value;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	/**
	 * It is a constructor used to initialize key and value of node.
	 * @param key key of dictionary
	 * @param value value corresponding to key.
	 */
	TreeNode (String key, String value) {
		this.key = key;
		this.value = value;
		left = right = null;
	}
}