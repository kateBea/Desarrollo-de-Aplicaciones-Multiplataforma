import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/* Ejemplo crea fichero mensaje2 y escribe 10 lineas. 
 * Cada vez que ejecuta reemplaza el fichero si existe
 */
public class EscribirFichero02 {
    public static void main(String[] args) {        
        
        FileWriter fichero = null;
        PrintWriter pw = null;           
        try{
            fichero = new FileWriter("mensaje2.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)        
                pw.println("Linea " + i);
            
            fichero.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
              e2.printStackTrace();           
        }
    }
}
