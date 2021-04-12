package main.graph;

import java.util.ArrayList;

public class GraphImpl implements Graph {

    private ArrayList<Integer>[] graph;
    private int edgeCount = 0;

    public GraphImpl(int verticeCount) {
        graph = new ArrayList[verticeCount];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    @Override
    public int getV() {
        return graph.length;
    }

    @Override
    public int getE() {
        return edgeCount;
    }

    @Override
    public void addEdge(int v1, int v2) {

        if (graph[v1].size() == 0) {
            graph[v1].add(v2);
            edgeCount++; // incrementing edge count
        } else {

            // Go through the Vertices, if the edge already exists
            // then break the loop.
            for (int i = 0; i < graph[v1].size(); i++) {
                if (graph[v1].get(i) == v2) {
                    break;
                }

                // if we reach the last index of the array, and havn't found the edge
                // then add the edge to the graph
                if (i == graph[v1].size() - 1) {
                    graph[v1].add(v2);
                    edgeCount++; // incrementing edge count
                }
            }

        }

    }

    @Override
    public Iterable<Integer> adj(int v) {
        return graph[v];
    }

}
