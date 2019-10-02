package graph;

import java.util.Stack;

/**
 * Class that uses a Depth-First Search to find paths from a source vertex to any given vertex
 * From Coursera's Algorithm's Part 2
 * 
 * @author Joseph Dempsey
 *
 */
public class Paths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	/*
	 * Note: edgeTo[w] := v, means that edge v - w taken to visit w for the first time
	 */
	/**
	 * 
	 * @param g
	 * @param s
	 */
	public Paths(Graph g, int s) {
		marked = new boolean[g.V() + 1];
		edgeTo = new int[g.V() + 1];
		this.s = s;
		
		DFS(g, s);
	}
	private void DFS(Graph g, int v) {
		// first mark s as visited
		marked[v] = true;
		for (Integer w : g.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				DFS(g, w);
			}
		}
	}
	/**
	 * 
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	/**
	 * 
	 * @param v
	 * @return
	 */
	Iterable<Integer> pathTo(int v) {
		if (!marked[v]) {
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		
		return path;
	}
}
