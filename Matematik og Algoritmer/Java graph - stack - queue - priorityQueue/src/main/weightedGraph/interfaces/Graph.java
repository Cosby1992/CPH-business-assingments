package main.weightedGraph.interfaces;

public interface Graph {
    /**
     * This interface descripes a Graph and 
     * methods to construct a graph. 
     */

    int getV(); // Get vertices count (number of nodes in graph)
    int getE(); // Get the number of edges in the graph (edges between nodes)
    Graph addEdge(int v1, int v2, float weight); // add an edge from vertice v1 to vertice v2
    Iterable<Edge> adj(int v); // Get connections (edges) from a vertice (return as Iterable containing the vertices it is connected with)

}