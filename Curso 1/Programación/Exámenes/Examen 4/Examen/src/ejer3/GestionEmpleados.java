package ejer3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ejer1.Employee;

public class GestionEmpleados extends JFrame implements ActionListener {
    private static final int TOTAL_CAMPOS = 7;
    // GUI COMPONENTS
    JPanel north;
    JPanel center;
    JPanel south;

    JTextField estadoField;

    JButton botonAlta;
    JButton botonBorrar;

    DatabaseConnection dbc;

    LinkedList<Pair<JLabel, JTextField>> campos;
    LinkedList<JPanel> contenedoresCampos;
    Font fielsFont; 
    
    private void setup(int width, int height) {
        setSize(width, height);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setupNorthPan();
        setupCenterPan();
        setupSouthPan();

        botonAlta.addActionListener(this);
        botonBorrar.addActionListener(this);
        estadoField.setEditable(false);

        getContentPane().add("North", north);
        getContentPane().add("Center", center);
        getContentPane().add("South", south);
        pack();
    }

    private void setupSouthPan() {
        JPanel der = new JPanel(new FlowLayout());
        JPanel izq = new JPanel(new FlowLayout(FlowLayout.LEFT));
        der.add(botonBorrar);
        der.add(botonAlta);
        south.setLayout(new GridLayout(1, 2));

        izq.add(new JLabel("Estado:"));
        izq.add(estadoField);

        south.add(izq);
        south.add(der);
    }

    private void setupCenterPan() {
        center.setLayout(new GridLayout(TOTAL_CAMPOS, 1));
        for (JPanel item : contenedoresCampos)
            center.add(item);
    }

    private void setupNorthPan() {
        JLabel titulo = new JLabel("BIENVENIDOS A LA GESTION DE EMPLEADOS");
        Font fuente = new  Font("Segoe print", Font.BOLD, 22);
        titulo.setFont(fuente);
        north.add(titulo);
    }

    private void altaEmpleado(Employee empl) {
        try {
            dbc.execute(String.format(
                "INSERT INTO employees (EMPLOYEE_ID,FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, SALARY, COMMISSION_PCT) VALUES" +
                    "('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s)", 
                    empl.getDni(), empl.getNombre(), empl.getApellidos(), 
                    campos.get(3).getSecond().getText(), // emali
                    campos.get(4).getSecond().getText(), // telf
                    empl.getFechaContratacion().toString(),     // fecha contrato
                    String.valueOf(empl.getSalario()),                           // salario
                    "null"                                      // comision                        
                )
            );
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            setStatusLabel("Error: " + e.getSQLState());
        }
    }

    public GestionEmpleados(String windowName, int width, int height, DatabaseConnection dbc) {
        super(windowName);
        this.dbc = dbc;
        campos = new LinkedList<>();
        contenedoresCampos = new LinkedList<>();
        north = new JPanel();
        center = new JPanel();
        south = new JPanel();
        fielsFont = new  Font("Arial", Font.ITALIC, 16);
        botonAlta = new JButton("Alta");
        botonBorrar = new JButton("Borrar");
        estadoField = new JTextField(15);
        estadoField.setText("ok");

        campos.add(new Pair<>(new JLabel("Id:"), new JTextField(20)));
        campos.add(new Pair<>(new JLabel("Nombre:"), new JTextField(20)));
        campos.add(new Pair<>(new JLabel("Apellido:"), new JTextField(20)));
        campos.add(new Pair<>(new JLabel("Email:"), new JTextField(20)));
        campos.add(new Pair<>(new JLabel("Teléfono:"), new JTextField(20)));
        campos.add(new Pair<>(new JLabel("Fecha Contrato:"), new JTextField(20)));
        campos.add(new Pair<>(new JLabel("Salario:"), new JTextField(20)));

        for (int i = 0; i < TOTAL_CAMPOS; ++i) 
            contenedoresCampos.add(new JPanel(new FlowLayout(FlowLayout.CENTER)));

        int indice = 0;
        for (Pair<JLabel, JTextField> item : campos) {
            item.getFirst().setFont(fielsFont);
            contenedoresCampos.get(indice).add(item.getFirst());
            contenedoresCampos.get(indice).add(item.getSecond());
            ++indice;
        }

        setup(width, height);
    }

    public void enableEvents() {
        for (Pair<JLabel, JTextField> item : campos) {
            item.getSecond().setEnabled(true);
        }

        botonAlta.setEnabled(true);
        botonBorrar.setEnabled(true);
    }

    public void disableEvents() {
        for (Pair<JLabel, JTextField> item : campos) {
            item.getSecond().setEnabled(false);
        }

        botonAlta.setEnabled(false);
        botonBorrar.setEnabled(false);
    }

    public void render() {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == botonBorrar) {
            for (Pair<JLabel, JTextField> item : campos) {
                item.getSecond().setText("");
            }
        }
        else if (event.getSource() == botonAlta) {
            int dia = Integer.parseInt(campos.get(5).getSecond().getText().split("-")[2]);
            int mes = Integer.parseInt(campos.get(5).getSecond().getText().split("-")[1]);
            int anio = Integer.parseInt(campos.get(5).getSecond().getText().split("-")[0]);
            Employee empl = new Employee(
                campos.get(0).getSecond().getText(), // id
                campos.get(1).getSecond().getText(), // nombre
                campos.get(2).getSecond().getText(), // apellidos
                LocalDate.of(anio, mes, dia), // fecha con
                Double.parseDouble(campos.get(6).getSecond().getText()) // sueldo
            );

            altaEmpleado(empl);
        }
    }

    public void setStatusLabel(String info) {
        estadoField.setText(info);
    }

    public static String requestValue(String promt) {
        return JOptionPane.showInputDialog(null, promt);
    }
}
