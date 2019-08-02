package com.metacube.get2019;

/**
 * It is a class to store the bowlers in a heap data structure
 * @author kritika
 *
 */
public class BowlerHeap { 
	private Bowler[] Heap; 
    private int size; 
    private int maxsize;
    private Bowler b;

  
    /**
     * It is a constructor of BowlerHeap class
     * @param maxsize
     */
    public BowlerHeap(int totalBowlers){ 
    	b=new Bowler("",Integer.MAX_VALUE);
        this.maxsize = totalBowlers; 
        this.size = 0; 
        Heap = new Bowler[this.maxsize + 1]; 
        Heap[0] = b;
    } 
  
    /**
     * This method gives the position of the parent node
     * @param pos position of the node
     * @return position of the parent node
     */
    private int parent(int pos) {
        return pos / 2; 
    } 
  
    /**
     * This method gives the position of the left child
     * @param pos position of the node
     * @return position of the left child
     */
    private int leftChild(int pos) {
        return (2 * pos); 
    } 
    
    /**
     * This method gives the position of the right child
     * @param pos position of the node
     * @return position of the right child
     */
    private int rightChild(int pos) {
        return (2 * pos) + 1; 
    } 
  
    /**
     * This method tells whether a node is a leaf
     * @param pos position of the node
     * @return boolean
     */
    private boolean isLeaf(int pos) {
        if (pos >=((size+1) / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    /**
     * This method swaps the position of the nodes
     * @param fpos position of a node
     * @param spos position of the other node
     */
    private void swap(int fpos, int spos) {
        Bowler temp; 
        temp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = temp; 
    } 
  
    /**
     * This method heapify the tree.
     * @param pos 
     */
    private void maxHeapify(int pos){ 
        if (isLeaf(pos)) {
           return; 
        }
        if (Heap[pos].getBallQuota() < Heap[leftChild(pos)].getBallQuota() 
        		|| Heap[pos].getBallQuota() < Heap[rightChild(pos)].getBallQuota()) { 
            if (Heap[leftChild(pos)].getBallQuota() > Heap[rightChild(pos)].getBallQuota()) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  
    /**
     * This method adds elements in the tree
     * @param b element
     */
    public void insert(Bowler b){
        Heap[++size] = b; 
        int current = size; 
        while (Heap[current].getBallQuota() > Heap[parent(current)].getBallQuota()) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
        maxHeapify(1); 
    } 
    
    /***
     * This method extracts the max element from the heap
     * @return popped
     */
    public Bowler extractMax() {
    	Bowler popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1);
        return popped; 
    } 
} 
  