package entrada_salida;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Redireccionamiento {
    public static void main(String[] args) throws FileNotFoundException {
        System.setOut(new PrintStream(new FileOutputStream("salida_normal.txt")));
        System.setErr(new PrintStream(new FileOutputStream("salida_error.txt")));

        System.out.println("Esta es la salida estándar normal");
        System.err.println("Esta es la salida estándar de errores");

        throw new RuntimeException("Error Fatal");

    }
}
