package src.main.graph.interfaces;

public interface Edge {
    /**
     * This interface descripes an Edge (without direction) 
     * between two vertices in a graph
     */

    int either(); // return a vertice 
    int other(int vertice); // return the other vertice
    float weight(); // returns the weight of the edge
    
}
