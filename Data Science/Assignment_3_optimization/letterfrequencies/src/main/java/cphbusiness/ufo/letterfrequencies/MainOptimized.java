package cphbusiness.ufo.letterfrequencies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Frequency analysis Inspired by
 * https://en.wikipedia.org/wiki/Frequency_analysis
 *
 * @author kasper
 * Optimized by Cosby and Stabz
 * 
 */
public class MainOptimized {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // path to text-file to count letter frequencies
        String cosbyPath = "letterfrequencies/src/main/resources/FoundationSeries.txt";
        String dimaPath = "...//";

        String fileName = cosbyPath;
        //String fileName = dimaPath;

        // Creating input stream for the file
        Reader fileReader = new FileReader(fileName);

        // OPTIMIZED: Using a buffered reader instead of the raw FileReader
        Reader reader = new BufferedReader(fileReader);
        
        // OPTIMIZED: Using a normal array with length 26 representing 
        // the english alphabet fx. index 0 = frequency of A, index 1 = frequency of B, etc...
        // instead of a HashMap<Integer, Long>
        int[] freq =
                {0,0,0,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,0};

        // Starting timer to time the two methods
        Timer timer = new Timer();
        timer.start();

        // Count word frequencies using the 
        // buffered reader and the freq array
        tallyChars(reader, freq);

        // Get time for first method and print it to console
        long step = timer.milliNow(); 
        // OBS: print should be removed when taking time on entire program
        System.out.println("Tally chars execution time: " + step + "ms");
        
        // Print the letters and frequencies to the console
        print_tally(freq);

        // Get time for second method and print it to console
        long stop = timer.milliNow();
        System.out.println("Tally chars execution time: " + stop + "ms");
    }

    /**
     * This method reads each character from a file (buffered reader), 
     * and adds their frequencies to their respective index in the array
     * @param reader Reader created with a file path
     * @param integerArray Array to hold the frequencies of the letters (index 0 = frequency of A, index 1 = frequency of B, etc...)
     * @throws IOException Error reading the file
     */
    private static void tallyChars(Reader reader, int[] integerArray) throws IOException {
        
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
    private static void print_tally(int[] freq) {

        // Iterate through the frequencies
        for (int i = 0; i<freq.length; i++){

            //build a char from the index by adding 97 (ASCII 97 = 'A') 
            char letter = (char) (i+97);

            // Print the letter and the frequency fx. "a : 76011"
            System.out.println(letter+" : "+ freq[i]);
        }

    }

}

