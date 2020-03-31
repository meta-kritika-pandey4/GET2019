package com.metacube.get2019;

/**
 * class representing the max heap of bowlers
 * @author Kritika
 *
 */
public class BowlerHeap { 
	public Bowler[] Heap; 
	public int size; 
	public int maxsize; 
	Bowler b;

	/**
	 * Constructor to initialize an empty max heap with given maximum capacity.
	 * @param maxsize is the maximum size with which the heap is to be initialised
	 */
	public BowlerHeap(int maxsize) {
		b=new Bowler("",Integer.MAX_VALUE);
		this.maxsize = maxsize; 
		this.size = 0; 
		Heap = new Bowler[this.maxsize + 1]; 
		Heap[0] =b;
	} 
	
	/**
	 * Returns position of parent 
	 * @param pos of the node whose parent is to be returned
	 * @return int position of parent
	 */
	private int parent(int pos) {
		return pos / 2; 
	} 

	/** 
	 * Below two functions return left and right children.
	 * @param pos is the position of the node whose left and right child is to be returned
	 * @return int position of the left and right child
	 */
	private int leftChild(int pos) {
		return (2 * pos); 
	} 
	
	private int rightChild(int pos) {
		return (2 * pos) + 1; 
	} 

	/**
	 * Returns true if given node is leaf 
	 * @param pos which is to be checked
	 * @return boolean true if the given node is leaf else returns false
	 */
	private boolean isLeaf(int pos) {
		if (pos >=((size+1) / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 
	
	/**
	 * this method is used to swap the nodes at the two positions
	 * @param fpos is one position
	 * @param spos is another position
	 */
	private void swap(int fpos, int spos) {
		Bowler temp; 
		temp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = temp; 
	} 

	/**
	 *  A recursive function to max heapify the given subtree
	 * @param pos is the position of the root
	 */
	private void maxHeapify(int pos) {
		if (isLeaf(pos)) {
			return; 
		}
		if (Heap[pos].getBallQuota() < Heap[leftChild(pos)].getBallQuota() || Heap[pos].getBallQuota() < Heap[rightChild(pos)].getBallQuota()) { 

			if (Heap[leftChild(pos)].getBallQuota() > Heap[rightChild(pos)].getBallQuota()) { 
				swap(pos, leftChild(pos)); 
				maxHeapify(leftChild(pos)); 
			} 
			else { 
				swap(pos, rightChild(pos)); 
				maxHeapify(rightChild(pos)); 
			} 
		} 
	} 

	/**
	 *  Inserts a new bowler to max heap 
	 * @param bowler is the object of the Bowler class which is to be inserted in the maxHeap
	 */
	public void insert(Bowler bowler) {
		Heap[++size] = bowler; 
		int current = size; 
		while (Heap[current].getBallQuota() > Heap[parent(current)].getBallQuota()) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
		maxHeapify(1); 
	} 

	/**
	 * Remove the maximum element from max heap 
	 * @return the object of class Bowler 
	 */
	public Bowler extractMax() {
		Bowler popped = Heap[1]; 
		Heap[1] = Heap[size--]; 
		maxHeapify(1);
		return popped; 
	} 
	
	/**
	 * This method finds the sequence of bowlers in the game
	 * @param numberOfBowlers
	 * @param bowlerList
	 * @param numberOfBalls
	 * @return result
	 */
	public String findSequence(int numberOfBowlers,Bowler[] bowlerList,int numberOfBalls) {
		if( numberOfBalls == 0 ) {
			throw new AssertionError("Number of balls given = 0");
		}
		if( numberOfBowlers == 0 ) {
			throw new AssertionError("Number of bowlers given = 0");
		}
		StringBuffer bowlerSequence=new StringBuffer();
		BowlerHeap bowlSeq = new BowlerHeap(numberOfBowlers);
		Bowler bowlerExtracted;
		for( Bowler bowler:bowlerList ) {
			bowlSeq.insert(bowler);
		}
		for( int i = 0; i < numberOfBalls; i++ ){
			bowlerExtracted = bowlSeq.extractMax();
			if( i == numberOfBalls - 1 ) {
				bowlerSequence.append(bowlerExtracted.getName());
			} else {
				bowlerSequence.append(bowlerExtracted.getName());
				bowlerSequence.append(" ");
				bowlerExtracted.setBallQuota();
				if( ! ( bowlerExtracted.getBallQuota() == 0 ) ) {
					bowlSeq.insert( bowlerExtracted );
				}
			}
		}
		System.out.print("Sequence of bowlers in which they give their balls :-");
		System.out.println(bowlerSequence);
		String result = bowlerSequence.toString();
		return result;
	} 
}