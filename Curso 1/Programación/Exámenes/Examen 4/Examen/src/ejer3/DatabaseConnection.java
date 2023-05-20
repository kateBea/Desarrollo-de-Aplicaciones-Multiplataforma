package ejer3;

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

    public ResultSet fetch(String query) throws SQLException {
        return m_Statement.executeQuery(query);
    }

    public boolean execute(String query) throws SQLException {
        return m_Statement.execute(query);
    }

    public String getUser() {
        return m_User;
    }

    public String getDataBaseName() {
        return m_DataBaseName;
    }
}