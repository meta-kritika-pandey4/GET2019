package com.metacube.get2019;

/**
 * It is a class that has attributes for edges 
 * @author Kritika
 *
 */
public class Edge {
	private int sourceVertex;
	private int destinationVertex;
	private int weight;
	
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
		 this.setDestinationVertex(destinationVertex);
		 this.setWeight(weight);
	 }


	/**
	 * getter method for destinationVertex
	 * @return destinationVertex
	 */
	public int getDestinationVertex() {
		return destinationVertex;
	}

	/**
	 * setter method for destinationVertex
	 *
	 */
	public void setDestinationVertex(int destinationVertex) {
		this.destinationVertex = destinationVertex;
	}

	/**
	 * getter method for weight
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * setter method for weight
	 * 
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
