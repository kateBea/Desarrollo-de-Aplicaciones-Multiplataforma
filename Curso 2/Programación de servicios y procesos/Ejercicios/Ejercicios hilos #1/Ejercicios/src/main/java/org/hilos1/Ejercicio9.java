package org.hilos1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Ejercicio9 extends Runner {
    public static class Cajas {
        Semaphore control;

        public Cajas(Semaphore control) {
            this.control = control;
        }

        public void usar(String cliente) {
            try {
                control.acquire();
                System.err.println(cliente + " usando caja");
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

            control.release();
        }
    }

    private static class Cliente extends Thread {

        private final String id;
        private final Cajas cajas;

        public Cliente(final String id, Cajas cajas) {
            this.id = id;
            this.cajas = cajas;
        }

        @Override
        public void run() {
            System.out.println("Soy " + id);

            cajas.usar(id);
        }
    }

    @Override
    public void run() {
        int MAX_CAJAS = 10;
        int MAX_CAJA_PERMITS = 10;
        int MAX_CLIENTES = 100;

        List<Cliente> clientes = new ArrayList<>();
        Cajas cajas = new Cajas(new Semaphore(MAX_CAJA_PERMITS));

        for (int index = 0; index < MAX_CLIENTES; ++index) {
            clientes.add(new Cliente("Cliente " + index, cajas));
        }

        clientes.forEach(Cliente::start);

        try {
            for (Cliente cliente : clientes) {
                cliente.join();
            }

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
