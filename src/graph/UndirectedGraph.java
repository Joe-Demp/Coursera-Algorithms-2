package graph;

import java.io.File;
import java.util.HashSet;

public class UndirectedGraph implements Graph {
	private HashSet<Integer>[] graph;
	private int V = 0;
	private int E = 0;
	/**
	 * Creates an empty Graph with V nodes
	 * 
	 * @param V the number of nodes you want to represent by this graph
	 */
	@SuppressWarnings("unchecked")
	public UndirectedGraph(int V) {
		graph = (HashSet<Integer>[]) new HashSet[V];
		for (int i = 0; i < V; ++i) {
			graph[i] = new HashSet<Integer>(V - 1);
		}
		this.V = V;
		this.E = 0;
	}
	/**
	 * Creates a graph specified by the contents of the file
	 * [describe the file structure]
	 * 
	 * @param f the file object from which you want to construct the Graph
	 */
	public UndirectedGraph(File f) {
		
	}
	
	@Override
	public void addEdge(int v, int w) {
		// TODO Auto-generated method stub
		// TODO check for anomalies e.g. v = w or v - w already exists
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

}
