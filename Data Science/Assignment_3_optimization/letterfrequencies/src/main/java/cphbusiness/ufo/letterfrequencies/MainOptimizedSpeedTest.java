package cphbusiness.ufo.letterfrequencies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * Optimized by Cosby and Stabz
 */
public class MainOptimizedSpeedTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // path to text-file to count letter frequencies
        String cosbyPath = "C:/code/cphbusiness/Data Science/Assignment_3_optimization/letterfrequencies/src/main/resources/FoundationSeries.txt";
        String dimaPath = "...//";

        // choosing path
        String fileName = cosbyPath;
        // String fileName = dimaPath;

        //System.out.println(System.getProperty("user.home") + "\\Desktop\\optimization output");

        // Writer to generate csv file
        // FileWriter writer = new FileWriter(new
        // File("letterfrequencies/src/main/java/cphbusiness/ufo/letterfrequencies/output/optimized_let_frq_times.csv"));
        FileWriter writer = new FileWriter(new File(
                "C:/code/cphbusiness/Data Science/Assignment_3_optimization/letterfrequencies/src/main/java/cphbusiness/ufo/letterfrequencies/output/optimized_let_frq_times.csv"));
        writer.append("OptimaizedRunTimes\n");
        writer.flush();

        // Starting timer to time the two methods
        Timer timer = new Timer();

        for (long i = 0; i < 500; i++) {
            // Running the execution times and writing the to a csv file
            writeExecutionTimesToCsvFile(writer, fileName, timer);
        }

        // Cleanup
        writer.close();  
    }

    private static void writeExecutionTimesToCsvFile(FileWriter writer, String fileName, Timer timer) throws IOException {

        // OPTIMIZED: Using a normal array with length 26 representing
        // the english alphabet fx. index 0 = frequency of A, index 1 = frequency of B,
        // etc...
        // instead of a HashMap<Integer, Long>
        int[] freq = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        // Creating a new reader each iteration to avoid
        // file being in memory after first iteration
        Reader reader = new BufferedReader(new FileReader(fileName));

        timer.start();

        // Count word frequencies using the
        // buffered reader and the freq array
        tallyChars(reader, freq);

        // Print the letters and frequencies to the console
        print_tally(freq);

        // Get time for second method and print it to console
        long stop = timer.milliNow();
        System.out.println("Tally chars execution time: " + stop + "ms");

        // Cleanup
        reader.close();

        writer.append(stop + "\n");
        writer.flush();

    }

    /**
     * This method reads each character from a file (buffered reader), and adds
     * their frequencies to their respective index in the array
     * 
     * @param reader       Reader created with a file path
     * @param integerArray Array to hold the frequencies of the letters (index 0 =
     *                     frequency of A, index 1 = frequency of B, etc...)
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
            if (b < 97 || b > 122)
                continue;

            // A = 97
            // Letter - 97 -> Index in array
            // Increment index to represent frequency of that letter
            integerArray[b - 97] += 1;
        }

    }

    /**
     * This method prints the values from an array of frequencies ordered with index
     * 0 = frequency of A, index 1 = frequency of B, etc...
     * 
     * @param freq array of frequencies
     */
    private static void print_tally(int[] freq) {

        // Iterate through the frequencies
        for (int i = 0; i < freq.length; i++) {

            // build a char from the index by adding 97 (ASCII 97 = 'A')
            char letter = (char) (i + 97);

            // Print the letter and the frequency fx. "a : 76011"
            System.out.println(letter + " : " + freq[i]);
        }

    }

}
