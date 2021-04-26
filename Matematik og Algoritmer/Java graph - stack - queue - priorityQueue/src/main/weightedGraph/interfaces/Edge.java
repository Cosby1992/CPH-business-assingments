package main.weightedGraph.interfaces;

public interface Edge extends Comparable<Edge> {
    /**
     * This interface descripes an Edge (without direction) 
     * between two vertices in a graph
     */

    int from(); // return a vertice 
    int to(); // return the other vertice
    float weight(); // returns the weight of the edge
    
}
