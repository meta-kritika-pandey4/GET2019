package com.metacube.get2019;

/**
 * Class for search methods
 * @author Kritika
 *
 */
public class Search {

	/**
	 * The method uses the Linear Search algorithm to
	 * search an element in the array
	 * @param n input array
	 * @param ele element to search
	 * @param index last index of the array to be searched
	 * @return index of the searched element
	 */
	public int linearSearch ( int[] n, int ele, int index ) {
		if( index == 0){
			return -1;
		}
		if (n.length == 0){
			return -1;
		}
		if ( n[ index - 1 ] == ele ) {
			return index - 1;
		} else {
			return linearSearch( n, ele, index-1);
		}
	}
	
	/**
	 * The method uses the Binary Search algorithm to 
	 * search an element in the array
	 * @param n input array
	 * @param start starting index
	 * @param end last index
	 * @param ele element to be searched
	 * @return index of the element to be searched
	 */
	public int binarySearch(int n[], int start, int end, int ele) {
		if (n.length == 0 || start < 0 || end < 0) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (end >= start) {
			if (n[mid] == ele) {
				return mid;
			} else if (n[mid] > ele) {
				return binarySearch(n, start, mid - 1, ele);
			} else if (n[mid] < ele) {
				return binarySearch(n, mid + 1, end, ele);
			}
		}
		return -1;
	}
}
