package jdbc.ejercicio2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) {
        String user = leerCadena("Introduzca el usuario por favor: ");
        String password = leerCadena("Introduzca la contraseña por favor ('none' si no tiene): ");
        DatabaseConnection dbc;

        try {
            dbc = new DatabaseConnection("test_programacion", user, password);
            createTables(dbc);
            insertRows(dbc);

            gestor(dbc);
        }
        catch (RuntimeException | SQLException re) {
            System.out.println(re.getMessage());
        }
    }

    public static void gestor(DatabaseConnection dbc) {
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(leerCadena("Elija opción: "));

            if (opcion >= 1 && opcion <= 4)
                procesarOpcion(opcion, dbc);
        }
        while(opcion != 5);

    }

    private static void insertRows(DatabaseConnection dbc) throws SQLException {
        dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('YYYY654', 'Toyota', 'Yaris', CURRENT_DATE())");
        dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('ETRY364', 'Suzuki', 'Jimmy', CURRENT_DATE())");
        dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('URYW827', 'Nissan', 'Juke', CURRENT_DATE())");
        dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('ORUW927', 'Nissan', 'Skyline', CURRENT_DATE())");
        dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('NDFA281', 'Mercedes', 'Glc', CURRENT_DATE())");
        dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('ZBDG641', 'Toyota', 'Avensis', CURRENT_DATE())");
    }

    private static void createTables(DatabaseConnection dbc) throws SQLException {
        dbc.execute("DROP TABLE IF EXISTS Coches");
        dbc.execute(
                """
          CREATE TABLE IF NOT EXISTS Coches (
                    Matricula CHAR(7) PRIMARY KEY,
                    Marca CHAR(45) NOT NULL,
                    Modelo CHAR(45) NOT NULL,
                    Fecha_Compra DATETIME NOT NULL
                )
         """);
    }

    private static void procesarOpcion(int opcion, DatabaseConnection dbc) {
        switch(opcion) {
            case 1 -> displayAll(dbc);
            case 2 -> {
            }
            case 3 -> {

            }
            case 4 -> {

            }

        }
    }

    private static void displayAll(DatabaseConnection dbc) {
        try {
            ResultSet result = dbc.fetch("SELECT * FROM Coches");

            while(result.next()) {
                System.out.printf("Matrícula: %s | Marca: %s | Modelo: %s | Fecha Compra: %s\n",
                        result.getString(1), result.getString(2), result.getString(3), result.getString(4));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarMenu() {
        System.out.println();
        System.out.println("1. Listar vehículos");
        System.out.println("2. Buscar vehículo");
        System.out.println("3. Eliminar vehículo");
        System.out.println("4. Modificar vehículo");
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