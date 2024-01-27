package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    private static Semaphore vacio;
    private static Semaphore binario;
    private static Semaphore lleno;
    private static final int SIZE = 20;

    private static int cabeza;
    private static int cola;

    private static int[] buffer;
    private static int dato;

    public static class Productor extends Thread {
        private int counter = 1;
        @Override
        public void run() {
            // Producimos un dato
            dato = counter++;

            try {
                vacio.acquire();
                binario.acquire();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

            buffer[cabeza] = dato;
            cabeza = (cabeza + 1) % SIZE;
            binario.release();
            lleno.release();
        }
    }

    public static class Consumidor extends Thread {
        @Override
        public void run() {
            try {
                lleno.acquire();
                binario.acquire();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

            dato = buffer[cola];
            cola = (cola + 1) % SIZE;
            binario.release();
            vacio.release();

            // Se consume el dato
            System.out.println(dato);
        }
    }

    public static void main(String[] args) {
        Productor productor = new Productor();
        Consumidor consumidor = new Consumidor();

    }
}