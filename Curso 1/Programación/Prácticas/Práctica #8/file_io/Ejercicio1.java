package file_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Este programa crea un fichero con nombre "ejercicio01.txt"
 * en el directorio de trabajo actual
 * 
 * Creado por Hugo Pelayo
 * 17 de abril de 2023
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        String PATH = "ejercicio01.txt";
        File fichero = new File(PATH);

        if (fichero.exists())
            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        else {
            System.out.println("No existe el fichero...");
            System.out.print("Creando fichero con nombre " + PATH);
            System.out.print(" en el directorio " + printCurrentWorkingDirectory() + '\n');
            
            try {
                fichero.createNewFile();
                writeToFile(fichero, LocalDateTime.now().toString());
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /*
     * Escribe el contenido de "contents" al fichero indicado
     */
    public static void writeToFile(File fichero, Object... contents) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero,true));
            for (Object item : contents) {
                try {
                    escritor.write(item.toString());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            escritor.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra por pantalla el directorio de trabajo actual
     * */
    public static String printCurrentWorkingDirectory() {
        return System.getProperty("user.dir");
    }
}