import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) {
        // String user = leerCadena("Introduzca el usuario por favor: ");
        // String password = leerCadena("Introduzca la contraseña por favor ('none' si no tiene): ");

        DBConnector dbc = new DBConnector("jardineria", "root", "none");
        App application = new App("Gestor DB GUI", dbc.getUrl());
        
        application.addDataBaseConnector(dbc);
        application.renderGui();
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
