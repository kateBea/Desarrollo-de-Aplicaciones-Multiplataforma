package jdbc.ejercicio2;
import java.sql.*;

public class DatabaseConnection {
    private  Connection m_Connection;
    private final String m_DataBaseName;
    private  Statement m_Statement;
    private final String m_User;

    private boolean initConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e) {
            System.out.print("Unable to load driver. Error message: " + e.getMessage());
            return false;
        }

        return true;
    }

    private boolean establishConnection(String db, String user, String password) {
        try {
            m_Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db,
                    user, (password.equalsIgnoreCase("none") ? null : password));

            if (!m_Connection.isValid(50000))
                throw new RuntimeException("Invalid connection to the database");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * Established a new connection to the database with name dbName
     * for the user provided using the given password. It may throw exceptions
     * if the database could not be connected to or the driver was not found
     * @param dbName name of the target database
     * @param user user that requests connection to the database
     * @param password password to be used for the user if value is null or string contains the values "none" this parameter is ignored
     * @throws RuntimeException if the driver was not found or the connection is not valid
     * */
    public DatabaseConnection(String dbName, String user, String password) {
        m_DataBaseName = dbName;
        m_User = user;

        if (!initConnection())
            throw new RuntimeException("Impossible to load JDBC driver");

        if (!establishConnection(dbName, user, password))
            throw new RuntimeException("Invalid connection to the Database [ " + dbName + " ]");

        try {
            m_Statement = m_Connection.createStatement();
        }
        catch (SQLException e) {
            System.out.println("Exception on attempt to initialize Statement. Message: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            m_Statement.close();
            m_Connection.close();
        }
        catch (SQLException e) {
            System.out.println("Error on attempt to close DB Connection. " + e.getMessage());
        }
    }

    /**
     * Executes the given query and returns a ResulSet
     * containing all the fetched rows if any
     * */
    public ResultSet fetch(String query) throws SQLException {
        return m_Statement.executeQuery(query);
    }

    /**
     * Executes the given query. Does not return values
     * */
    public void execute(String query) throws SQLException {
        m_Statement.execute(query);
    }

    /**
     * Returns the name of the user currently using this DatabaseConnection
     * @return user logged on with this connection
     * */
    public String getUser() {
        return m_User;
    }

    /**
     * Returns the name of the database currently connected to
     * @return connected database name
     * */
    public String getDataBaseName() {
        return m_DataBaseName;
    }
}