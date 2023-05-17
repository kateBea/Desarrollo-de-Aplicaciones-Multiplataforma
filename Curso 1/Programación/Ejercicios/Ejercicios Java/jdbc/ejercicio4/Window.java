import javax.swing.JFrame;

public abstract class Window extends JFrame {
    protected static final int DEFAULT_WIDTH = 1280;
    protected static final int DEFAULT_HEIGHT = 1280;

    protected abstract void setup();

    public Window(String tile) {
        super(tile);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void displayWindow() {
        setVisible(true);
    }

}
