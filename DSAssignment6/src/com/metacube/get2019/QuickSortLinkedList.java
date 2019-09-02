package com.metacube.get2019;

/**
 * This is a class to implement quick sort on linked list
 * @author Kritika
 *
 */
public class QuickSortLinkedList {
	private Node head;
	private Node rear;
	
	/**
	 * default constructor for linked list
	 */
	public QuickSortLinkedList() {
		setHead(setRear(null));
	}
	
	/**
	 * This is a method to add a new data into the linked list
	 * @param data is the value of the new node to be added
	 */
	public void add(Employee data) {
		Node newNode=new Node(data);
		if(getHead()==null) {
			setHead(setRear(newNode));
		} else {
			getRear().setNext(newNode);
			setRear(newNode);
		}
	}
	
	/**
	 * This method returns the correct position of the pivot element
	 * @param front is the first node of the list
	 * @param last is the last node of the list
	 * @return returns the pivot node that partitions the list
	 */
	public Node partition(Node front,Node last) {
		Node currentNode;
		Employee temp;
		if(this.getHead()==front) {
			currentNode=null;
		} else {
			currentNode=this.getHead();
			while(currentNode.getNext()!=front)
			{
				currentNode=currentNode.getNext();
			}
		}
		Node i=currentNode;
		Employee pivot=last.getData();
		Node j=front;
		while(j!=last) {
			if(j.getData().getSalary()>pivot.getSalary()||((j.getData().getSalary()==pivot.getSalary())&&(j.getData().getAge()<pivot.getAge()))) {
				if(i==null)
					i=front;
				else
					i=i.getNext();
				temp =i.getData();
				i.setData(j.getData());
				j.setData(temp);
			}
			j=j.getNext();
		}
		if(i==null) {
			i=front;
		} else {
			i=i.getNext();
		}
		temp=i.getData();
		i.setData(last.getData());
		last.setData(temp);
		return i;
	}
	
	/**
	 * This method is used to print the linked list
	 * @param front is the first node of the list
	 * @param last is the last node of the list
	 */
	public void showLinkedList(Node front,Node last) {
		Node currentNode=front;
		while(currentNode!=last) {
			System.out.print(currentNode.getData().getEmpName()+"-->");
			currentNode=currentNode.getNext();
		}
		System.out.println(currentNode.getData().getEmpName());
	}
	
	/**
	 * This is the recursive method to perform quick sort
	 * @param front is the first element of the list
	 * @param last is the last element of the list
	 */
	public void recursiveQuickSort(Node front,Node last) {
		if(last==front.getNext()) {
			if((front.getData().getSalary()<last.getData().getSalary())||((front.getData().getSalary()==last.getData().getSalary())&&(front.getData().getAge()<last.getData().getAge()))) {
				Employee temp=front.getData();
				front.setData(last.getData());
				last.setData(temp);
			}
		} else if(front!=null && last!=front) { 
			Node partition = partition(front,last); 
			Node currentNode=front;
			while(currentNode.getNext()!=partition) {
				currentNode=currentNode.getNext();
			}
			recursiveQuickSort(front,currentNode); 
			recursiveQuickSort(partition.getNext(),last); 
		} 
	}
	
	/**
	 * This method is used to call the recursive quicksort method
	 * @param front is the first element of the list
	 * @param last is the last element of the list
	 */
	public void quickSort(Node front,Node last) {
		if(front==null){
			throw new AssertionError("Empty linked list");
		} else {
			recursiveQuickSort(front, last);
		}
	}
	
	/**
	 * The main function
	 * @param args
	 */
	public static void main(String[] args) {
		QuickSortLinkedList linkedlist=new QuickSortLinkedList();
		Employee employee1=new Employee("Vertika",22,15000);
		Employee employee2=new Employee("Riya",22,32000);
		Employee employee3=new Employee("Sachet",22,25000);
		Employee employee4=new Employee("Vanshaj",21,25000);
		linkedlist.add(employee1);
		linkedlist.add(employee2);
		linkedlist.add(employee3);
		linkedlist.add(employee4);
		
		linkedlist.showLinkedList(linkedlist.getHead(),linkedlist.getRear());
		linkedlist.quickSort(linkedlist.getHead(),linkedlist.getRear());
		linkedlist.showLinkedList(linkedlist.getHead(),linkedlist.getRear());
	}

	/**
	 * getter method for head
	 * @return head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * setter method for head
	 * 
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * getter method for rear
	 * @return rear
	 */
	public Node getRear() {
		return rear;
	}

	/**
	 * setter method for head
	 *
	 */
	public Node setRear(Node rear) {
		this.rear = rear;
		return rear;
	}
}