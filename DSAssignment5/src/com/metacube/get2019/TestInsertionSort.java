package com.metacube.get2019;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInsertionSort {

	@Test
	public void test() {
		SortLinkList sortObj = new SortLinkList();
		sortObj.insert(new Employee("Kritika", 21, 20000));
		sortObj.insert(new Employee("Rahul", 35, 20000));
		sortObj.insert(new Employee("Mukul", 21, 90000));
		sortObj.insert(new Employee("Srashti", 21, 10000));
		Node head = sortObj.getHead();
		Node temp =sortObj.insertionSort(head);
		assertEquals("Mukul", temp.data.getName());
	}

}
