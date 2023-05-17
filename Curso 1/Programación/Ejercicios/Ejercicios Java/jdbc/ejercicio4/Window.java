package jdbc.ejercicio4;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class Window extends JFrame {
    protected static final int DEFAULT_WIDTH = 1280;
    protected static final int DEFAULT_HEIGHT = 1280;

    protected abstract void setup();

    public Window(String tile) {
        super(tile);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }

        // spawn window in the middle of the screen
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void displayWindow() {
        setVisible(true);
    }

    public void hideWindow() {
        setVisible(false);
    }

}
