package main.graph;

/**
 * Graph
 */
public interface Graph {

    int getV(); // Get vertices count (number of nodes in graph)
    int getE(); // Get the number of edges in the graph (edges between nodes)
    void addEdge(int v1, int v2); // add an edge from vertice v1 to vertice v2
    Iterable<Integer> adj(int v); // Get connections (edges) from a vertice (return as Iterable containing the vertices it is connected with)

}