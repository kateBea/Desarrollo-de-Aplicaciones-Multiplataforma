package jdbc.ejercicio4;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

public class TableRecordsWindow extends Window {
    private JTable m_Table;
    private JScrollPane m_ScrollPane;
    private DefaultTableModel m_Model;
    private ResultSetMetaData m_MetaData;
    private ResultSet m_ResultRecords;

    @Override
    protected void setup() {
        try {
            for (int index = 1; index <= m_MetaData.getColumnCount(); ++index) {
                m_Model.addColumn(m_MetaData.getColumnName(index));
            }
            
            while (m_ResultRecords.next()) {
                ArrayList<Object> temp = new ArrayList<>();
                for (int index = 1; index <= m_MetaData.getColumnCount(); ++index) {
                    temp.add(m_ResultRecords.getString(index));
                }
                m_Model.addRow(temp.toArray());  
            }
        } 
        catch (SQLException e) {
            System.out.println(e.getSQLState());
        }

        m_Table.setModel(m_Model);
        add(m_ScrollPane);
        pack();
    }

    public TableRecordsWindow(String name, ResultSet result, ResultSetMetaData meta) {
        super(name);
        m_Table = new JTable();
        m_Model = new DefaultTableModel();
        m_ScrollPane = new JScrollPane(m_Table);

        m_ResultRecords = result;
        m_MetaData = meta;

        setup();
    }
}
