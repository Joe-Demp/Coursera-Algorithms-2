package graph;

import java.io.File;

public class GraphTester {

	public static void main(String[] args) {
		File f = new File("sample_ug.txt");
		UndirectedGraph mygraph = UndirectedGraph.makeGraph(f);
		System.out.println(mygraph);
	}

}
