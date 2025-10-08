package frontend;

import backend.UserAuth;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton loginButton, registerButton;
    private JLabel messageLabel;

    public LoginFrame() {
        setTitle("Snake Game - Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        usernameInput = new JTextField(15);
        gbc.gridx = 1;
        add(usernameInput, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        passwordInput = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordInput, gbc);

        loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);

        registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(registerButton, gbc);

        messageLabel = new JLabel("");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(messageLabel, gbc);

        loginButton.addActionListener(e -> {
            String username = usernameInput.getText();
            String password = new String(passwordInput.getPassword());

            if (UserAuth.login(username, password)) {
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Login Successful!");
                dispose();
                new GameFrame(username);
                //SwingUtilities.invokeLater(() -> new MainMenuFrame(user));
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Invalid credentials! Try again.");
            }
        });

        registerButton.addActionListener(e -> new RegisterFrame());

        setVisible(true);
    }
}
