package src.main.benchmark;

public class Timer {

    private long start;

    public void start(){
        start = System.nanoTime();
    }

    public double nano(){
        return (double) System.nanoTime() - start;
    }

    public double micro(){
        return ((System.nanoTime() - start)/1_000.0);
    }

    public double milli(){
        return ((System.nanoTime() - start)/1_000_000.0);
    }

}
