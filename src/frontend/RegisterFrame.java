package frontend;

import backend.UserAuth;
import javax.swing.*;
import java.awt.*;

/**
 * A simple registration window for the Snake Game.
 * Allows users to create a new account by entering username and password.
 */
public class RegisterFrame extends JFrame {

    // UI Components
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton registerButton;
    private JLabel statusLabel;

    // Constructor
    public RegisterFrame() {
        // Basic frame setup
        setTitle("Snake Game - Register");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());  // Using grid layout for alignment

        // Layout manager settings
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Adds spacing between components

        // ----- Username -----
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        usernameInput = new JTextField(15);
        gbc.gridx = 1;
        add(usernameInput, gbc);

        // ----- Password -----
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        passwordInput = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordInput, gbc);

        // ----- Register Button -----
        registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(registerButton, gbc);

        // ----- Status Message -----
        statusLabel = new JLabel("");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(statusLabel, gbc);

        // ----- Button Action -----
        registerButton.addActionListener(event -> handleRegister());

        // Show the window
        setVisible(true);
    }

    // Handles registration logic
    private void handleRegister() {
        String username = usernameInput.getText();
        String password = new String(passwordInput.getPassword());

        if (UserAuth.register(username, password)) {
            statusLabel.setForeground(Color.GREEN);
            statusLabel.setText("User registered successfully!");
        } else {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("Username already exists!");
        }
    }

    // Main method (optional) to test this frame directly
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegisterFrame::new);
    }
}
