package org.example;

import java.util.concurrent.Semaphore;

// Hilo 1 espera hilo 2, hilo 2 espera hilo 3.
public class Main {
    public static void main(String[] args) {
        Semaphore mainSem = new Semaphore(0);
        Semaphore secondarySem = new Semaphore(0);

        Hilo1 hilo1 = new Hilo1(secondarySem);
        Hilo2 hilo2 = new Hilo2(mainSem, secondarySem);
        Hilo3 hilo3 = new Hilo3(mainSem);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Saliendo del main...");
    }
}