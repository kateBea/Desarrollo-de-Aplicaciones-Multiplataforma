package interfaces3;

import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

public class AltaDepartamento1 extends JFrame implements ActionListener {
    //componentes
    JTextField txtId = new JTextField(5);
    JTextField txtName = new JTextField(10);
    
    
    public AltaDepartamento1(){
        super("Alta Departamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setup();
    }

    private void setup(){
        Font myFont = new Font ("Segoe print", Font.BOLD, 22);
        JLabel lbTitle = new JLabel("BIENVENIDOS",JLabel.CENTER);
        lbTitle.setFont(myFont);        
        JLabel lbMensaje = new JLabel("");
        JLabel lbId = new JLabel("Id departamento:");
        JLabel lbName = new JLabel("Titulo departamento:");

        JButton btnSiguiente = new JButton (">>");
        JButton btnAnterior = new JButton ("<<");
        JButton btnAlta = new  JButton ("Alta");
        JPanel panelCentral = new JPanel();      
        JPanel panelBotonera = new JPanel();
        btnAlta.addActionListener(this);
        btnSiguiente.addActionListener(this);
        btnAnterior.addActionListener(this);

      
        panelBotonera.add(btnSiguiente);
        panelBotonera.add(btnAlta);
        panelBotonera.add(btnAnterior);

        txtId.setEnabled(false);
        txtName.setEnabled(false);

        JPanel panelId = new JPanel ();
        panelId.setLayout(new FlowLayout());
        panelId.add(lbId);
        panelId.add(txtId);


        JPanel panelName = new JPanel ();
        panelName.setLayout(new FlowLayout());
        panelName.add(lbName);
        panelName.add(txtName);



        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout (3,1));
        panel1.add(panelId);     
        panel1.add(panelName);
       

        panelCentral.setLayout(new GridLayout (3,2));
     
        panelCentral.add(panelId);     
        panelCentral.add(panelName);
     
        
        setLayout(new GridLayout (4,1));
        add( lbTitle);
        add(panelCentral );
        add(panelBotonera );
        add(lbMensaje );
        
        
        setSize(600,300); //damos tamaño

        setVisible(true);
        
    }
    private void alta_dpto(){
        txtId.setEnabled(false);
        txtName.setEnabled(false);
        

    }

    public void actionPerformed (ActionEvent ev){
        JButton btn = (JButton) ev.getSource();
        String texto = btn.getActionCommand().toString();
        System.out.println (texto);
        switch(texto){
            case "Alta":
                alta_dpto();
                break;

            case "<<":

            case ">>":
        }

    }

    private void conectaBD(){
        
    }
    public static void main (String[] args) {
        AltaDepartamento1 ad =new AltaDepartamento1();
       // ad.conecta();
    }
}
