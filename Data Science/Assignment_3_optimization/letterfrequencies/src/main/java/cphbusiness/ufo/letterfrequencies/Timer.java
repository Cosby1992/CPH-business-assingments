package cphbusiness.ufo.letterfrequencies;

public class Timer {

    private long start; 

    // constructor
    public Timer() {

    }

    // start the timer
    public void start() {
        start = System.nanoTime();
    }

    public long step() {
        return System.nanoTime() - start;
    }

    public long stop() {
        return System.nanoTime() - start;
    }

}
