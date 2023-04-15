import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirFichero01 {

    public static void main(String[] args) {
        String cad1 = "Esto es una cadena.";
        String cad2 = "Esto es otra cadena con acéntos.";
        try {
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("salida.txt")));

            salida.println(cad1);
            salida.println(cad2);

            //Cerramos el stream
            salida.close();
            System.out.println("Fichero creado");
        } catch (IOException ioe) {
            System.out.println("Error IO: " + ioe.toString());
        }
    }
}
