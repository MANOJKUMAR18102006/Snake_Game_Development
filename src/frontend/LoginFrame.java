package frontend;

import backend.UserAuth;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    private JLabel messageLabel;

    public LoginFrame() {
        setTitle("Snake Game - Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 0;
        add(userLabel, gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(passLabel, gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordField, gbc);

        loginButton = new JButton("Login");
        gbc.gridx = 1; gbc.gridy = 2;
        add(loginButton, gbc);

        registerButton = new JButton("Register");
        gbc.gridx = 1; gbc.gridy = 3;
        add(registerButton, gbc);

        messageLabel = new JLabel("");
        gbc.gridx = 1; gbc.gridy = 4;
        add(messageLabel, gbc);

        loginButton.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (UserAuth.login(user, pass)) {
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Login Successful!");
                dispose();
                new GameFrame(user); // pass username
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Invalid credentials!");
            }
        });

        setVisible(true);
    }
}
