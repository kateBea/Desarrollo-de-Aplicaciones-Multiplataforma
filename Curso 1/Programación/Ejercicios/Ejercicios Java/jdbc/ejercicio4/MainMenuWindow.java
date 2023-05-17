package jdbc.ejercicio4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuWindow extends Window implements ActionListener {
    private JButton m_ListarButton;
    private JButton m_ModifyButton;
    private JButton m_EliminarButton;
    private JButton m_BuscarButton;
    private JButton m_ExitButton;

    private DatabaseConnection m_Dbc;

    @Override
    protected void setup() {
        setSize(275, 467);
        setResizable(false);

        GridLayout gridlayout = new GridLayout(5, 1);
        gridlayout.setVgap(10);
        setLayout(gridlayout);

        JPanel[] panels = new JPanel[]{ new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel()};
        for (JPanel panel : panels)
            panel.setLayout(new FlowLayout());

        m_ListarButton.setPreferredSize(new Dimension(150, 40));
        m_ModifyButton.setPreferredSize(new Dimension(150, 40));
        m_EliminarButton.setPreferredSize(new Dimension(150, 40));
        m_BuscarButton.setPreferredSize(new Dimension(150, 40));
        m_ExitButton.setPreferredSize(new Dimension(150, 40));

        panels[0].add(m_ListarButton);
        panels[1].add(m_ModifyButton);
        panels[2].add(m_EliminarButton);
        panels[3].add(m_BuscarButton);
        panels[4].add(m_ExitButton);

        for (JPanel panel : panels)
            getContentPane().add(panel);

        m_ListarButton.addActionListener(this);
        m_ModifyButton.addActionListener(this);
        m_EliminarButton.addActionListener(this);
        m_BuscarButton.addActionListener(this);
        m_ExitButton.addActionListener(this);

    }

    public MainMenuWindow(String name, DatabaseConnection dbc) {
        super(name);

        m_ListarButton = new JButton("Listar vehículos");
        m_ModifyButton = new JButton("Modificar vehículos");
        m_EliminarButton = new JButton("Eliminar vehículos");
        m_BuscarButton = new JButton("Buscra vehículos");
        m_ExitButton = new JButton("Salir"); 
        m_Dbc = dbc;

        setup();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == m_ListarButton) {
            ResultSet result;
            try {
                result = m_Dbc.fetch("SELECT * FROM Coches");
                ResultSetMetaData meta = result.getMetaData();
                TableRecordsWindow table = new TableRecordsWindow("Resultados", result, meta);
                dispose();
                table.displayWindow();
            } 
            catch (SQLException e) {
                System.out.println(e.getSQLState());
            }

        }
        else if (event.getSource() == m_ModifyButton) {
            
        }
        else if (event.getSource() == m_EliminarButton) {
            
        }
        else if (event.getSource() == m_BuscarButton) {
            
        }
        else if (event.getSource() == m_ExitButton) {
            
        }
    }
}
