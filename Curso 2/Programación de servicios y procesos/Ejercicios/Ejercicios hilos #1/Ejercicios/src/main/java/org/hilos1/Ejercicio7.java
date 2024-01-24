package org.hilos1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio7 extends Runner {
    private static Integer numero = 0;

    public static synchronized void incrementar() {
        ++numero;

        System.out.println(numero);
    }

    public static synchronized void decrementar() {
        --numero;

        System.out.println(numero);
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
