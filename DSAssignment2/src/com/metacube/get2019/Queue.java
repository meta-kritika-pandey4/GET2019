package com.metacube.get2019;

/**
 * It is an interface used for implementing Queue data structure.
 * @author Kritika
 *
 */
public interface Queue {
	public void enqueue(int data);
	public int dequeue();
	public boolean isFull();
	public boolean isEmpty();
}
