package ejercicios_ficheros.reading_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    private static final Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        String userInput;
        System.out.print("Indique el directorio del fichero que desea leer: ");
        userInput = lector.nextLine();
        
        File file = new File(userInput);

        if (file.exists() && file.isFile()) {
            try {
                readFromFile(file);
            } 
            catch (IOException e) {
                System.out.println("Excepción de lectura de fichero...");
            }
        }
        else
            System.out.println("El fichero no existe o no es un fichero regular...");
        

        lector.close();
    }

    public static void readFromFile(File file) throws IOException {
        if (file.canRead()) {
            String contents;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((contents = reader.readLine()) != null)
                System.out.println(contents);

            reader.close();
        }
    }
}