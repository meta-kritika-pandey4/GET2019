package com.metacube.get2019;

/**
 * It is an immutable class IntSet used to implement set operations.
 * @author Kritika
 *
 */
public final class IntSet {

	private int length;
	private int set[] = new int[1000];

	/**
	 * It is a constructor used to initialize set and length values
	 * @param set 
	 * @param length length of set.
	 */
	IntSet(int[] set, int length) {
		for (int i = 0; i < length; i++) {
			this.set[i] = set[i];
		}
		this.length = length;
	}

	/**
	 * Sorting
	 * @param set
	 * @param length
	 */
	private void sortArray(int[] set,int length) {
		 for (int i = 0; i < length; i++){
			 for (int j = i + 1; j < length; j++) {
				 if (set[i] > set[j]){
	                     int temp = set[i];
	                    set[i] = set[j];
	                    set[j] = temp;
	             }
	         }
	    }
	}

	/**
	 * It is a method used to find whether x is a member of set or not.
	 * @param x
	 * @return boolean value
	 */
	public boolean isMember(int x) {
		for (int i = 0; i < this.length; i++) {
			if (set[i] == x) {
				return true;
			}
		}
		return false;
	}

	/**
	 * It is a method used to return size of set.
	 * @return size of set
	 */
	public int size() {
		return this.length;
	}

	/**
	 * It is method used to check whether a particular is subset of set or not.
	 * @param s set
	 * @return boolean value.
	 */
	public boolean isSubSet(IntSet s) {
		int length1 = s.length;
		int i = 0, j = 0;
		sortArray(this.set, this.length);
		sortArray(s.set, length1);
		while (i < this.length && j < length1) {
			if (this.set[i] < s.set[j]) {
				i++;
			} else if (this.set[i] == s.set[j]) {
				i++;
				j++;
			} else if (this.set[i] > s.set[j]) {
				return false;
			}
		}
		return (j < length1) ? false : true;
	}

	/**
	 * It is a method used to find complement of the given set.
	 * @return complement set
	 */
	public IntSet getComplement() {
		int[] complement = new int[1000];
		IntSet s = new IntSet(complement, 1000 - this.length);
		sortArray (set, length);			
		int i = 1, j = 0, k = 0;
		while (i <= 1000 && j < length) {
			if(i != set[j]) {
				s.set[k] = i;
				i++;
				k++;
			}
			else {
				j++;
				i++;
			}
		}
		while (i <= 1000) {
			s.set[k] = i;
			i++;
			k++;
		}
		
		return s;
	}

	/**
	 * It is method used to find union of set s1 & s2.
	 * @param s1 set1
	 * @param s2 set2
	 * @return union of s1 & s2.
	 */
	public IntSet union(IntSet s1, IntSet s2) {
		int length1 = s1.length;
		int length2 = s2.length;
		int[] union = new int[length1 + length2];
		IntSet s = new IntSet(union, length1 + length2);
		sortArray(s1.set, length1);
		sortArray(s2.set, length2);
		int i = 0, j = 0, k = 0;
		while (i < length1 && j < length2) {
			if (s1.set[i] < s2.set[j]) {
				s.set[k] = s1.set[i];
				i++;
			} else if (s1.set[i] == s2.set[j]) {
				s.set[k] = s1.set[i];
				i++;
				j++;
				(s.length)--;
			} else {
				s.set[k] = s2.set[j];
				j++;
			}
			k++;
		}
		while (i < length1) {
			s.set[k] = s1.set[i];
			k++;
			i++;
		}
		while (j < length2) {
			s.set[k] = s2.set[j];
			j++;
			k++;
		}
		return s;
	}

	public int[] getSet(){
		int[] arr = new int[length] ;
		for(int i = 0; i < length; i++){
			arr[i]=set[i];
		}
		return arr;
	}
	
}
