package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Pedir por teclado el nombre del departamento, a continuación
 * mostrar todos los dato del departamento, incluidos sus
 * empleados. Proyecto Maven con IntelliJ IDEA.
 * */
public class Main {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static Connection connect() throws SQLException {
        final String USER = "sa";
        final String PASSWORD = "";
        final String URL_CONNECTION = "jdbc:h2:";
        final String DATABASE = "~/test";

        final String ADDRESS = URL_CONNECTION + DATABASE;

        return DriverManager.getConnection(ADDRESS, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = connect()) {
            System.out.println("Conexión establecida");

            // NOTA: recomendable usar preparedStatement

            final String entrada = leerCadena("Introduzca el nombre de departamento: ");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Departamento WHERE Nombre='" + entrada + "'" );

            // salvaremos el ID del departamento para reutilizar en consulta posterior
            String deptId = null;
            if (rs.first()) {
                deptId = rs.getString("id");

                ResultSetMetaData rsm = rs.getMetaData();

                System.out.println("Datos del departamento: " + entrada);
                for (int index = 1; index <= rsm.getColumnCount(); ++index) {
                    System.out.print(rsm.getColumnLabel(index) + "=" + rs.getObject(index).toString() + " ");
                }
            }
            else {
                System.out.println("Departamento " + entrada + " no existe.");
            }

            if (deptId != null) {
                rs = st.executeQuery("SELECT * FROM Empleado WHERE Depto_id='" + deptId + "'" );

                System.out.println("\n\nEmpleados del departamento: " + entrada);
                while (rs.next()) {
                    ResultSetMetaData rsm = rs.getMetaData();
                    for (int index = 1; index <= rsm.getColumnCount(); ++index) {
                        System.out.print(rsm.getColumnLabel(index) + "=" + rs.getObject(index).toString() + " ");
                    }
                }
            }
        }
        catch (SQLException e) {
            System.err.println("Error al establecer conexión. Causa: " + e.getCause());
        }
    }

    public static String leerCadena(String prompt) {
        if (prompt != null) { System.out.print(prompt); }

        String result = null;

        try {
            result = lector.readLine();
        } catch (IOException e) {
            System.err.println("Error al leer cadena");
        }

        return result;
    }
}