package frontend;

import backend.UserAuth;
import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JLabel messageLabel;

    public RegisterFrame() {
        setTitle("Register - Snake Game");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passLabel, gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordField, gbc);

        registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);

        messageLabel = new JLabel(" ");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(messageLabel, gbc);

        registerButton.addActionListener(e -> {
            String user = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword()).trim();

            if (user.isEmpty() || pass.isEmpty()) {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Fields cannot be empty!");
                return;
            }

            if (UserAuth.register(user, pass)) {
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Registration successful!");
                dispose();
                SwingUtilities.invokeLater(() -> new GameFrame(user));
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Username already exists!");
            }
        });

        pack();
        setResizable(false);
        setVisible(true);
    }
}
