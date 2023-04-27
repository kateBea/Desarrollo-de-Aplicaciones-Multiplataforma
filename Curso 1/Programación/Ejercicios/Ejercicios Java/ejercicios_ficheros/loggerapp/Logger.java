package ejercicios_ficheros.loggerapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    /**
     * Output contents to a Log file. If the fiel does not exists,
     * it is created
     * @param fileName file path
     * @param contents contents to be written
     */
    public static void write(String fileName, String... contents) {
        File outputFile = new File(fileName);

        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } 
            catch (IOException e) {
                System.out.println("Error while creating the file in the provided directory");
                e.printStackTrace();
            }

            writeToFile(outputFile, LocalDateTime.now(), contents);
        }
        else if (outputFile.isFile() && outputFile.canWrite()) {
            writeToFile(outputFile, LocalDateTime.now(), contents);
        }
        else
            System.err.println("Error due to one of the following: the path does not " +
                               "refer to a valid file or the user does not have write permisions to it");
    }

    /**
     * Output contents to a Log file
     * Se asume que el fichero ya existe
     * @param fileName file path
     * @param contents contents to be written
     */
    public static void writeToFile(File fichero, LocalDateTime point, String... contents) {
        if (fichero.canWrite()) {
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero,true));
                for (String item : contents) {
                    try {
                        escritor.write(String.format("[%s] %s\n", point.toString(), item));
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
