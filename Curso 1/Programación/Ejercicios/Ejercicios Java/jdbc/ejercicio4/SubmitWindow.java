import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitWindow extends Window implements ActionListener {
    private String m_User;
    private String m_Password;
    private boolean m_DataSubmitted;
    private boolean m_CancelHit;
    private JButton m_SubmitButton;
    private JButton m_CancelButton;

    private JTextArea m_UserTextField;
    private JTextArea m_PasswordTextField;
    @Override
    protected void setup() {
        setSize(640, 200);
        setResizable(false);
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(10);

        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();

        GridLayout southLayout = new GridLayout(1, 2);
        southLayout.setHgap(10);
        south.setLayout(southLayout);
        south.add(m_SubmitButton);
        south.add(m_CancelButton);


        north.setLayout(new GridLayout(1, 2));
        north.add(new JLabel("Usuario: "));
        north.add(m_UserTextField);

        center.setLayout(new GridLayout(1, 2));
        center.add(new JLabel("Contraseña: "));
        center.add(m_PasswordTextField);

        getContentPane().add(north);
        getContentPane().add(center);
        getContentPane().add(south);
        setLayout(gridLayout);

        pack();
    }

    public SubmitWindow(String name) {
        super(name);

        m_DataSubmitted = false;
        m_CancelHit = false;

        m_SubmitButton = new JButton("Submit");
        m_CancelButton = new JButton("Cancel");

        m_UserTextField = new JTextArea(1, 20);
        m_PasswordTextField = new JTextArea(1, 20);

        m_SubmitButton.addActionListener(this);
        m_CancelButton.addActionListener(this);

        setup();
    }

    public String getPasswordString() {
        return m_Password;
    }

    public String getUserString() {
        return m_User;
    }

    public boolean hasDataReady() {
        return m_DataSubmitted;
    }

    public boolean isCancelHit() {
        return m_CancelHit;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == m_SubmitButton)
            m_DataSubmitted = true;
        else if (event.getSource() == m_CancelButton)
            m_CancelHit = true;
    }
}
