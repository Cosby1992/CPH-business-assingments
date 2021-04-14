package cphbusiness.ufo.letterfrequencies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

/**
 * Optimized by Cosby and Stabz
 */
public class MainSpeedTest {

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
                "C:/code/cphbusiness/Data Science/Assignment_3_optimization/letterfrequencies/src/main/java/cphbusiness/ufo/letterfrequencies/output/normal_let_frq_times.csv"));
        writer.append("NormalRunTimes\n");
        writer.flush();

        // Timer to time the two methods
        Timer timer = new Timer();

        for (long i = 0; i < 500; i++) {
            
            // Running the execution times and writing the to a csv file
            writeExecutionTimesToCsvFile(writer, fileName, timer);

        }

        // Cleanup
        writer.close();
        

    }

    private static void writeExecutionTimesToCsvFile(FileWriter writer, String fileName, Timer timer) throws IOException {

        // Creating a new reader each iteration to avoid
        // file being in memory after first iteration 
        // (FileReader has internal buffer)
        Reader reader = new FileReader(fileName);

        // OPTIMIZED: Using a normal array with length 26 representing
        // the english alphabet fx. index 0 = frequency of A, index 1 = frequency of B,
        // etc...
        // instead of a HashMap<Integer, Long>
        Map<Integer, Long> freq = new HashMap<>();

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

    private static void tallyChars(Reader reader, Map<Integer, Long> freq) throws IOException {
        int b;
        while ((b = reader.read()) != -1) {
            try {
                freq.put(b, freq.get(b) + 1);
            } catch (NullPointerException np) {
                freq.put(b, 1L);
            };
        }
    }

    private static void print_tally(Map<Integer, Long> freq) {
        int dist = 'a' - 'A';
        Map<Character, Long> upperAndlower = new LinkedHashMap();
        for (Character c = 'A'; c <= 'Z'; c++) {
            upperAndlower.put(c, freq.getOrDefault(c, 0L) + freq.getOrDefault(c + dist, 0L));
        }
        Map<Character, Long> sorted = upperAndlower
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        for (Character c : sorted.keySet()) {
            System.out.println("" + c + ": " + sorted.get(c));;
        }
    }

}
