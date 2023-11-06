package utilidades;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class FormattedIO {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    /**
     * Lee una línea de la entrada estándard de datos mostrando 
     * primero el prompt que se pasa como parámetro. Si se falla la lectura devuelve null
     * @param prompt mensaje a mostrar antes de la lectura
     * @returns string con la línea leída
     * */
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

    public static String leerCadena() {
        return leerCadena(null);
    }

    public static Integer leerInteger() {
        Integer result = null;

        return result;
    }

    public static Double leerDouble() {
        Double result = null;

        return result;
    }

    public static Double leerBoolean() {
        Double result = null;

        return result;
    }

}