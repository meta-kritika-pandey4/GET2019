package com.metacube.get2019;

import java.util.*;

/**
 * It is a class with main method.
 * @author Kritika
 */
public class CommandPrompt {

	/**
	 * It is a main method
	 * @param args unused
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			Tree directoryTree = new Tree();
			String input;
			String[] command;
			boolean isExit = false;
			System.out.println("Welcome to Virtual Command Prompt!");

			do {
				System.out.print(directoryTree.indicator);
				String str = sc.nextLine();
				command = str.split(" ");
				switch (command[0]) {
				case Constant.MAKE_DIRECTORY:
					directoryTree.addNode(command[1]);
					break;
				case Constant.CHANGE_DIRECTORY:
					directoryTree.changeCurrent(command[1]);
					break;
				case Constant.BACK:
					directoryTree.moveToParent();
					break;
				case Constant.LIST_ALL:
					directoryTree.listOfAllChildren();
					break;
				case Constant.FIND:
					directoryTree.find(command[1]);
					break;
				case Constant.TREE:
					directoryTree.breadthFirstTraversal(directoryTree.root);
					break;
				case Constant.EXIT:
					System.exit(0);
					break;
				default:
					System.out.println("Command doesn't exist!");
				}
			} while (!isExit);
		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
} 