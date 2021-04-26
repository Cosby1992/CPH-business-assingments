package main.weightedGraph;

import main.dijktras.DijktrasAlgoritm;
import main.weightedGraph.interfaces.Graph;
import main.weightedGraph.interfaces.GraphFactory;

public class Test {

    public static void main(String[] args) {

        // Using the GraphFactory to build a new graph from a file
        Graph graph = GraphFactory.createGraphFromFile("graph.txt");

        DijktrasAlgoritm dAlgoritm = new DijktrasAlgoritm(graph, 0);

        // Printing the graph to the console
        System.out.println(graph);
        
        // Building a graph without a file 
        // Graph graphNotFromFile = new GraphImpl(4);

        // graphNotFromFile.addEdge(0, 3, 1)
        //                  .addEdge(0, 2, 2)
        //                  .addEdge(1, 3, 4)
        //                  .addEdge(2, 3, 3);

        // System.out.println(graphNotFromFile);

    }
    
}
