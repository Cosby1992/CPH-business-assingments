package src.main.benchmark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import src.main.benchmark.benchmark_classes.BenchmarkTimer;
import src.main.benchmark.benchmark_classes.OptimizedForBenchmark;
import src.main.benchmark.benchmark_classes.OriginalForBenchmark;

public class Benchmark {

    public static void main(String[] args) throws IOException {

        BenchmarkTimer timer = new BenchmarkTimer(3);

        // SingleRunOriginal(5, timer);
        // timer.writeRealTimesToCSV("time_data/single_run_real_times.csv");
        // printTallyTimes(timer);
        // timer = new BenchmarkTimer(3);

        multipleRunsOptimized(500, 30, timer);

        timer.writeRealTimesToCSV("time_data/multiple_run_real_times_new.csv");

        printTallyTimes(timer);

    }

    private static void printTallyTimes(BenchmarkTimer timer) {
        System.out.println("Warmup");
        System.out.println("Init  time: " + timer.getAverageWarmupTime(0) + "ms");
        System.out.println("Tally time: " + timer.getAverageWarmupTime(1) + "ms");
        System.out.println("Print time: " + timer.getAverageWarmupTime(2) + "ms");

        System.out.println();
        System.out.println("Realtimes");
        System.out.println("Init  time: " + timer.getAverageRealTime(0) + "ms");
        System.out.println("Tally time: " + timer.getAverageRealTime(1) + "ms");
        System.out.println("Print time: " + timer.getAverageRealTime(2) + "ms");
    }

    public static void multipleRunsOriginal(int iterations, int warmUpIterations, BenchmarkTimer timer) throws IOException {

        double[] temp = new double[3];

        // Warm-up
        for (int i = 0; i < warmUpIterations; i++) {
            temp = original();

            for (int j = 0; j < 3; j++) {
                timer.addWarmupTime(j, temp[j]);
            }
        }

        // Real test
        for (int i = 0; i < iterations; i++) {
            temp = original();

            for (int j = 0; j < 3; j++) {
                timer.addRealTime(j, temp[j]);
            }
        }

    }
    
    public static void SingleRunOriginal(int warmUpIterations, BenchmarkTimer timer) throws IOException {
        
        double[] temp = new double[3];

        // Warmup iterations
        for (int i = 0; i < warmUpIterations; i++) {
            temp = original();

            for (int j = 0; j < 3; j++) {
                timer.addWarmupTime(j, temp[j]);
            }
        }

        // Real timing
        temp = original();

        for (int i = 0; i < 3; i++) {
            timer.addRealTime(i, temp[i]);
        }

    }

    public static double[] original() throws IOException {
        double initializeTime, tallyCharsTime, printTallyTime = 0.0;

        // Get the starting time
        Timer timer = new Timer();
        timer.start();

        // Create the reader and hashmap
        // required to run the methods
        Reader reader = new FileReader("src/main/resources/FoundationSeries.txt");
        Map<Integer, Long> letterFrequencyMap = new HashMap<>();

        initializeTime = timer.milli();
        timer.start();

        OriginalForBenchmark.tallyChars(reader, letterFrequencyMap);

        tallyCharsTime = timer.milli();
        timer.start();

        OriginalForBenchmark.print_tally(letterFrequencyMap);

        printTallyTime = timer.milli();

        double[] times = { initializeTime, tallyCharsTime, printTallyTime };

        return times;
    }

    public static void multipleRunsOptimized(int iterations, int warmUpIterations, BenchmarkTimer timer)
            throws IOException {

        double[] temp = new double[3];

        // Warm-up
        for (int i = 0; i < warmUpIterations; i++) {
            temp = optimized();

            for (int j = 0; j < 3; j++) {
                timer.addWarmupTime(j, temp[j]);
            }
        }

        // Real test
        for (int i = 0; i < iterations; i++) {
            temp = optimized();

            for (int j = 0; j < 3; j++) {
                timer.addRealTime(j, temp[j]);
            }
        }

    }

    public static void SingleRunOptimized(int warmUpIterations, BenchmarkTimer timer) throws IOException {

        double[] temp = new double[3];

        // Warmup iterations
        for (int i = 0; i < warmUpIterations; i++) {
            temp = optimized();

            for (int j = 0; j < 3; j++) {
                timer.addWarmupTime(j, temp[j]);
            }
        }

        // Real timing
        temp = optimized();

        for (int i = 0; i < 3; i++) {
            timer.addRealTime(i, temp[i]);
        }

    }

    public static double[] optimized() throws IOException {
        double initializeTime, tallyCharsTime, printTallyTime = 0.0;

        // Get the starting time
        Timer timer = new Timer();
        timer.start();

        String path = "src/main/resources/FoundationSeries.txt";

        // OPTIMIZED: Using a buffered reader instead of the raw FileReader
        Reader reader = new BufferedReader(new FileReader(path));

        int[] freq = new int[65535];

        initializeTime = timer.milli();
        timer.start();

        OptimizedForBenchmark.tallyChars(reader, freq);

        tallyCharsTime = timer.milli();
        timer.start();

        OptimizedForBenchmark.print_tally(freq);

        printTallyTime = timer.milli();

        double[] times = { initializeTime, tallyCharsTime, printTallyTime };

        return times;
    }

}
