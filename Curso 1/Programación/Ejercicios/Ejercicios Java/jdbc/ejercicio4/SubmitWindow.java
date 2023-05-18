package jdbc.ejercicio4;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SubmitWindow extends Window implements ActionListener {
    private String m_User;
    private char[] m_Password;
    private JButton m_SubmitButton;
    private JButton m_CancelButton;

    private JTextField m_UserTextField;
    private JPasswordField m_PasswordTextField;

    private MainMenuWindow m_MainMenuWindow;
    private DatabaseConnection m_Dbc;

    private void insertRows() throws SQLException {
        m_Dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('YYYY654', 'Toyota', 'Yaris', CURRENT_DATE())");
        m_Dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('ETRY364', 'Suzuki', 'Jimmy', CURRENT_DATE())");
        m_Dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('URYW827', 'Nissan', 'Juke', CURRENT_DATE())");
        m_Dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('ORUW927', 'Nissan', 'Skyline', CURRENT_DATE())");
        m_Dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('NDFA281', 'Mercedes', 'Glc', CURRENT_DATE())");
        m_Dbc.execute("INSERT INTO Coches (Matricula, Marca, Modelo, Fecha_Compra) VALUES ('ZBDG641', 'Toyota', 'Avensis', CURRENT_DATE())");
    }

    private void createTables() throws SQLException {
        m_Dbc.execute("DROP TABLE IF EXISTS Coches");
        m_Dbc.execute(
                """
          CREATE TABLE IF NOT EXISTS Coches (
                    Matricula CHAR(7) PRIMARY KEY,
                    Marca CHAR(45) NOT NULL,
                    Modelo CHAR(45) NOT NULL,
                    Fecha_Compra DATETIME NOT NULL
                )
         """);
    }

    @Override
    protected void setup() {
        setSize(640, 200);
        setResizable(false);
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(0);

        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();
    
        // SOUTH CONTENTS SETUP
        GridLayout southLayout = new GridLayout(1, 1);
        JPanel soutPanel1 = new JPanel();
        JPanel soutPanel2 = new JPanel();
        soutPanel1.setLayout(new FlowLayout());
        soutPanel2.setLayout(new FlowLayout());
        soutPanel1.add(m_SubmitButton);
        soutPanel2.add(m_CancelButton);

        southLayout.setHgap(10);
        south.setLayout(southLayout);

        south.add(soutPanel1);
        south.add(soutPanel2);

        // NORTH CONTENTS SETUP
        north.setLayout(new GridLayout(1, 1));
        JPanel northPanel1 = new JPanel();
        JPanel northPanel2 = new JPanel();
        northPanel1.add(new JLabel("Usuario: "));
        m_UserTextField.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(null, 1),
            new EmptyBorder(7, 7, 7, 7)
        ));
        northPanel2.add(m_UserTextField);

        north.add(northPanel1);
        north.add(northPanel2);

        // CENTER CONTENTS SETUP
        center.setLayout(new GridLayout(1, 1));
        JPanel centerPanel1 = new JPanel();
        JPanel centerPanel2 = new JPanel();

        centerPanel1.add(new JLabel("Contraseña: "));
        centerPanel2.add(m_PasswordTextField);

        center.add(centerPanel1);
        center.add(centerPanel2);

        getContentPane().add(north);
        getContentPane().add(center);
        getContentPane().add(south);
        setLayout(gridLayout);

        pack();
    }

    public SubmitWindow(String name) {
        super(name);

        m_SubmitButton = new JButton("Submit");
        m_CancelButton = new JButton("Cancel");

        m_MainMenuWindow = null;
        m_Dbc = null;

        m_UserTextField = new JTextField(20);
        m_PasswordTextField = new JPasswordField(20);

        m_SubmitButton.addActionListener(this);
        m_CancelButton.addActionListener(this);

        setup();
    }

    public String getUserString() {
        return m_User;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == m_SubmitButton) {
            m_Password = m_PasswordTextField.getPassword();
            m_User = m_UserTextField.getText();
            
            try {
                m_Dbc = new DatabaseConnection("test_programacion", m_User, new String(m_Password));
                dispose();
                initDB();
                m_MainMenuWindow = new MainMenuWindow("Menú principal", m_Dbc);
                m_MainMenuWindow.displayWindow();
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        else if (event.getSource() == m_CancelButton)
            System.exit(0);
    }

    private void initDB() {
        try {
            insertRows();
            createTables();
        } 
        catch (SQLException e) {
            System.out.println(e.getSQLState());    
        }
    }
}
