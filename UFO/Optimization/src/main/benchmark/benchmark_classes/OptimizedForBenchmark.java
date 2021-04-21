package src.main.benchmark.benchmark_classes;

import java.io.IOException;
import java.io.Reader;

public class OptimizedForBenchmark {
    
    /**
     * This method reads each character from a file (buffered reader), 
     * and adds their frequencies to their respective index in the array
     * @param reader Reader created with a file path
     * @param integerArray Array to hold the frequencies of the letters (index 0 = frequency of A, index 1 = frequency of B, etc...)
     * @throws IOException Error reading the file
     */
    public static void tallyChars(Reader reader, int[] integerArray) throws IOException {
        
        int b;
        
        // Loop until end of file
        while ((b = reader.read()) != -1) {

            // Increment index to represent frequency of that letter 
            integerArray[b] += 1;
        }

    }

    /**
     * This method prints the values from an array of frequencies
     * ordered with index 0 = frequency of A, index 1 = frequency of B, etc...
     * @param freq array of frequencies
     */
    public static void print_tally(int[] freq) {
        int[][] map = new int[26][2];

        for (int i = 0; i < 26; i++){
            int index = i+65; // A = 65 (ASCII) 
            insertSorted(index, freq[i+97]+freq[index], map, i);
        }

        printMap(map);
    }

    private static void printMap(int[][] map) {
        
        for (int i = 0; i < map.length; i++) {
            System.out.println((char) (map[i][1]) + ":" + map[i][0]);
        }
    }

    private static void insertSorted(int index, int value, int[][] map, int iteration){

        for (int i = 0; i < map.length-(map.length - iteration-1); i++) {
            if(map[i][0] <= value) {

                for (int j = map.length-1; j > i; j--) {
                    map[j][0] = map[j-1][0];
                    map[j][1] = map[j-1][1];
                }

                map[i][0] = value;
                map[i][1] = index;

                return;
            }
        }

        map[0][0] = value;
        map[0][1] = index;

    }
}
