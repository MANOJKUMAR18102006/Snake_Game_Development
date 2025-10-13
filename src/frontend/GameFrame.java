package frontend;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    // Removed unused field 'username'

    public GameFrame(String username) {
        this.add(new GamePanel(username));
        this.setTitle("Snake Game - Player: " + username);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
