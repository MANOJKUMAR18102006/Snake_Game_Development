package frontend;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    private String username;

    public GameFrame(String username) {
        this.username = username;
        this.add(new GamePanel());
        this.setTitle("Snake Game - Player: " + username);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
