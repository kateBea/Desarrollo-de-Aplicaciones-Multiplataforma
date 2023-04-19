package replace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio5 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        String userInput = leerCadena("Introduzca el directorio del fichero: ");
        File fileInput = new File(userInput);

        String target = leerCadena("Introduzca la palabra a reemplazar: ");
        String newWord = leerCadena("Introduzca la nueva palabra por que reemplazar: ");

        if (fileInput.exists() && fileInput.isFile())
            replaceTextFile(fileInput, target, newWord);
    }

    public static void replaceTextFile(File fichero, String target, String newWord) {
        final String FILE_OUTPUT_NAME = "file_out.txt";
        ArrayList<String> content = null;

        try {
            content = getFileLines(fichero);
            replaceTarget(content, target, newWord);
        } catch (IOException e) {
            System.out.println("Error de excepción al leer del fichero...");
            e.printStackTrace();
        }

        if (content != null)
            writeToFile(FILE_OUTPUT_NAME, content.toArray());
    }

    public static ArrayList<String> getFileLines(File file) throws IOException {
        ArrayList<String> result = null;
        if (file.canRead()) {
            String contents;
            result = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((contents = reader.readLine()) != null)
                result.add(contents);

            reader.close();
        }

        return result;
    }

    public static void replaceTarget(ArrayList<String> content, String target, String newWord) {
        for (int i = 0; i < content.size(); ++i) {
            String temp = content.remove(i).replaceAll(target, newWord);
            content.add(i, temp);
        }
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
        else
            System.out.println("Error: no se puede escribir al fichero");
    }
}