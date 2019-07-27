package Graph;

import java.util.HashMap;

public class GraphClient {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 1);
		g.addEdge("A", "D", 2);
		g.addEdge("B", "C", 3);
		g.addEdge("C", "D", 4);
		g.addEdge("D", "E", 54);
		g.addEdge("E", "F", 5);
		g.addEdge("E", "G", 56);
		g.addEdge("F", "G", 10);
		g.display();
//		System.out.println(g.numEdges());
//		System.out.println(g.numVertex());
//		System.out.println(g.containVertex("A"));
//		System.out.println(g.containVertex("e"));
//		System.out.println(g.containEdge("A", "B"));
//		System.out.println(g.containEdge("A", "H"));
		g.removeEdge("D", "E");
//		g.display();
//		g.removeVertex("A");
//		g.display();

		System.out.println(g.hasPath("A","F",new HashMap<>()));
		System.out.println(g.bfs("A", "F"));
		System.out.println(g.dfs("A", "F"));
		 g.bft();
		 g.dft();
		 System.out.println(g.isCyclic());
		 System.out.println(g.isConnected());
		 System.out.println(g.isTree());
		 System.out.println(g.getConnectedComponents());

	}

}
