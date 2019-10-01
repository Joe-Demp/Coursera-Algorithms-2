package graph;

public interface Graph {
	void addEdge(int v, int w);
	Iterable<Integer> adj(int v);
	int V();
	int E();
}
