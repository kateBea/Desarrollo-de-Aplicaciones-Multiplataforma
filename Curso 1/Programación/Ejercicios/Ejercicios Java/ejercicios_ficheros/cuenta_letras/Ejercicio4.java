package ejercicios_ficheros.cuenta_letras;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio4 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        String userInput = leerCadena("Introduzca el directorio del fichero: ");
        File fileInput = new File(userInput);
        ArrayList<String> content = null;

        if (fileInput.exists() && fileInput.isFile()) {
            try {
                content = getFileLines(fileInput);
            } catch (IOException e) {
                System.out.println("Error de excepción al leer del fichero...");
                e.printStackTrace();
            }
            showCharacterCount(content);
        }
    }

    public static void showCharacterCount(ArrayList<String> words) {
        int count = 0;
        for (String linea : words) {
            String temp = linea.trim();
            for (int i = 0; i < temp.length(); ++i) {
                if (Character.isLetter(temp.charAt(i))) {
                    ++count;
                }
            }
        }

        System.out.printf("Hay un total de %d letras en el fichero\n", count);
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