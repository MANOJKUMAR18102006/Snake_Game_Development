package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{
    // screen settings
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    static final int BOX_SIZE = 25;  // each square
    static final int MAX_UNITS = (WIDTH * HEIGHT) / BOX_SIZE;
    static final int SPEED = 120; // bigger = slower

    int foodX;
    int foodY;
    
    int score = 0;
    
    Random random;
    boolean running = false;

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

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }
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
    
    public void checkCollisions() {
        // check if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        // check if head touches left border
        if (x[0] < 0) {
            running = false;
        }
        // check if head touches right border
        if (x[0] >= SCREEN_WIDTH) {
            running = false;
        }
        // check if head touches top border
        if (y[0] < 0) {
            running = false;
        }
        // check if head touches bottom border
        if (y[0] >= SCREEN_HEIGHT) {
            running = false;
        }
    }

    public void checkFood() {
        if (x[0] == foodX && y[0] == foodY) {
            bodyParts++;
            score++;
            newFood();
        }
    }
}