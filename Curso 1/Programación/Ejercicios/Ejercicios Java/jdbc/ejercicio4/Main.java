import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLException;


public class Main {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) {
        DatabaseConnection dbc;
        MenuWindow menuWindow;
        SubmitWindow submitWindow;

        try {
            submitWindow = new SubmitWindow("Datos");
            submitWindow.displayWindow();

            while (!submitWindow.hasDataReady()) {
                if (submitWindow.isCancelHit())
                    return;
            }

            dbc = new DatabaseConnection("test_programacion", submitWindow.getUserString(), submitWindow.getPasswordString());

            createTables(dbc);
            insertRows(dbc);
            menuWindow = new MenuWindow("Menú principal");

            gestor(dbc, menuWindow);
        }
        catch (RuntimeException | SQLException re) {
            System.out.println(re.getMessage());
        }
    }

    public static void gestor(DatabaseConnection dbc, MenuWindow menuWindow) {


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

    public static String leerCadena(String prompt) {
        if (prompt != null)
            System.out.print(prompt);

        String resultado = "";

        try { resultado = lector.readLine(); }
        catch (IOException e) { e.printStackTrace(); }

        return resultado;
    }
}