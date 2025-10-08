package frontend;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame(String username) {
        // Set up the main window
        setTitle("Snake Game - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center on screen
        setResizable(false); // Prevent window resizing

        // Create a panel with vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Welcome message
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // space below
        panel.add(welcomeLabel);

        // New Game button
        JButton newGameButton = new JButton("🎮 New Game");
        newGameButton.setMaximumSize(new Dimension(200, 40));
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(newGameButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15))); // space between buttons

        // Leaderboard button
        JButton leaderboardButton = new JButton("🏆 Leaderboard");
        leaderboardButton.setMaximumSize(new Dimension(200, 40));
        leaderboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(leaderboardButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Logout button
        JButton logoutButton = new JButton("🚪 Logout");
        logoutButton.setMaximumSize(new Dimension(200, 40));
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(logoutButton);

        // Add action for New Game
        newGameButton.addActionListener(e -> {
            dispose(); // Close current menu
            new GameFrame(username); // Start new game
        });

        // Action for Leaderboard
        leaderboardButton.addActionListener(e -> {
            new LeaderboardFrame(); // Show leaderboard
        });

        // Action for Logout
        logoutButton.addActionListener(e -> {
            dispose(); // Close current menu
            new LoginFrame(); // Back to login
        });

        // Add panel to frame
        add(panel);
        setVisible(true);
    }
}
