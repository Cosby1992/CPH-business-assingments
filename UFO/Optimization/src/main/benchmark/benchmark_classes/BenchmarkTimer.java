package src.main.benchmark.benchmark_classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BenchmarkTimer {

    private ArrayList<Double>[] realTimes;
    private ArrayList<Double>[] warmupTimes;
    private int size;

    public BenchmarkTimer(int size) {
        realTimes = new ArrayList[size];
        warmupTimes = new ArrayList[size];
        this.size = size;
    }

    public void addRealTime(int index, double time) {
        if (realTimes[index] == null)
            realTimes[index] = new ArrayList<>();
        realTimes[index].add(time);
    }

    public void addWarmupTime(int index, double time) {
        if (warmupTimes[index] == null)
            warmupTimes[index] = new ArrayList<>();
        warmupTimes[index].add(time);
    }

    public ArrayList<Double>[] getRealTimes() {
        return realTimes;
    }

    public ArrayList<Double>[] getWarmupTimes() {
        return warmupTimes;
    }

    public double getAverageRealTime(int index) {

        double sum = 0.0;
        for (double d : realTimes[index]) {
            sum += d;
        }

        double average = sum / (double) realTimes[index].size();

        return average;
    }

    public double getAverageWarmupTime(int index) {

        double sum = 0.0;
        for (double d : warmupTimes[index]) {
            sum += d;
        }

        double average = sum / (double) warmupTimes[index].size();

        return average;
    }

    public void writeRealTimesToCSV(String filepath) {
        // write times to csv file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {

            StringBuilder builder = new StringBuilder();

            // init,tally,print
            // 2.5, 3.8, 4.6
            // 7.8, 8.6, 3.5

            builder.append("init,tally,print");

            for (int i = 0; i < realTimes[0].size(); i++) {
                builder.append("\n");

                for (int j = 0; j < realTimes.length; j++) {
                    builder.append(realTimes[j].get(i));
                    if(j != realTimes.length-1) builder.append(",");
                }

            }

            writer.write(builder.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("Something went wrong trying to write the csv file.");
            e.printStackTrace();
        }
    }

}
