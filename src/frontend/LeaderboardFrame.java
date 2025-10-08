package frontend;

import javax.swing.*;
import java.awt.*;

public class LeaderboardFrame extends JFrame {

    public LeaderboardFrame() {
        // Set up the window
        setTitle("🏆 Leaderboard");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Create text area to display scores
        JTextArea leaderboardArea = new JTextArea();
        leaderboardArea.setEditable(false); // Read-only
        leaderboardArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Example scores - can be replaced with real data later
        leaderboardArea.setText("Top Scores:\n\n"
                + "1. Manoj - 25\n"
                + "2. Hari - 20\n"
                + "3. Santhosh - 15");

        // Add scroll pane in case list grows
        JScrollPane scrollPane = new JScrollPane(leaderboardArea);
        add(scrollPane);

        // Show the window
        setVisible(true);
    }
}
