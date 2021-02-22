
/**
 * Timer class
 * This class can take time (and step times) for execution
 */

public class Timer {

    private long start;

    // Starts the timer by "saving" a timestamp
    public void start() {
        start = System.nanoTime();
    }

    // prints (and returns) the time since start
    public double step() {
        double step = (System.nanoTime() - start) / 1000000.0;
        System.out.println(step + "ms");
        return step;
    }

    // prints the time since start
    public void stop() {
        double stop = (System.nanoTime() - start) / 1000000.0;
        System.out.println(stop + "ms");
    }

}