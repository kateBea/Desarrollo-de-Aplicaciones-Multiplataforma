package org.hilos1;

public class Ejercicio6 extends Runner {
    @Override
    public void run() {
        // Time in seconds
        final int SLEEP_TIME = 5;

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            System.err.println("Error while sleeping this thread");
        }

        System.out.printf("This slept for %d seconds", SLEEP_TIME);
    }
}
