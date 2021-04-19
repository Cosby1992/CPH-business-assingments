package src.main.benchmark;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import src.main.benchmark.benchmark_classes.OriginalForBenchmark;

public class Benchmark {

    public static void main(String[] args) throws IOException {
        
        SingleRunOriginal();

    }
    
    
    public static void multipleRunsOriginal(int iterations) {




    }

    public static void SingleRunOriginal() throws IOException {

        double initializeTime, tallyCharsTime, printTallyTime = 0.0;

        // Get the starting time
        Timer timer = new Timer();
        timer.start();

        // Create the reader and hashmap 
        // required to run the methods
        Reader reader = new FileReader("src/main/resources/FoundationSeries.txt");
        Map<Integer, Long> letterFrequencyMap = new HashMap<>();

        initializeTime = timer.milli();

        OriginalForBenchmark.tallyChars(reader, letterFrequencyMap);

        tallyCharsTime = timer.milli();
        
        OriginalForBenchmark.print_tally(letterFrequencyMap);

        printTallyTime = timer.milli();

        System.out.println("Init  time: " + initializeTime + "ms");
        System.out.println("Tally time: " + tallyCharsTime + "ms");
        System.out.println("Print time: " + printTallyTime + "ms");

    }



}
