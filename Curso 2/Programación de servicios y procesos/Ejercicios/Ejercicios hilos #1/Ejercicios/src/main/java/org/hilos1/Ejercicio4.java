package org.hilos1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ejercicio4 extends Runner {
    public static class Lectora extends Thread {
        private String contenido;
        private final String nombreFich;

        public Lectora(String nombreFichero) {
            nombreFich = nombreFichero;
        }

        @Override
        public void run() {
            try {
                contenido = Files.readString(Paths.get(nombreFich));
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        public String getContenidos() {
            return contenido;
        }

    }

    @Override
    public void run() {
        Lectora lectora = new Lectora("output.txt");

        lectora.start();

        try {
            lectora.join();

            System.out.println(lectora.getContenidos());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
