package frontend;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame(String username) {
        // Set up the window
        setTitle("Snake Game - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // center the window

        // Create the main panel with vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panel.add(welcomeLabel);

        // Buttons
        JButton newGameButton = new JButton("🎮 New Game");
        //JButton leaderboardButton = new JButton("🏆 Leaderboard");
        JButton logoutButton = new JButton("🚪 Logout");

        // Set button sizes and alignments
        Dimension buttonSize = new Dimension(200, 40);
        newGameButton.setMaximumSize(buttonSize);
        //leaderboardButton.setMaximumSize(buttonSize);
        logoutButton.setMaximumSize(buttonSize);

        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //leaderboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add spacing and buttons to panel
        panel.add(newGameButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        //panel.add(leaderboardButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(logoutButton);

        // Add action listeners
        newGameButton.addActionListener(e -> {
            dispose(); // close this menu
            new GameFrame(username); // open game
        });

        /*leaderboardButton.addActionListener(e -> {
            new LeaderboardFrame(); // show leaderboard
        });*/

        logoutButton.addActionListener(e -> {
            dispose(); // close this menu
            new LoginFrame(); // go back to login screen
        });

        // Add panel to frame
        add(panel);
        setVisible(true);
    }
}
