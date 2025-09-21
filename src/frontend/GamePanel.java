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
    static final int SPEED = 120; // bigger snake= slower speed

    // snake body coords
    int[] x = new int[MAX_UNITS];
    int[] y = new int[MAX_UNITS];

    int snakeLen = 6;   // initial length
    int score = 0;
    char dir = 'R';     // snake moving right at start
    boolean gameOn = false;

    // apple
    int appleX,appleY;
    Random rand;

    Timer timer;

    public GamePanel(){
        rand = new Random();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKey());

        startGame();
    }

    public void startGame(){
        makeApple();
        gameOn = true;
        timer = new Timer(SPEED, this);
        timer.start();
    }

    public void makeApple(){
        appleX = rand.nextInt(WIDTH / BOX_SIZE) * BOX_SIZE;
        appleY = rand.nextInt(HEIGHT / BOX_SIZE) * BOX_SIZE;
    }

    public void moveSnake(){
        for(int i = snakeLen; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        if(dir == 'U') y[0] -= BOX_SIZE;
        else if(dir == 'D') y[0] += BOX_SIZE;
        else if(dir == 'L') x[0] -= BOX_SIZE;
        else if(dir == 'R') x[0] += BOX_SIZE;

        // steps of the snake head
        //System.out.println("Snake head at: " + x[0] + "," + y[0]);
    }

    public void checkApple(){
        if(x[0] == appleX && y[0] == appleY){
            snakeLen++;
            score++;
            makeApple();
        }
    }

    public void checkHit(){
        // hit self
        for(int i = snakeLen; i > 0; i--){
            if(x[0] == x[i] && y[0] == y[i]){
                gameOn = false;
            }
        }
        // hit wall
        if(x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT){
            gameOn = false;
        }

        if(!gameOn) timer.stop();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        if(gameOn) {
            // apple
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, BOX_SIZE, BOX_SIZE);

            // snake body
            for(int i=0;i<snakeLen;i++){
                if(i==0) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.ORANGE);
                }
                g.fillRect(x[i], y[i], BOX_SIZE, BOX_SIZE);
            }

            // score in center
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 28));
            String scoreText = "Score: " + score;
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(scoreText);
            g.drawString(scoreText, (WIDTH - textWidth) / 2, 40); // 40 px from top
        }else {
            gameOver(g);
        }
    }

    public void gameOver(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("GAME OVER", WIDTH/2 - 120, HEIGHT/2);

        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Press R to Restart", WIDTH/2 - 90, HEIGHT/2 + 40);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Final Score: " + score, WIDTH/2 - 70, HEIGHT/2 + 80);
    }

    public void restart(){
        snakeLen = 6;
        score = 0;
        dir = 'R';
        gameOn = true;

        // reset snake body
        for(int i=0;i<snakeLen;i++){
            x[i] = 0;
            y[i] = 0;
        }
        makeApple();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(gameOn){
            moveSnake();
            checkApple();
            checkHit();
        }
        repaint();
    }

    public class MyKey extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int k = e.getKeyCode();
            if(k == KeyEvent.VK_LEFT && dir != 'R') dir = 'L';
            else if(k == KeyEvent.VK_RIGHT && dir != 'L') dir = 'R';
            else if(k == KeyEvent.VK_UP && dir != 'D') dir = 'U';
            else if(k == KeyEvent.VK_DOWN && dir != 'U') dir = 'D';
            else if(k == KeyEvent.VK_R && !gameOn) restart();
        }
    }
}
