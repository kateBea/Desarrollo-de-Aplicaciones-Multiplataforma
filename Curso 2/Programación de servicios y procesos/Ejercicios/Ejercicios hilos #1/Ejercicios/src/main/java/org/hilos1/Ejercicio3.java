package org.hilos1;

import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.Writer;

public class Ejercicio3 extends Runner {

    public static class Worker extends Thread {

        private final String fileName;
        private final String fileContents;

        public Worker(String name, String contents) {
            fileName = name;
            fileContents = contents;
        }

        @Override
        public void run() {
            try (Writer escritor = new FileWriter(fileName)) {
                escritor.write(fileContents);

                System.out.println("Contenido serializado con éxito");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        final String FILE_NAME = "output.txt";
        final String FILE_CONTENTS = "This is a line";

        Thread worker = new Worker(FILE_NAME, FILE_CONTENTS);

        try {
            worker.start();
            worker.join();
        } catch (InterruptedException e) {
            System.err.println("Error al ejecutar join sobre hilo principal");
        }


    }
}
