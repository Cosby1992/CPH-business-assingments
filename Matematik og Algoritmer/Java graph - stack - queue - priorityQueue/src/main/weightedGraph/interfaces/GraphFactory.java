package main.weightedGraph.interfaces;

import java.io.BufferedReader;
import java.io.FileReader;

import main.weightedGraph.GraphImpl;

public interface GraphFactory {
    /**
     * This interface provides methods 
     * to build a Graph from a file
     */

    /**
     * This method generates a graph 
     * from a file descriping the graph. 
     * @param fileName path to the file that descripes the graph
     * @return The graph build from the file
     */ 
    static Graph createGraphFromFile(String fileName) {
        
        Graph graph = null; 
        
        // Initialize a new reader
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            int numOfVertices = 0;
            int numOfEdges = 0;
            
            // read the first line of the file
            String line = reader.readLine();
            
            // while end-of-file is not reached
            while(line != null){

                // Split the line
                String[] lineSplitted = line.split(" ");

                // The first line descripes the number of vertices
                if(numOfVertices == 0){ 
                    numOfVertices = Integer.valueOf(lineSplitted[0]);
                    graph = (Graph) new GraphImpl(numOfVertices);
                
                // The second line descripes the number of edges 
                } else if(numOfEdges == 0) {
                    numOfEdges = Integer.valueOf(lineSplitted[0]);
                
                // The rest of the lines descripes edges between vertices
                } else {
                    graph.addEdge(Integer.valueOf(lineSplitted[0]), Integer.valueOf(lineSplitted[1]), Float.valueOf(lineSplitted[2])); 
                }

                // read the next line
                line = reader.readLine();
            }

            // close the reader after use
            reader.close();
            
        } catch(Exception e) {
            // if there's a problem reading the file
            // or an error occures while building the graph
            // print the message and reset the graph
            graph = null;
            System.out.println(e.getMessage());
        } 
        
        // return the graph
        // value of graph is null or the complete graph descriped in the file
        return graph;
    }
    
}
