package Graph;

public class Graph2Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V=5;
		Graph2 graph = new Graph2(V); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 4); 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        graph.display();


	}

}
