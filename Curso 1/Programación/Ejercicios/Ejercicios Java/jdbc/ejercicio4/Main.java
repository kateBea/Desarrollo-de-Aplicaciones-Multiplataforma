package jdbc.ejercicio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) {
        SubmitWindow submitWindow = new SubmitWindow("Datos");
        submitWindow.displayWindow();
    }


    public static String leerCadena(String prompt) {
        if (prompt != null)
            System.out.print(prompt);

        String resultado = "";

        try { resultado = lector.readLine(); }
        catch (IOException e) { e.printStackTrace(); }

        return resultado;
    }
}