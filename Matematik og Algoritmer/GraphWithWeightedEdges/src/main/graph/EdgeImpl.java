package src.main.graph;

import src.main.graph.interfaces.Edge;

/**
 * This class is an implementaion of a (non-directional) 
 * edge for a graph.
 */
public class EdgeImpl implements Edge, Comparable<Edge> {
    // The two vertices the edge connects and the weight of the edge
    private int a;
    private int b;
    private float weight;

    // Constructor
    public EdgeImpl(int a, int b, float weight){
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    // returns one of the vertices
    @Override
    public int either() {
        return a;
    }

    // returns the other vertice, given a vertice
    @Override
    public int other(int vertice) {
        if(vertice == a) return b;
        if(vertice == b) return a;
        throw new RuntimeException("No such vertice in the graph");
    }

    // returns the weight of the edge
    @Override
    public float weight() {
        return weight;
    }

    // Makes two edges comparable by overwriting the compareTo method 
    // from the comparable interface
    // It compares the edges using their weight
    @Override
    public int compareTo(Edge other) {
        float e = this.weight - other.weight();
        if(e < 0) return -1;
        if(e > 0) return 1;
        return 0;
    }


}
