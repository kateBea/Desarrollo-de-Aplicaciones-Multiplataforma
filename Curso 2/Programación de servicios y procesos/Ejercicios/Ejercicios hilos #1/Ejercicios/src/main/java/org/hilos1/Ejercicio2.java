package org.hilos1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 extends Runner {

    public static class Work extends Thread {
        private final int low;
        private final int up;

        public Work(int low, int up) {
            this.low = low;
            this.up = up;
        }

        @Override
        public void run() {
            for (int count = low; count <= up; ++count) {
                System.out.println("Hilo " + Thread.currentThread().threadId()  + " " + count);
            }
        }

    }

    @Override
    public void run() {
        List<Thread> hilos = new ArrayList<>();

        hilos.add(new Work(1, 50));
        hilos.add(new Work(51, 100));
        hilos.add(new Work(101, 150));
        hilos.add(new Work(151, 200));

        for (Thread hilo : hilos) {
            hilo.start();
        }
    }
}
