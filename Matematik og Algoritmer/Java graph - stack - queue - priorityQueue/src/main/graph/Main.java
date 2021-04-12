package main.graph;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        GraphImpl graph = new GraphImpl(10);

        // OBS two statements per line when adding edges to the graph
        graph.addEdge(0, 1); graph.addEdge(0, 2);
        graph.addEdge(1, 2); graph.addEdge(1, 3);
        graph.addEdge(2, 3); graph.addEdge(2, 4);
        graph.addEdge(3, 4); graph.addEdge(3, 5);
        graph.addEdge(4, 5); graph.addEdge(4, 6);
        graph.addEdge(5, 6); graph.addEdge(5, 7);
        graph.addEdge(6, 7); graph.addEdge(6, 8);
        graph.addEdge(7, 8); graph.addEdge(7, 9);
        graph.addEdge(8, 9); graph.addEdge(8, 1);

        Iterable<Integer> a = graph.adj(5);

        ArrayList<Integer> aArray = (ArrayList<Integer>) a;

        System.out.println(aArray);
        System.out.println(graph.getV());

    }

}
