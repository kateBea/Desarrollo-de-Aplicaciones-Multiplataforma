/* Ejemplo de lectura de un fichero con Scanner */
import java.io.*;
import java.util.Scanner;
public class LeerFichero02 {
    public static void main(String[] args) {
        try {
            File f =new File("Persona.java");
            Scanner sc = new Scanner(f);             
            while (sc.hasNextLine()){
                 System.out.println(sc.nextLine());
            }           
         
            sc.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
       
    }
}
