package com.metacube.get2019;

import java.util.ArrayList;

/**
 * It is a graph interface
 * @author Kritika
 *
 */
public interface GraphInterface {
	public boolean isConnected();
	public ArrayList<Integer> isReachable(int a);
	public Graph mst(int sourceVertex);
	public int shortestPath(int sourceVertex, int destinationVertex);

}
