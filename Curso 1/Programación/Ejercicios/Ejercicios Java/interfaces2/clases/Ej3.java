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

public class Ej3 extends JFrame implements ActionListener  {
    private JPanel m_North;
    private JPanel m_Center;
    private JPanel m_South;

    private JTextField m_TextFieldOp1;
    private JTextField m_TextFieldOp2;
    private JTextField m_TextFieldResult;;

    private JButton m_SumaButton;
    private JButton m_RestaButton;
    private JButton m_MultButton;
    private JButton m_DivButton;

    private void setup(int width, int height) {
        setSize(width, height);
        // works properly if the screen is wide enough
        setLocation(1210, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }

        northPanelSetup();
        centerPanelSetup();
        southPanelSetup();

        m_SumaButton.addActionListener(this);
        m_RestaButton.addActionListener(this);
        m_MultButton.addActionListener(this);
        m_DivButton.addActionListener(this);

        m_SumaButton.setPreferredSize(new Dimension(50, 50));
        m_RestaButton.setPreferredSize(new Dimension(50, 50));
        m_MultButton.setPreferredSize(new Dimension(50, 50));
        m_DivButton.setPreferredSize(new Dimension(50, 50));

        // ADD STUFF TO THE FRAME
        setLayout(new BorderLayout());
        getContentPane().add("North", m_North);
        getContentPane().add("Center", m_Center);
        getContentPane().add("South", m_South);
        pack();

    }
    
    private void southPanelSetup() {
        m_South.setLayout(new GridLayout(2, 1));

        FlowLayout flow = new FlowLayout();
        flow.setHgap(15);
        JPanel first = new JPanel(flow);
        JPanel second = new JPanel(flow);

        first.add(m_SumaButton);
        first.add(m_RestaButton);
        first.add(m_MultButton);
        first.add(m_DivButton);

        second.add(new JLabel("RESULTADO:"));
        second.add(m_TextFieldResult);

        m_South.add(first);
        m_South.add(second);
    }

    private void northPanelSetup() {
        m_North.add(new JLabel("CALCULADORA"));
    }

    private void centerPanelSetup() {
        m_Center.setLayout(new GridLayout(2, 1));

        FlowLayout flow = new FlowLayout();
        flow.setHgap(15);
        JPanel first = new JPanel(flow);
        JPanel second = new JPanel(flow);

        first.add(new JLabel("Operando 1:"));
        first.add(m_TextFieldOp1);
        second.add(new JLabel("Operando 2:"));
        second.add(m_TextFieldOp2);

        m_Center.add(first);
        m_Center.add(second);
    }

    public Ej3(String windowName, int width, int height) {
        super(windowName);

        m_North = new JPanel();
        m_Center = new JPanel();
        m_South = new JPanel();

        m_TextFieldOp1 = new JTextField(20);
        m_TextFieldOp2 = new JTextField(20);
        m_TextFieldResult = new JTextField(20);

        m_SumaButton = new JButton("+");
        m_RestaButton = new JButton("-");
        m_MultButton = new JButton("*");
        m_DivButton = new JButton("÷");

        setup(width, height);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String op1 = m_TextFieldOp1.getText(); 
        String op2 = m_TextFieldOp2.getText(); 
        float result = .0f;

        if (op1.isEmpty() || op2.isEmpty()) {
            m_TextFieldResult.setText("An operand is null or both are null");
            return;
        }

        if (event.getSource() == m_SumaButton) 
            result = Float.parseFloat(op1) + Float.parseFloat(op2);
        else if (event.getSource() == m_RestaButton) 
            result = Float.parseFloat(op1) - Float.parseFloat(op2);
        else if (event.getSource() == m_MultButton) 
            result = Float.parseFloat(op1) * Float.parseFloat(op2);
        else if (event.getSource() == m_DivButton) {
            if (Float.parseFloat(op2) == 0) {
                m_TextFieldResult.setText("Division by 0 error");
                return;
            }

            result = Float.parseFloat(op1) / Float.parseFloat(op2);
        }

        m_TextFieldResult.setText(String.format("%f", result));
    }

    public void render() {
        setVisible(true);
    }
}
