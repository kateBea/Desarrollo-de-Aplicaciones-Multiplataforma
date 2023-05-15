import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    private Connection conn;
    private Statement sentencia;
    private ResultSet resultados;
    private ResultSetMetaData rmeta;
    private String dbUser;
    private String dbUserPass;
    private String url;

    private JTextField txtUsuario;
    private JTextField txtClave;
    private JTextField txtUrl;

    private JTextArea txtSentencia;
    private JTextArea txtResultadoSentencia;

    private JButton consulta;
    private JButton conexion;
    private JButton borrar;

    JPanel panelArriba;
    JPanel panelCentro;
    JPanel panelAbajo;

    JLabel lbUsuario;
    JLabel lbPass;
    JLabel lbUrl;
    JLabel lbSentencia;

    private DBConnector dbc;

    public App(String windowName, String displayUrl) {
        super(windowName);
        txtUsuario = new JTextField(25);
        txtClave = new JTextField(25);
        txtUrl = new JTextField(displayUrl);

        txtSentencia = new JTextArea(5, 50);
        txtResultadoSentencia = new JTextArea(14, 100);

        consulta = new JButton("Ejecutar consulta");
        conexion = new JButton("Establecer conexión");
        borrar =  new JButton("Borrar consulta");

        panelArriba = new JPanel();
        panelCentro = new JPanel();
        panelAbajo = new JPanel();

        lbUsuario = new JLabel("Usuario: ");
        lbPass = new JLabel("Contraseña: ");
        lbUrl = new JLabel("DataBase URL: ");
        lbSentencia = new JLabel("Sentencia SQL: ");

        setupGUI();
    }

    private void setupGUI() {
        setResizable(false);


        panelArriba.add(lbUsuario);
        panelArriba.add(txtUsuario);
        panelArriba.add(lbPass);
        panelArriba.add(txtClave);
        panelArriba.add(lbUrl);
        panelArriba.add(txtUrl);
        panelArriba.add(conexion);

        panelCentro.add(lbSentencia);
        panelCentro.add(txtSentencia);
        panelCentro.add(consulta);
        
        txtResultadoSentencia.setEditable(false);
        panelAbajo.add(txtResultadoSentencia);
        panelAbajo.add(borrar);

        setLayout(new BorderLayout());
        add("North", panelArriba);
        add("Center", panelCentro);
        add("South", panelAbajo);

        consulta.addActionListener(this);
        conexion.addActionListener(this);
        borrar.addActionListener(this);

        setBackground(Color.ORANGE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    public void renderGui() {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consulta) {
            System.out.println("Realizando consulta...");

            ejecutarConsulta();
        }
        else if (e.getSource() == conexion) {
            System.out.println("Estableciendo conexión...");
            
            if (!dbc.establishConnection(dbc.getDataBaseName(), txtUsuario.getText(), txtClave.getText()))
                throw new RuntimeException("Invalid connection to the Database [ " + dbc.getDataBaseName() + " ]");
        }
        else if (e.getSource() == borrar) {
            System.out.println("Borrando contenido de consulta...");
        }
    }

    private void ejecutarConsulta() {
        if (!dbc.isConnected())
            txtResultadoSentencia.setText(txtResultadoSentencia.getName() == null ? "" : txtResultadoSentencia.getName()
                +    '\n' +   "Necesita establecer conexión primero");
        try {
            resultados = dbc.fetch(txtSentencia.getText().trim());
            rmeta = resultados.getMetaData();
            
            // para formatear salida
            boolean first = true;
            for (int index = 1; index < rmeta.getColumnCount(); ++index) {
                if (first) {
                    first = false;
                    txtResultadoSentencia.setText(txtResultadoSentencia.getText() + rmeta.getColumnName(index));
                }
                else
                    txtResultadoSentencia.setText(txtResultadoSentencia.getText() + "   |   " + rmeta.getColumnName(index));

                
            }
            
            while (resultados.next()) {
                for (int index = 1; index < rmeta.getColumnCount(); ++index)  {
                    txtResultadoSentencia.setText(txtResultadoSentencia.getText() + resultados.getString(index) + '\n');
                }

                txtResultadoSentencia.setText(txtResultadoSentencia.getText() + '\n');
            }
        } 
        catch (SQLException excep) {
            System.out.println("Error consulta\n" + excep.getMessage());
            txtResultadoSentencia.setText("Error consulta\n" + excep.getMessage());
        }
    }

    public void addDataBaseConnector(DBConnector dbc) {
        this.dbc = dbc;
    }
}
