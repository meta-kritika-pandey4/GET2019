package com.metacube.get2019;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * It is a test case for quickSort() of QuickSortLinkedList
 * @author Kritika
 *
 */
public class TestQuickSort {
	
	@Test
	public void testQuickSort() {
		QuickSortLinkedList linkedlist=new QuickSortLinkedList();
		Employee employee1=new Employee("Vertika",22,15000);
		Employee employee2=new Employee("Riya",22,32000);
		Employee employee3=new Employee("Sachet",22,25000);
		Employee employee4=new Employee("Vanshaj",21,25000);
		linkedlist.add(employee1);
		linkedlist.add(employee2);
		linkedlist.add(employee3);
		linkedlist.add(employee4);
		linkedlist.quickSort(linkedlist.getHead(),linkedlist.getRear());
		QuickSortLinkedList expectedLinkedlist=new QuickSortLinkedList();
		expectedLinkedlist.add(employee2);
		expectedLinkedlist.add(employee4);
		expectedLinkedlist.add(employee3);
		expectedLinkedlist.add(employee1);
		
		Node currentNodeExpected=expectedLinkedlist.getHead();
		Node currentNodeActual=linkedlist.getHead();
		while(currentNodeExpected!=null)
		{
			assertEquals(currentNodeExpected.getData().getEmpName(),currentNodeActual.getData().getEmpName());
			currentNodeExpected=currentNodeExpected.getNext();
			currentNodeActual=currentNodeActual.getNext();
		}
	}
	@Test(expected=AssertionError.class)
	public void testQuickSortForEmptyList() {
		QuickSortLinkedList linkedlist=new QuickSortLinkedList();
		linkedlist.quickSort(linkedlist.getHead(),linkedlist.getRear());
	}

}