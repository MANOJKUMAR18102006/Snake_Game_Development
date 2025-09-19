package frontend;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
    public GameFrame(){
        this.add(new GamePanel()); // Add game panel to frame
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack(); // Fit window size to content
        this.setVisible(true);
        this.setLocationRelativeTo(null); // Center the window
    }
}