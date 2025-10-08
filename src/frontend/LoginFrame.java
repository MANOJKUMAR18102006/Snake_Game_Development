package frontend;

import backend.UserAuth;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    // Input boxes for username and password
    private JTextField usernameInput;
    private JPasswordField passwordInput;

    // Buttons for login and register
    private JButton loginButton, registerButton;

    // Label to show success or error messages
    private JLabel messageLabel;

    // Constructor – runs when the login screen is created
    public LoginFrame() {
        // Title of the window
        setTitle("Snake Game - Login");

        // Set window size
        setSize(350, 250);

        // Close the program when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on screen
        setLocationRelativeTo(null);

        // Use a flexible layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // padding between elements

        // Username Label and Input
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;  // column 0
        gbc.gridy = 0;  // row 0
        add(usernameLabel, gbc);

        usernameInput = new JTextField(15);
        gbc.gridx = 1;  // column 1
        add(usernameInput, gbc);

        // Password Label and Input
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        passwordInput = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordInput, gbc);

        // Login Button
        loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);

        // Register Button
        registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(registerButton, gbc);

        // Message Label
        messageLabel = new JLabel("");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(messageLabel, gbc);

        // Login Button Action
        loginButton.addActionListener(e -> {
            String username = usernameInput.getText();              // get text from username box
            String password = new String(passwordInput.getPassword()); // get password

            // Check login credentials using backend UserAuth class
            if (UserAuth.login(username, password)) {
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Login Successful!");

                // Close login window and open game
                dispose();
                new GameFrame(username); // open game with logged-in user
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Invalid credentials! Try again.");
            }
        });

        // Register Button Action
        registerButton.addActionListener(e -> {
            // Open registration window
            new RegisterFrame();
        });

        // Make the window visible
        setVisible(true);
    }
}
