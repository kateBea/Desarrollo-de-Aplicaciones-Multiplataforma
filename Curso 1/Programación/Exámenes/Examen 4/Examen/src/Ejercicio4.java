import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ejer4.*;


public class Ejercicio4 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) {
        final String USER = "root";
        final String PASSWORD = "none";
        final String DB_NAME = "exProg3Ev";
        DatabaseConnection dbc;

        try {
            System.out.println("Bienvenido a la aplicación.");
            dbc = new DatabaseConnection(DB_NAME, USER, PASSWORD);
            gestor(dbc);
            dbc.closeConnection();
        }
        catch (RuntimeException excp) {
            System.out.println(excp.getMessage());
        }
    }

    public static void gestor(DatabaseConnection dbc) {
        int opcion = 1;

        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(leerCadena("Teclee opción (1 - 4): "));
                if (opcion >= 1 && opcion <= 4)
                    procesarOpcion(opcion, dbc);
            }
            catch (NumberFormatException nfe) {
                System.out.println("Error solo se permiten números entre el 1 y 4");
            }
        }
        while(opcion != 4);

    }

    private static void procesarOpcion(int opcion, DatabaseConnection dbc) {
        String codigoEmpl;
        switch(opcion) {
            case 1:
                codigoEmpl = leerCadena("Escriba el código del empleado\n");
                lookFor(dbc, codigoEmpl);
                break;
            case 2:
                displayAll(dbc);
                break;
            case 3:
                exportTiFile(dbc);
                break;
        }
    }

    private static void exportTiFile(DatabaseConnection dbc) {
        File fichero = new File("output.txt");
        ArrayList<String> emplData = new ArrayList<>();
        try {
            fichero.createNewFile();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            ResultSet result = dbc.fetch(String.format("select * from employees"));
            System.out.println("Código      Nombre      Apellidos      Email      Fecha      Telefóno\n");
            while (result.next()) {
                emplData.add(String.format(
                    "%s         %s          %s          %s          %s          %s\n",
                        result.getString("EMPLOYEE_ID"), 
                        result.getString("FIRST_NAME"), 
                        result.getString("LAST_NAME"), 
                        result.getString("EMAIL"),
                        result.getString("HIRE_DATE"),
                        result.getString("PHONE_NUMBER")));

                writeToFile(fichero, emplData.toArray());
            }

            if (emplData.isEmpty())
                System.out.printf("No hay resultados");

        } 
        catch (SQLException e) {
            System.out.println(e.getSQLState());
        }

    }

    public static void writeToFile(File fichero, Object... contents) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero,false));
            for (Object item : contents) {
                try {
                    escritor.write(item.toString());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            escritor.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void lookFor(DatabaseConnection dbc, String codigoEmpl) {
        try {
            ResultSet result = dbc.fetch(String.format("select * from employees where EMPLOYEE_ID='%s'", codigoEmpl));
            if (result.next()) {
                System.out.printf("Código      Nombre      Apellidos      Email      Fecha      Telefóno\n" +
                    "%s         %s          %s          %s          %s          %s\n",
                        result.getString("EMPLOYEE_ID"), 
                        result.getString("FIRST_NAME"), 
                        result.getString("LAST_NAME"), 
                        result.getString("EMAIL"),
                        result.getString("HIRE_DATE"),
                        result.getString("PHONE_NUMBER"));
            }
            else
                System.out.printf("No hay resultados");
        } 
        catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    private static void displayAll(DatabaseConnection dbc) {
        try {
            ResultSet result = dbc.fetch("SELECT * FROM employees");

            System.out.println("Código      Nombre      Apellidos      Email      Fecha      Telefóno\n");
            while(result.next()) {
                System.out.printf(
                    "%s     %s      %s      %s      %s      %s\n",
                        result.getString("EMPLOYEE_ID"), 
                        result.getString("FIRST_NAME"), 
                        result.getString("LAST_NAME"), 
                        result.getString("EMAIL"),
                        result.getString("HIRE_DATE"),
                        result.getString("PHONE_NUMBER"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarMenu() {
        System.out.println();
        System.out.println("1. Buscar empleado por id y mostrar sus datos");
        System.out.println("2. Listar todos los empleados por pantalla");
        System.out.println("3. Exportar todos los empleados a un fichero de texto");
        System.out.println("4. Salir");
        System.out.println();
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