package main.weightedGraph;

import java.util.ArrayList;

import main.weightedGraph.interfaces.Edge;
import main.weightedGraph.interfaces.Graph;

/**
 * This is an implementaion of a graph with non-directional edges
 */
public class GraphImpl implements Graph {

    private ArrayList<Edge>[] graph;
    private ArrayList<Edge> edges = new ArrayList<>();
    private final ArrayList<Edge> EMPTY_LIST = new ArrayList<>(0); 

    // Constructor
    public GraphImpl(int verticesCount){
        graph = new ArrayList[verticesCount];
    }

    // Returns the number of vertices in the graph
    @Override
    public int getV() {
        return graph.length;
    }

    // Returns the number of total edges in the graph
    @Override
    public int getE() {
        return edges.size();
    }

    // Adds an edge to the graph given the two 
    // vertices it connects and the weight of the edge
    @Override
    public Graph addEdge(int v1, int v2, float weight) {
        
        // Initializing edges list if there's no 
        // edges to the vertice yet
        if(graph[v1] == null) {
            graph[v1] = new ArrayList<>();
        }
        if(graph[v2] == null) {
            graph[v2] = new ArrayList<>();
        }

        // Adding the edge to both vertices connected by the edge
        addEdgeToList(v1, v2, weight);
        addEdgeToList(v2, v1, weight);

        // Adds the new edge to the list of all edges
        edges.add(new EdgeImpl(v1, v2, weight));

        // returns this object for method chaining
        return this;

    }

    // This local method adds an edge between two vertices
    private void addEdgeToList(int v1, int v2, float weight){
        Edge e = new EdgeImpl(v1, v2, weight);
        graph[v1].add(e);
    }

    // Returns all the edges from a vertice or an empty
    // list if the vertices has no edges
    @Override
    public Iterable<Edge> adj(int v) {
        if(graph[v] != null) return graph[v];
        return EMPTY_LIST;
    }

    // Overrides the objects to string method for 
    // printing the object to the console
    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        builder.append(getV());
        builder.append("\n");
        builder.append(getE());
        builder.append("\n");

        for(Edge e : edges){
            builder.append(e.from());
            builder.append(" ");
            builder.append(e.to());
            builder.append(" ");
            builder.append(e.weight());
            builder.append("\n");
        }

        return builder.toString();
    }

}