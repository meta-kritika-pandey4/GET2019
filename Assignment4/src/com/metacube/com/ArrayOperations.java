package com.metacube.com;

/**
 * This class has all the operations
 * that are to be performed as
 * given in the assignment SCF-04
 * @author Kritika
 *
 */
public class ArrayOperations {

	/**
	 * It gives the maximum mirror size
	 * forming up in the array
	 * @param n input array
	 * @return maxCount
	 */
	public int maxMirror(int[] n) {
		if(n.length==0){
			throw new AssertionError("Array is empty");
		}
		int maxCount = 0;
		for (int i = 0; i < n.length; i++) {
			int count = 0;
			for (int j = n.length - 1; j >= 0 && i + count < n.length; j--) {
				if (n[i + count] == n[j]) {
					count++;
				} else {
					maxCount = Math.max(maxCount, count);
					count = 0;
				}
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

	/**
	 * This method returns the no
	 * of clumps formed in the array
	 * @param n input array
	 * @return count
	 */
	public int countClumps(int[] n) {
		if(n.length==0){
			throw new AssertionError("Array is empty");
		}
		boolean match = false;
		int length = n.length;
		int clump = 0;
		for (int i = 0; i < length - 1; i++) {
			if (n[i] == n[i + 1] && !match) {
				match = true;
				clump++;
			} else if (n[i] != n[i + 1]) {
				match = false;
			}

		}
		return clump;
	}

	/**
	 * This method sets Y after X and
	 * places the element after X at
	 * the earlier position of the Y
	 * @param n input array
	 * @param X 
	 * @param Y
	 * @return n operated array
	 */
	public int[] fixXY(int[] n,int X,int Y) {
		if (n.length == 0) {
			throw new AssertionError("The array is empty");
		}
		if (n[n.length-1] == X) {
			throw new AssertionError("X is present at the end of the array. Not suitable array for the operation");

		}
		
		int countOfX=count(n,X);
		int countOfY=count(n,Y);
		if (countOfX != countOfY) {
			throw new AssertionError("X and Y are not equal in amount");
		}
		
		
		for (int i = 0; i < n.length-2; i++) {
			if (n[i] == X && n[i + 1] == X){
				throw new AssertionError("There are adjacent X in the array");	
			}
		}
	
		int k = 0, swap;
		for (int i = 0; i < n.length - 1; i++) {
			if (n[i] == X) {
				while (n[k] != Y && k < n.length - 1) {
					k++;
				}
				swap = n[i + 1];
				n[i + 1] = n[k];
				n[k] = swap;
				k = i + 2;
			}
		}
		return n;
	}
	
	/**
	 * This method gives the index of 
	 * the array where the sum of the
	 * elements from both sides is equal
	 * @param n input array
	 * @return index of the splitArray
	 */
	public int splitArray(int[] n) {
		if(n.length==0){
			throw new AssertionError("Array is empty");
		}
		int length = n.length;
		int leftSum = 0;
		for (int i = 0; i < length; i++) {
			leftSum += n[i];
		}
		int rightSum = 0;
		for (int j = length-1; j >= 0; j--) {
			rightSum += n[j];
			leftSum -= n[j];
			if (leftSum == rightSum){
				return j;
			}
		}

		return -1;
	}
	
	/**
	 * To count occurence of an element in the array
	 * @param n
	 * @param X
	 * @return countOfX
	 */
	public int count(int[] n, int A){
		int countOfA=0;
		for(int i=0;i<n.length;i++){
			if(n[i] == A){
				countOfA++;
			}
		}
		return countOfA;
	}
	
}



