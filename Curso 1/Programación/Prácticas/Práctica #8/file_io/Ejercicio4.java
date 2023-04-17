package file_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/**
 * Este programa crea un fichero con nombre "ejercicio02.txt"
 * en el directorio "txt" ubicado en el directorio actual, 
 * no se crea el directorio si no existe. El usuario se encarga de indicar
 * la la ruta y nombre del fichero
 * 
 * Creado por Hugo Pelayo
 * 17 de abril de 2023
 */
public class Ejercicio4 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        String path = leerCadena("Introduzca el directorio (s) donde crear el fichero: ");
        String fileName = leerCadena("Introduzca el nombre del fichero: ");


        File dir = new File(path);
        File fichero = new File(dir, fileName);

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
        
    /**
     * Muestra por pantalla el directorio de trabajo actual
     * */
    public static String printCurrentWorkingDirectory() {
        return System.getProperty("user.dir");
    }
}