package ejercicios_ficheros.reverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio6 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        String userInput = leerCadena("Introduzca el directorio del fichero: ");
        File fileInput = new File(userInput);
        ArrayList<String> contents = null;

        if (fileInput.exists() && fileInput.isFile()) {
            try {
                contents = getFileLines(fileInput);
                writeToFile(makeName(fileInput.getName()), contents.toArray());
            } 
            catch (IOException e) {
                System.out.println("Error de excepción al leer del fichero...");
                e.printStackTrace();
            }
        }
        else
            System.out.println("El fichero no existe o no es un fichero regular...");
    }

    public static String makeName(String name) {
        int firsDotIndex = name.indexOf(".");
        return name.substring(0, firsDotIndex) + "_reverse" + name.substring(firsDotIndex, name.length());
    }

    public static ArrayList<String> getFileLines(File file) throws IOException {
        ArrayList<String> result = null;
        if (file.canRead()) {
            String contents;
            result = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((contents = reader.readLine()) != null)
                result.add(0, contents);

            reader.close();
        }

        return result;
    }

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

    public static void writeToFile(String fileName, Object... contents) {
        File outputFile = new File(fileName);

        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } 
            catch (IOException e) {
                System.out.println("Error while creating the file in the provided directory");
                e.printStackTrace();
            }

            writeToFile(outputFile, contents);
        }
        else if (outputFile.isFile() && outputFile.canWrite()) {
            writeToFile(outputFile, contents);
        }
        else
            System.err.println("Error due to one of the following: the path does not " +
                               "refer to a valid file or the user does not have write permisions to it");
    }

    public static void writeToFile(File fichero, Object... contents) {
        if (fichero.canWrite()) {
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero, false));
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
}