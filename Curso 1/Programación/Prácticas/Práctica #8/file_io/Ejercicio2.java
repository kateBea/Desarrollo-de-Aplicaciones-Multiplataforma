package file_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Este programa crea un fichero con nombre "ejercicio02.txt"
 * en el directorio "txt" ubicado en el directorio actual, 
 * se crea el directorio si no existe
 * 
 * Creado por Hugo Pelayo
 * 17 de abril de 2023
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        String PATH = "txt";
        String FILE_NAME = "ejercicio01.txt";
        File dir = new File(PATH);
        File fichero = new File(dir, FILE_NAME);

        if (fichero.exists())
            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        else {
            System.out.println("No existe el fichero o directorio...");    
            try {
                if(!dir.exists() && dir.mkdirs()) {
                    // creamos el fichero una vez hemos creado el directorio
                    System.out.println("Directorio creado");
                    writeToFile(fichero, LocalDateTime.now().toString());
                }

                fichero.createNewFile();
                System.out.println("Fichero creado");
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