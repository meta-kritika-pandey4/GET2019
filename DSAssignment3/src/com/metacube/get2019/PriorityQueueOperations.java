package com.metacube.get2019;

/**
 * It is a class used to implement priority queue.
 * @author Kritika
 *
 */
public class PriorityQueueOperations implements PriorityQueue {

	int priQueue[];
	int itemCount = 0;
	int queueSize;
	
	/**
	 * It is a constructor used to intialize priority queue
	 * @param queueSize size of queue
	 */
	PriorityQueueOperations (int queueSize) {
		this.queueSize = queueSize;
		priQueue = new int[2 * queueSize];
	}
	
	/**
	 * It is a method used to check whether queue is full or not.
	 * @return boolean value.
	 */
	public boolean isFull() {
		if ( itemCount == 2 * queueSize ) {
			return true;
		}
		return false;
	}
	
	/**
	 * It is a method used to check whether queue is empty or not.
	 * @return boolean value.
	 */
	public boolean isEmpty() {
		if ( itemCount == 0 ) {
			return true;
		}
		return false;
	}
	
	/**
	 * It is a method used to add an element to priority queue.
	 * @param data element value to be inserted.
	 * @param priority priority of element.
	 */
	public void enqueue(int data, int priority) {
		if (!isFull()) {
			priQueue[itemCount++] = data;
			priQueue[itemCount++] = priority;
		}
		else {
			System.out.println("Queue is full!!!");
		}
	}
	
	/**
	 * It is method to return an element with highest priority.
	 * @return highest priority element.
	 */
	public int getHighestPriority() {
		int max = 0;
		int item = 0;
		for (int i = 1; i < itemCount; i += 2) {
			if (priQueue[i] > max) {
				max = priQueue[i];
				item = priQueue[i - 1];
			}
		}
		return item;
	}
	
	/**
	 * It is method to delete highest priority element from queue.
	 * @return deleted element value.
	 */
	public int dequeue() {
		if (!isEmpty()) {
			int priority = 0;
			int index = 0;
			for (int  i = 1; i < itemCount; i += 2) {
				if (priority < priQueue[i]) {
					priority = priQueue[i];
					index = i;
				}
			}
			int item  = priQueue[index - 1];
			priQueue[index - 1] = priQueue[itemCount - 2];
			priQueue[index] = priQueue[itemCount - 1];
			itemCount -= 2;
			return item;
		}
		else {
			System.out.println("Queue is empty!!!");
			return -1;
		}
	}
	
	/**
	 * It is method used to show elements with there priority.
	 */
	public void show() {
		System.out.println("-----------------------------");
		for (int  i = 0; i < itemCount; i += 2) {
			System.out.print("| "+priQueue[i] + " : " + priQueue[i + 1] + " | ");
		}
		System.out.println("\n-----------------------------");
	}
}
