package org.hilos1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Ejercicio8 extends Runner {
    public static Semaphore incSem = new Semaphore(1);
    public static Semaphore decSem = new Semaphore(1);
    private static Integer numero = 0;

    public static void incrementar() {
        try {
            incSem.acquire();

            ++numero;
            System.out.println(numero);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        incSem.release();
    }

    public static void decrementar() {
        try {
            decSem.acquire();

            --numero;
            System.out.println(numero);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        decSem.release();
    }

    public static class Worker1 extends Thread {

        @Override
        public void run() {
            incrementar();

            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static class Worker2 extends Thread {

        @Override
        public void run() {
            decrementar();

            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        String cont;

        do {
            System.out.println();

            Thread t1 = new Worker1();
            Thread t2 = new Worker2();

            t1.start();
            t2.start();

            System.out.print("Continue? (S/n)");
            cont = (new Scanner(System.in)).nextLine();
        } while (cont.equalsIgnoreCase("S"));
    }
}
