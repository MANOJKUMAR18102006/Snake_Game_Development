package frontend;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;  // size of each square
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 100; // snake speed
    int foodX;
    int foodY;
    int score = 0;
    Random random;

    final int x[] = new int[GAME_UNITS]; // x-coordinates of snake body
    final int y[] = new int[GAME_UNITS]; // y-coordinates of snake body
    int bodyParts = 6; // initial snake size
    char direction = 'R'; // U, D, L, R
    Timer timer;

    public GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        //this.addKeyListener(new MyKeyAdapter());
        startGame();
    }


    public void startGame() {
        newFood();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void newFood() {
        foodX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        foodY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

}