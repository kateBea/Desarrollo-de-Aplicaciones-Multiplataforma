package interfaces1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    JButton btnPulsa = new JButton("Púlsame");
    JLabel lbSaluda = new JLabel("Hola");
    JTextField txtNombre = new JTextField(10);

    public static void main(String[] args) {
        Main ej = new Main();
        ej.setVisible(true);
    }

    public Main(){
        // ponemos el título a la ventana
        super ("Ejemplo ventana con botón");

        // tamaño de la ventana
        setSize (800, 200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setup();

    }

    public void setup(){
        Container  contenedor= getContentPane();
        contenedor.setLayout(new FlowLayout());

        //agregar evento
        btnPulsa.addActionListener(this);
        contenedor.add(lbSaluda);
        contenedor.add(txtNombre);
        contenedor.add(btnPulsa);
    }

    //tratamiento de evento
    public void actionPerformed (ActionEvent e){
        lbSaluda.setText("Adios " + txtNombre.getText());
        txtNombre.setText(null);
    }
}
