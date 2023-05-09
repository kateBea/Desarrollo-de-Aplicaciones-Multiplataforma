package jdbc;

import java.sql.*;
import java.io.*;

/**
 * Trabaja sobre la base de datos Jardineria vista en clase vista en clase
 * y muestra datos sobre clientes
 * */
public class Ejercicio3 {
    private static Connection conexion;
    private static Statement sentencia;
    private static ResultSet resultado;

    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) throws Exception {
        String user;
        String password;
        
        if (!initConnection())
            return; 

        user = leerCadena("Introduzca el usuario por favor: ");
        password = leerCadena("Introduzca la contraseña por favor ('none' si no tiene): ");

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria", user, (password.equalsIgnoreCase("none") ? null : password));
            boolean valid = conexion.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
            sentencia = conexion.createStatement();

            resultado = sentencia.executeQuery("SELECT * FROM Clientes");
            while (resultado.next()) {
                System.out.println("Código: " + resultado.getString(1)+'\n' +
                                    "Nombre: " + resultado.getString(2) +'\n' +
                                    "Contacto: " + resultado.getString(3)+ '\n' +
                                    "Teléfono: " + resultado.getString(5) +'\n' +
                                    "-----------------------------------");
            }

            sentencia.close();
            resultado.close();
            conexion.close();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);

        } catch (Exception e) {
            System.out.print("No se pudo realizar conexión");
            return;
        }
    }

    public static boolean initConnection() {
        try {
            // Driver obsoleto
            //Class.forName("com.mysql.jdbc.Driver");

            Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (Exception e) {
            System.out.print("No se pudo cargar el driver" + e);
            return false;
        }

        return true;
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
