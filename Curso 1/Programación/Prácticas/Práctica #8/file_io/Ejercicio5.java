package file_io;

import java.io.File;

/**
 * Muestra los directorios de un directorio en concreto
 * 
 * Creado por Hugo Pelayo
 * 17 de abril de 2023
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        String PATH = "./txt";
        File dir = new File(PATH);
        File[] contents;

        if (dir.exists() && dir.isDirectory()) {
            contents = dir.listFiles();

            for (File item : contents) {
                if (item.isDirectory())
                    System.out.println(item.getName());
            }
        }
        else
            System.out.println("El directorio " + PATH + " no es un directorio o no existe");

    }
}