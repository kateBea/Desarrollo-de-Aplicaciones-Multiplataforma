import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Lista extends JFrame {
    public Lista(String windowName) {
        super(windowName);
        setSize(680, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        String[] paises = { "España", "Italia" };
        JComboBox<String> combo = new JComboBox<>(paises);
        getContentPane().add("North", combo);
        setVisible(true);
    }
    public static void main(String[] args) {
        Lista list = new Lista("Lista");
    }
}
