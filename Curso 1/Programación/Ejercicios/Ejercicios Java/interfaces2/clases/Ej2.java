package interfaces2.clases;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ej2 extends JFrame implements ActionListener {
    private JTextField m_Text;
    private JButton m_BorrarButton;
    private JButton m_MayusButton;
    private JButton m_MinusButton;
    private JTextField m_TextReadOnly;

    private void setup(int width, int height) {
        setSize(width, height);
        setLayout(new BorderLayout());
        setLocation(790, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }
        m_TextReadOnly.setEditable(false);

        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();

        // NORTH PANEL
        FlowLayout fl1 = new FlowLayout();
        fl1.setHgap(10);
        north.setLayout(fl1);
        north.add(new JLabel("Intruce texto:"));
        north.add(m_Text);


        // CENTER PANEL
        FlowLayout fl2 = new FlowLayout();
        fl2.setHgap(10);
        center.setLayout(fl2);
        center.add(m_BorrarButton);

        JPanel buttons = new JPanel(new GridLayout(1, 2));
        buttons.add(m_MayusButton);
        buttons.add(m_MinusButton);

        center.add(m_BorrarButton);
        center.add(buttons);

        // SOUTH PANEL
        south.add(m_TextReadOnly);

        // BUTTONS SETUP
        m_BorrarButton.addActionListener(this);
        m_MayusButton.addActionListener(this);
        m_MinusButton.addActionListener(this);

        getContentPane().add("North", north);
        getContentPane().add("Center", center);
        getContentPane().add("South", south);
        pack();
    }

    public Ej2(String windowName, int width, int height) {
        super(windowName);

        m_Text = new JTextField(20);
        m_BorrarButton = new JButton("Borrar");
        m_MayusButton = new JButton("Mayúsculas");
        m_MinusButton = new JButton("Minúsculas");
        m_TextReadOnly = new JTextField(20);
        setup(width, height);
    }

    public void render() {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == m_BorrarButton) 
            m_Text.setText("");
        else if (event.getSource() == m_MayusButton) 
            m_TextReadOnly.setText(m_Text.getText().toUpperCase());
        else if (event.getSource() == m_MinusButton) 
            m_TextReadOnly.setText(m_Text.getText().toLowerCase());
        
    }
}
