package graph;

import java.io.File;

public class GraphTester {

	public static void main(String[] args) {
		File f = new File("sample_ug.txt");
		UndirectedGraph mygraph = UndirectedGraph.makeGraph(f);
		System.out.println(mygraph);
		
		System.out.println("\nThe degree of vertex 1 is: " + UndirectedGraph.degree(mygraph, 1));
		System.out.println("The degree of vertex 0 is: " + UndirectedGraph.degree(mygraph, 0));
		System.out.println("The degree of vertex 3 is: " + UndirectedGraph.degree(mygraph, 3));		
	}

}
