package writing_files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio1 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        final String FILE_NAME = "file01.txt";
        ArrayList<String> contents = new ArrayList<>();
        String userInput;

        File outputFile = new File(FILE_NAME);

        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Por favor introduzca una o varias cadenas:\n");
        while ((userInput = leerCadena(null)) != null)
            contents.add(userInput);

        writeToFile(outputFile, contents.toArray());

    }

    /*
     * Escribe el contenido de "contents" al fichero indicado
     * Se asume que el fichero ya existe
     */
    public static void writeToFile(File fichero, Object... contents) {
        if (fichero.canWrite()) {
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero,false));
                for (Object item : contents) {
                    try {
                        escritor.write(item.toString() + '\n');
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
        else
            System.out.println("Error: no se puede escribir al fichero");
    }

    /*
     * Lee una cadena de la entrada estándar de datos,
     * mostrando primero el mensaje que se pasa como parámetro
     */
    public static String leerCadena(String prompt) {
        if (prompt != null)
            System.out.print(prompt);

        String resultado = null;
        try {
            resultado = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}