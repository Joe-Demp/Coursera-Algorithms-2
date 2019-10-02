package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class UndirectedGraph implements Graph {
	private HashSet<Integer>[] graph;
	private int V = 0;
	private int E = 0;
	/**
	 * Creates an empty Graph with V nodes<br>
	 * Note: vertices are indexed from 0, so if you want 12 nodes from 1 - 12, V needs to be assigned 13
	 * 
	 * @param V the number of nodes you want to represent by this graph
	 */
	@SuppressWarnings("unchecked")
	public UndirectedGraph(int V) {
		if (V <= 0) {
			throw new IllegalArgumentException("V cannot be less than or equal to 0");
		}
		
		graph = (HashSet<Integer>[]) new HashSet[V];
		for (int i = 0; i < V; ++i) {
			graph[i] = new HashSet<Integer>(V - 1);
		}
		
		this.V = V;
		this.E = 0;
	}
	/**
	 * Factory method to create a graph specified by the contents of a file
	 * The file contains:<br>
	 * Integer V, the number of vertices in the Graph<br>
	 * Integer E, the number of edges between the vertices<br>
	 * And E pairs of integers (v, w) specifying an edge between vertices v and w<br> 
	 * 
	 * @param f the file object from which you want to construct the Graph
	 * @return the graph specified by the file if the file is valid, otherwise null
	 */
	public static UndirectedGraph makeGraph(File f) {
		UndirectedGraph newGraph = null;
		try (Scanner scan = new Scanner(f)) {
			int V = scan.nextInt();	// file must contain at least V and E
			int E = scan.nextInt();
			
			newGraph = new UndirectedGraph(V);
			for (int i = 0; i < E; ++i) {
				int v = scan.nextInt();
				int w = scan.nextInt();
				
				newGraph.addEdge(v, w);
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be found");
			System.out.println(e.getMessage());
		}
		
		return newGraph;
	}
	/**
	 * Adds an edge to the graph, between vertices v and w<br>
	 * Does nothing if:<br>
	 * 1. either v or w are not vertices in the graph<br>
	 * 2. v and w refer to the same node<br>
	 * 3. v and w are already connected
	 *  
	 */
	@Override
	public void addEdge(int v, int w) {
		if (v >= 0 && v < V && w >= 0 && w < V) { // check that both v and w are in range
			// check for anomalies e.g. v = w or v - w already exists
			if (v != w && !graph[v].contains(w)) {
				graph[v].add(w);
				graph[w].add(v);
				E++;
			}
		}
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return graph[v];
	}

	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("V = " + V() + " E = " + E() + "\n");
		sb.append("Edges:\n");
		
		for (int i = 0; i < V; ++i) {
			for (Integer num : graph[i]) {
				sb.append(i + " - " + num + "\n");
			}
		}
		return sb.toString();
	}
	/**
	 * 
	 * @param g
	 * @param v
	 * @return
	 */
	public static int degree(UndirectedGraph g, int v) {
		int degree = 0;
		for (Integer num : g.adj(v)) {
			degree++;
		}
		return degree;
	}
	
}
