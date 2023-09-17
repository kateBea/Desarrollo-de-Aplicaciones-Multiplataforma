import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Lector {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static String leerCadena(String prompt) {
        if (prompt != null)
            System.out.print(prompt);

        String resultado = null;

        try {
            resultado = lector.readLine();
        }
        catch (IOException exception) {
            System.out.println("Excep leer cadena: " + exception.getCause());
        }

        return resultado;
    }

}