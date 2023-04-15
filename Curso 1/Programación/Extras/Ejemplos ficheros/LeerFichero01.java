/* Ejemplo de lectura de un fichero */
import java.io.*;
public class LeerFichero01 {
    public static void main(String[] args) {
        String cad;

        try {
            FileReader fr = new FileReader("Persona.java");
            
            BufferedReader br = new BufferedReader(fr);
            while ((cad = br.readLine()) != null) {
                System.out.println(cad);
            }
            //Cerramos el stream
            br.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
