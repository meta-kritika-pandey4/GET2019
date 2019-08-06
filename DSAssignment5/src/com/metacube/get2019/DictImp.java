package com.metacube.get2019;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

/**
 * It is a class which is implementing dictionary interface.
 * @author Kritika
 *
 */
public class DictImp implements Dictionary {

	private TreeNode root;

	/**
	 * It is a default constructor.
	 */
	DictImp() {}
	
	/**
	 * It is a method to initialize dictionary using json object.
	 * @param jsonObject json object
	 * @throws Exception
	 */
	DictImp(JSONObject jsonObject) throws Exception {
		this.root = null;
		this.input(jsonObject);
	}

	/**
	 * It is a method to parse json and set value of key and value
	 * @param jsonObject json object.
	 * @return boolean value.
	 */
	private boolean input(JSONObject jsonObject) {

		for (Object obj : jsonObject.keySet()) {
			String key = (String) obj;
			String value = (String) jsonObject.get(key);
			this.add(key, value);
		}
		return true;
	}

	/**
	 * It is a method to add a new key value pair to the tree.
	 */
	public boolean add(String key, String value) {
		if (key.length() == 0 || value.length() == 0 || key == null
				|| value == null) {
			throw new NullPointerException("Invalid key and value");
		}
		if (root == null) {
			root = new TreeNode(key, value);
		} else {
			addRec(key, value, root);
		}
		return false;
	}

	/**
	 * It is a recursive method to insert (key, value) pair at correct position. 
	 * @param key key to be inserted
	 * @param value value to be inserted
	 * @param treeNode reference to the node of tree.
	 * @return boolean value.
	 */
	private boolean addRec(String key, String value, TreeNode treeNode) {
		if (key.compareTo(treeNode.key) <= -1) {
			if (treeNode.left != null) {
				addRec(key, value, treeNode.left);
			} else {
				treeNode.left = new TreeNode(key, value);
				treeNode.left.parent = treeNode;
			}
		} else if (key.compareTo(treeNode.key) >= 1) {
			if (treeNode.right != null) {
				addRec(key, value, treeNode.right);
			} else {
				treeNode.right = new TreeNode(key, value);
				treeNode.right.parent = treeNode;
			}
		} else {
			treeNode = new TreeNode(key, value);
		}
		return true;
	}

	/**
	 * It is a method to delete a key from dictionary.
	 * @return boolean value.
	 */
	public boolean delete(String key) {

		if (key.length() == 0 || key == null) {
			throw new NullPointerException("Invalid key and value");
		}
		if (root == null) {
			System.out.println("Dictionary is empty!!!");
		} else {
			deleteRec(key, root);
		}
		return false;
	}

	/**
	 * It is a recursive method to delete a key.
	 * @param key 
	 * @param treeNode
	 * @return boolean value
	 */
	private boolean deleteRec(String key, TreeNode treeNode) {
		if (key.compareTo(treeNode.key) <= -1) {
			if (treeNode.left != null) {
				return deleteRec(key, treeNode.left);
			}
		} else if (key.compareTo(treeNode.key) >= 1) {
			if (treeNode.right != null) {
				return deleteRec(key, treeNode.right);
			}
		} else if (key.compareTo(treeNode.key) == 0) {
			if (treeNode.left == null && treeNode.right == null) {
				if (treeNode.parent.left == treeNode) {
					treeNode.parent.left = null;
				} else {
					treeNode.parent.right = null;
				}
			} else if (treeNode.left == null && treeNode.right != null  && treeNode.parent != null) {
				if (treeNode.parent.left == treeNode) {
					treeNode.parent.left = treeNode.right;
				} else {
					treeNode.parent.right = treeNode.right;
				}
			} else if (treeNode.right == null && treeNode.left != null  && treeNode.parent != null) {
				if (treeNode.parent.right == treeNode) {
					treeNode.parent.right = treeNode.left;
				} else {
					treeNode.parent.left = treeNode.left;
				}
			} else {
				TreeNode inorderSucc = findMin(treeNode.right);
				treeNode.key = inorderSucc.key;
				treeNode.value = inorderSucc.value;
				return deleteRec(inorderSucc.key, inorderSucc);
			}
		}

		return true;
	}

	/**
	 * It is a method to find minimum.
	 * @param currentNode 
	 * @return reference to node with minimum value.
	 */
	private TreeNode findMin(TreeNode currentNode) {
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode;

	}

	/**
	 * It is a method to find inorder successor sequence.
	 * @param root root of tree
	 * @param list list of nodes 
	 * @return list inordered list
	 */
	private List<Value> inorderRec(TreeNode root, List<Value> list) {
		if (root != null) {
			inorderRec(root.left, list);
			list.add(new Value(root.key, root.value));
			inorderRec(root.right, list);
		}
		return list;
	}

	/**
	 * It is a method to get value corresponding to particular key.
	 */
	public String getValue(String key) {
		if (root != null) {
			return getValueRec(key, root);
		}
		return null;
	}

	/**
	 * It is a recursive method to find value.
	 * @param key key whose value to be find.
	 * @param treeNode
	 * @return value
	 */
	private String getValueRec(String key, TreeNode treeNode) {
		if (treeNode == null) {
			return null;
		} else if (key.compareTo(treeNode.key) == 0) {
			return treeNode.value;
		} else if (key.compareTo(treeNode.key) <= -1) {
			return getValueRec(key, treeNode.left);
		} else if (key.compareTo(treeNode.key) >= 1) {
			return getValueRec(key, treeNode.right);
		} else
			return null;
	}

	/**
	 * It is a method to return sorted list of key value pair.
	 * @return sorted list of key value.
	 */
	public List<Value> getAll() {
		List<Value> valueList = new ArrayList<Value>();
		if (root != null) {
			valueList = inorderRec(root, valueList);
		}
		return valueList;
	}

	/**
	 * It is a method to return the sorted list of key value pairs for all the keys >=K1 and <=K2.
	 * @return list
	 */
	public List<Value> getBetween(String key1, String key2) {
		List<Value> list = getAll();
		List<Value> finalList = new ArrayList<Value>();
		for (Value v : list) {
			if (v.key.compareTo(key1) >= 1 && v.key.compareTo(key2) <= -1) {
				finalList.add(v);
			}
		}
		return finalList;
	}
	
	/**
	 * It is a method to show elements of list.
	 * @param list
	 */
	public void showList(List<Value> list) {
		System.out.print(" { ");
		for (Value v : list) {
			System.out.print(v.key + " : " + v.value + ", ");
		}
		System.out.println(" } ");
	}

}