package interfaces2.clases;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ej1 extends JFrame implements ActionListener {
    private JPanel northPan;
    private JPanel centertPan;
    private JPanel southtPan;

    private JTextField panelTexto;

    private JTextField campo;

    private JButton buttonBorrar;
    private JButton buttonCopiar;

    private JLabel label;

    private void setup(String windowName, int width, int height) {
        setSize(width, height);
        setTitle(windowName);
        setLocation(100, 480);
        setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }
        
        // accion por defecto al cerrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        northPan.add(label);
        northPan.add(campo);

        centertPan.add(buttonBorrar);
        centertPan.add(buttonCopiar);
        
        buttonBorrar.addActionListener(this);
        buttonCopiar.addActionListener(this);

        panelTexto.setEditable(false);
        southtPan.add(panelTexto);
        pack();
    }

    public Ej1(String name, int width, int height) {  
        setLayout(new BorderLayout());
        label = new JLabel("Introduce un texto y pulsa copiar");
        northPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 10));
        centertPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        southtPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelTexto = new JTextField(20);
        campo = new JTextField(20);

        buttonBorrar = new JButton("Borrar");
        buttonCopiar = new JButton("Copiar");

        getContentPane().add("North", northPan);
        getContentPane().add("Center", centertPan);
        getContentPane().add("South", southtPan);

        setup(name, width, height);
    }

    public void render() {
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == buttonBorrar) {
            campo.setText("");
        }

        if (event.getSource() == buttonCopiar) {
            panelTexto.setText(campo.getText());
        }
    }
}
