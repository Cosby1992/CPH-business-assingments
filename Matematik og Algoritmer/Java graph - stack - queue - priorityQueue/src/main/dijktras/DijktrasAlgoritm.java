package main.dijktras;

import main.queue.PriorityQueue;
import main.weightedGraph.interfaces.Edge;
import main.weightedGraph.interfaces.Graph;

public class DijktrasAlgoritm {

    private int[] pathArray;
    private float[] bestWeights;
    private PriorityQueue<Edge> pq;

    public DijktrasAlgoritm(Graph graph, int startNode){
        pathArray = new int[graph.getV()];
        
        for (int i = 0; i < pathArray.length; i++) {
            pathArray[i] = -1;
        }

        bestWeights = new float[graph.getV()];

        for (int i = 0; i < bestWeights.length; i++) {
            bestWeights[i] = Float.MAX_VALUE;
        }

        bestWeights[startNode] = 0;

        pq = new PriorityQueue<Edge>(graph.getV());
        int curNode = startNode;
        while(curNode != -1){

            float curCost = bestWeights[curNode];
            for(Edge e : graph.adj(curNode)){



            }
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Best weights:\n");
        for (int i = 0; i < bestWeights.length; ++i) {
            builder.append(i);
            builder.append(": ");
            builder.append(bestWeights[i]);
            builder.append('\n');
        }

        for (int i = 0; i < pathArray.length; ++i) {
            builder.append(i);
            builder.append(": ");
            builder.append(pathArray[i]);
            builder.append('\n');
        }

        return builder.toString();
    }
    
}
