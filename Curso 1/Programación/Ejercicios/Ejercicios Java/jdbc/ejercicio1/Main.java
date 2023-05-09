package jdbc.ejercicio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) {
        String user = leerCadena("Introduzca el usuario por favor: ");
        String password = leerCadena("Introduzca la contraseña por favor ('none' si no tiene): ");
        DatabaseConnection dbc;

        try {
            dbc = new DatabaseConnection("Empresa_index", user, password);
            ResultSet result = dbc.fetch("SELECT * FROM Empleados WHERE Dept_No = 30");

            while (result.next()) {
                System.out.printf("Número: %s | Apellido: %s | Oficio: %s | Dirección: %s | Fecha alta: %s | " + 
                                            "Salario %s | Comision %s | No. Departamento %s\n",
                        result.getString(1), 
                        result.getString(2), 
                        result.getString(3), 
                        result.getString(4),
                        result.getString(5), 
                        result.getString(6), 
                        result.getString(7), 
                        result.getString(8)
                );
            }
            
        }
        catch (RuntimeException | SQLException re) {
            System.out.println(re.getMessage());
        }
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