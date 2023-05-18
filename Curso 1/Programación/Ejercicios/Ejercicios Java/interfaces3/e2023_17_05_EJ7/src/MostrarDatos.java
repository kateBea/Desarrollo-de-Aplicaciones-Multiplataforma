/*
 * @author Zyssk0
 * @date 17/05/23
 * Desc: programa que recorre los datos de la base de datos curso y va mostrando por pantalla los datos de los empleados
 * 
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MostrarDatos extends JFrame implements ActionListener{
    
    static int index = 1;
   
    
    //GUI
    JLabel lbltitulo = new JLabel("Departamento");
    JLabel lblDpto = new JLabel("N Dpto");
    JLabel lblName = new JLabel("Nombre");
    JLabel lblLocation = new JLabel("Localidad");

    JTextField txtDpto = new JTextField(20);
    JTextField txtName = new JTextField(20);
    JTextField txtLocation = new JTextField(20);

    JButton btnPrevious = new JButton("<<");
    JButton btnUpload = new JButton("Alta");
    JButton btnEdit = new JButton("Editar");
    JButton btnNext = new JButton(">>");

    DataBaseLogic dblogic = new DataBaseLogic();

    public static void main(String[]args){
        MostrarDatos mmain = new MostrarDatos();
        
    }

    public MostrarDatos(){
        super("Mostrar Datos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        dblogic.connectDB("curso","root","Password1234");
        setup();
        
    }

    public void setup(){
        JPanel panTitulo = new JPanel();
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        JPanel pan3 = new JPanel();
        JPanel panbotones = new JPanel();

        panTitulo.add(lbltitulo);
        pan1.add(lblDpto);
        pan1.add(txtDpto);
        pan2.add(lblName);
        pan2.add(txtName);
        pan3.add(lblLocation);
        pan3.add(txtLocation);
        panbotones.add(btnPrevious);
        panbotones.add(btnUpload);
        panbotones.add(btnEdit);
        panbotones.add(btnNext);

        setLayout(new GridLayout(5,1));
        add(panTitulo);
        add(pan1);
        add(pan2);
        add(pan3);
        add(panbotones);

        setTextsToFields(index);//Inicializamos el programa con los primeros valores que encuentre en la tabla
        btnPrevious.addActionListener(this);
        btnUpload.addActionListener(this);
        btnEdit.addActionListener(this);
        btnNext.addActionListener(this);

        editFields(false);
        pack();
        setVisible(true);
      
        
       



    }


   public void editFields(boolean choice){
        txtDpto.setEditable(choice);
        txtName.setEditable(choice);
        txtLocation.setEditable(choice);
   }
   

   
   public void emptyTextFields(){
    txtDpto.setText("");
    txtLocation.setText("");
    txtName.setText("");
   }
    public void setTextsToFields(int index){
        String[] results = dblogic.showSelect(index);
            txtDpto.setText(results[0]);
            txtName.setText(results[1]);
            txtLocation.setText(results[2]);
    }
    public void actionPerformed(ActionEvent ev){
        if(index < 1)//Evitar Index 0
            index = 1;

        
        if(ev.getSource() == btnPrevious){
            index = index - 1;
            setTextsToFields(index);
        }
        else if(ev.getSource() == btnNext){//Boton Next
            index += 1;
            setTextsToFields(index);}
        else if(ev.getSource() == btnUpload){
             String dpto = txtDpto.getText();
             String name = txtName.getText();
             String location = txtLocation.getText();
             editFields(dblogic.uploadData(dpto, name, location));
            
        }
        else //Editar
            if(!txtName.isEditable()){
                editFields(true);
                emptyTextFields();
            }
            else{
                editFields(false);
                emptyTextFields();
            }
          
        
    }

}
