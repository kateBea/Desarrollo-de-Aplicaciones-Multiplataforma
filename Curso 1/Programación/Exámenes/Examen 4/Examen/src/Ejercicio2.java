import ejer2.*;

public class Ejercicio2 {
    public static void main(String[] args)  {
        final String USER = GestionEmpleados.requestValue("Enter database user name");
        final String PASSWORD = GestionEmpleados.requestValue("Enter database user password");;
        final String DB_NAME = "exProg3Ev";
        DatabaseConnection dbc;
        GestionEmpleados gestorGui;

        try {
            dbc = new DatabaseConnection(DB_NAME, USER, PASSWORD);
            gestorGui = new GestionEmpleados("Gestión de Empleados", 640, 480, dbc);
            gestorGui.disableEvents();
            gestorGui.render();

            dbc.closeConnection();
        }
        catch (RuntimeException excp) {
            System.out.println(excp.getMessage());
        }
    }
}