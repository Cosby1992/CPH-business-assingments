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
        
        // integer to hold value from reader, 
        // value is between 0-65535
        int b;
        
        
        // Loop until end of file
        while ((b = reader.read()) != -1) {

            // If the value is not a letter 
            // between a and z -> skip iteration
            // 97 = A
            // 122 = Z
            if(b < 97 || b > 122) continue;

            // A = 97
            // Letter - 97 -> Index in array
            // Increment index to represent frequency of that letter 
            integerArray[b-97] += 1;
        }

    }

    /**
     * This method prints the values from an array of frequencies
     * ordered with index 0 = frequency of A, index 1 = frequency of B, etc...
     * @param freq array of frequencies
     */
    public static void print_tally(int[] freq) {

        // Iterate through the frequencies
        for (int i = 0; i<freq.length; i++){

            //build a char from the index by adding 97 (ASCII 97 = 'A') 
            char letter = (char) (i+97);

            // Print the letter and the frequency fx. "a : 76011"
            System.out.println(letter+" : "+ freq[i]);
        }

    }
}
