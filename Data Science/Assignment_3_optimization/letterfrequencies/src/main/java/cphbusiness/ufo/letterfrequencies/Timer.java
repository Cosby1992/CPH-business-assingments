package cphbusiness.ufo.letterfrequencies;

public class Timer {

    private long start;

    public void start(){
        start = System.nanoTime();
    }

    public long nanoNow(){

        return System.nanoTime() - start;
    }

    public long milliNow(){

        return ((System.nanoTime() - start)/1_000_000);
    }

}
