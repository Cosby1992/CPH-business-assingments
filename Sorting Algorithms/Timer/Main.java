/**
 * Timer test class, to test the timer
 */


public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        Timer timer = new Timer(); // create new timer

        timer.start(); // start timer
        Thread.sleep(1000); // wait one second
        timer.step(); // take step time
        Thread.sleep(500); // wait half a second
        timer.stop(); // stop the timer

        /**
         * OUTPUT:
         * 1003.8952ms
         * 1507.7014ms
         */

    }
    
}
