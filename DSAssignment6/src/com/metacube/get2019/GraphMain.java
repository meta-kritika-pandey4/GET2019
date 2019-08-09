package com.metacube.get2019;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The class containing main method
 * @author Kritika
 *
 */
public class GraphMain {
	public static void main( String args[]){
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		try {
			System.out.println("Enter the no of vertices :");
			int noOfVertices = sc.nextInt();
			Graph graph = new Graph(noOfVertices);
			do {
				System.out.println("1.Insert adjacent vertices for a source");
				System.out.println("2.Show the edge list of the graph");
				System.out.println("3.Graph is connected?");
				System.out.println("4.reachability");
				System.out.println("5.minimum spanning tree");
				System.out.println("6.shortest path");
				System.out.println("7.Exit");
				int choice = sc.nextInt();
				switch(choice){
				case 1:
						LinkedList<Edge> adjacentVertices;
						adjacentVertices = new LinkedList<Edge>() { {
							add(new Edge(1,2,2));
							add(new Edge(1,3,5));
						}};
						graph.addEdge(1, adjacentVertices );
						adjacentVertices = new LinkedList<Edge>() { {
							add(new Edge(2,1,2));
							add(new Edge(2,4,4));
							add(new Edge(2,3,2));
							}
						};
						graph.addEdge( 2, adjacentVertices );
						adjacentVertices = new LinkedList<Edge>() { {
							add(new Edge(3,1,5));
							add(new Edge(3,4,5));
							add(new Edge(3,2,2));
							add(new Edge(3,5,5));}
						};
						graph.addEdge(3, adjacentVertices );
						adjacentVertices = new LinkedList<Edge>() { {
							add(new Edge(4,5,2));
							add(new Edge(4,3,5));
							add(new Edge(4,2,4));
							}
						};
						graph.addEdge(4, adjacentVertices );
						adjacentVertices = new LinkedList<Edge>() { {
							add(new Edge(5,3,5));
							add(new Edge(5,4,2));}
						};
						graph.addEdge(5, adjacentVertices );
					break;
				case 2:
					System.out.println("The graph is as follows");
					graph.showGraph();
					break;
				case 3:
					boolean result=graph.isConnected();
					System.out.println(result);
					if( result ){
						System.out.println("The graph is connected.");
					} else {
						System.out.println("The graph is not connected");
					}
					break;
				case 4:
					System.out.println("Enter the vertex for which you want information :");
					int source = sc.nextInt();
					ArrayList<Integer> reachableNodes = graph.isReachable(source);
					System.out.println("Reachable nodes are :");
					for( int i : reachableNodes){
						System.out.print(i+" ");
					}
					break;
				case 5:
					System.out.println("Minimum spanning tree is as follows :");
					Graph mst=graph.mst(1);
					mst.showGraph();
					break;
				case 6:
					System.out.println("Enter the sourceVertex :");
					int sourceVertex = sc.nextInt();
					System.out.println("Enter the destinationVertex :");
					int destinationVertex = sc.nextInt();
					System.out.println("The shortest distance from "+sourceVertex+" to "+destinationVertex+" is :"+ graph.shortestPath(sourceVertex, destinationVertex));
					System.out.printf("%n");
					break;
				case 7:
					isExit = true;
					System.out.println("Exit!!!");
					break;
				default:
					System.out.println("Invalid input");
				}
			}while(!isExit);
		} catch ( InputMismatchException e){
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}
