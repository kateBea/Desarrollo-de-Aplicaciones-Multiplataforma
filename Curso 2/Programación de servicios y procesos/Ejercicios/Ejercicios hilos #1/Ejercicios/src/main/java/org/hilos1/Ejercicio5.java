package org.hilos1;

import javax.swing.text.html.Option;
import java.io.*;
import java.util.Optional;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Ejercicio5 extends Runner {

    public static class Lector extends Thread {

        private final Semaphore m_Aforo = new Semaphore(1);

        private final Optional<File> m_Fichero;
        private String m_Contenido = null;

        public Lector(final String rutaFichero) {
            m_Fichero = Optional.of(new File(rutaFichero));

            try {
                // Nadie podrá leer el contenido hasta que
                // yo haya acabado de leer el contenido
                m_Aforo.acquire();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        @Override
        public void run() {
            if (m_Fichero.isEmpty()) {
                System.err.println("No se pudo cargar el fichero");
                return;
            }

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(m_Fichero.get()));
                m_Contenido = bufferedReader.lines().reduce((l1, l2) -> l1 + "\n" + l2).orElse("");

                m_Aforo.release();
                bufferedReader.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        public String getContents() {
            try {
                m_Aforo.acquire();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

            m_Aforo.release();

            return m_Contenido;
        }
    }

    @Override
    public void run() {
        // relativo a proyecto
        final String FILE_PATH = "plantilla.ejs";
        File fichero = new File(FILE_PATH);

        if (!fichero.exists()) {
            System.err.println("El fichero no existe");
            return;
        }

        Lector lector = new Lector(FILE_PATH);
        lector.start();

        int suma = IntStream.range(1, 101).sum();

        StringBuilder stringBuffer = new StringBuilder(lector.getContents());

        while (stringBuffer.toString().contains("{suma}")) {
            stringBuffer.replace(stringBuffer.indexOf("{suma}"), stringBuffer.indexOf("{suma}") + "{suma}".length(), String.format("%d", suma));
        }

        try (Writer writer = new FileWriter("output.txt")) {
            writer.write(stringBuffer.toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
