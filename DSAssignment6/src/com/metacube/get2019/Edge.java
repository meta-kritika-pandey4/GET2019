package com.metacube.get2019;

/**
 * It is a class that has attributes for edges 
 * @author Kritika
 *
 */
public class Edge {
	public int sourceVertex;
	public int destinationVertex;
	public int weight;
	
	/**
	 * It is a default constructor
	 */
	public Edge() {}
	 
	/**
	 * It is a constructor to initialize edge
	 * @param souceVertex
	 * @param destinationVertex
	 * @param weight
	 */
	public Edge(int souceVertex,int destinationVertex,int weight) {
		 this.sourceVertex=souceVertex;
		 this.destinationVertex=destinationVertex;
		 this.weight=weight;
	 }
}
