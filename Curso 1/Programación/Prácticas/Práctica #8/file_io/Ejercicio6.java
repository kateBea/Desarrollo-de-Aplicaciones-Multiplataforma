package file_io;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Muestra los directorios de un directorio en concreto.
 * Seguidamente le pide al usuario què directorios desea eliminar
 * 
 * Creado por Hugo Pelayo
 * 17 de abril de 2023
 */
public class Ejercicio6 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        String PATH = "./txt";
        File dir = new File(PATH);
        File[] contents;
        String nombreDir;

        if (dir.exists() && dir.isDirectory()) {
            contents = dir.listFiles();
            listDirs(contents);
            nombreDir = leerCadena("¿Qué directorio desea eliminar? ");
            eraseDir(dir, nombreDir);
            
            System.out.println("\nDirectorios actuales: \n");
            listDirs(contents);
        }
        else
            System.out.println("El directorio " + PATH + " no es un directorio o no existe");

    }

    /*
     * Elimina un "subdir" de "dir"
     */
    public static void eraseDir(File dir, String subDir) {
        int index = 0;
        boolean found = false;
        File[] contents = dir.listFiles();

        while (index < contents.length && !found)
            found = subDir.equals(contents[index++].getName());

        if (found) {
            // restar 1 porque al salir del bucle 
            // index va una unidad por delante
            contents[index - 1].delete();
            System.out.println("Se ha borrado directorio " + subDir);
        }
        else
            System.out.println("No existe el directorio");
    }

    /*
     * Lista los directorios de un directorio
     */
    public static void listDirs(File... dirs) {
        for (File item : dirs) {
            if (item.isDirectory())
                System.out.println(item.getName());
        }
    }

    /*
     * Lee una cadena de la entrada estándar de datos,
     * mostrando primero el mensaje que se pasa como parámetro
     */
    public static String leerCadena(String prompt) {
        System.out.print(prompt);
        String resultado = "";
        try {
            resultado = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}