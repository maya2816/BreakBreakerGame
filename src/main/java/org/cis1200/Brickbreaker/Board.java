package org.cis1200.Brickbreaker;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.*;

/**
 * The Board class is the model for the game, which represents
 * the game main window and handles its overall logic.
 * <>
 * The model updates in response to a player's action, which
 * result in the board repainting itself and updating its status
 * JLabel to reflect the current state of the model.
 * <>
 * Board stores the model as a field and acts as both the Controller
 * and the View.
 */
public class Board extends JPanel {

    private boolean playing = false; // whether the game is running
    private int totalScore;

    // Game constants.
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    private static final int BRICK_WIDTH = 50;
    private static final int BRICK_HEIGHT = 20;
    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_HEIGHT = 20;
    private static final int BALL_RADIUS = 20;
    private static final int LIVES = 3;
    public static final int ROWS = 4;
    public static final int COL = 10;

    private JLabel scoreLabel, livesLabel, levelLabel, timeLabel;
    private JButton instructionsButton;

    private Ball ball;
    private Paddle paddle;
    private Brick[][] bricks;

    private int score;
    private int lives;
    private int level;

    private boolean isPaused;
    private Map<String, Integer> highScores;

    private JLabel status; // current status text

    public Board() {

        // Set the board.
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        // Initialize the game state.
        ball = new Ball(WINDOW_WIDTH / 2 - BALL_RADIUS / 2, WINDOW_HEIGHT - 100 - BALL_RADIUS, BALL_RADIUS);
        paddle = new Paddle(WINDOW_WIDTH / 2 - PADDLE_WIDTH / 2, WINDOW_HEIGHT - PADDLE_HEIGHT - 10, PADDLE_WIDTH, PADDLE_HEIGHT);
        bricks = new Brick[5][10];
        this.score = 0;
        this.lives = LIVES;
        this.level = 1;
        highScores = new TreeMap<>();

        // Add mouse listeners.
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                paddle.setX(e.getX() - PADDLE_WIDTH / 2);
            }
        });
    }

    /**
     * Draws the current state of the game on the game panel.
     *
     * @param g the Graphics object to draw on
     */
    private void drawGame(Graphics g) {
        // Background.
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Draw bricks
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (!brick.isDestroyed()) {
                    brick.draw(g);
                }
            }
        }

        // Draw ball.
        ball.draw(g);
        // Draw paddle
        g.setColor(Color.WHITE);
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());

        // Draw game status
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Lives: " + lives, 10, 40);
        g.drawString("Level: " + level, 10, 60);
    }

    /**
     * @param g the <code>Graphics</code> object to protect
     */
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        // Status Panel.
//        JPanel statusPanel = new JPanel(new GridLayout(1, 5));
//        scoreLabel = new JLabel("Score: " + totalScore);
//        scoreLabel.setForeground(Color.WHITE);
//        livesLabel = new JLabel("Lives: " + this.lives);
//        livesLabel.setForeground(Color.WHITE);
//        levelLabel = new JLabel("Level: " + this.level);
//        levelLabel.setForeground(Color.WHITE);
//        timeLabel = new JLabel("Time: + " + this.timer.toString());
//        timeLabel.setForeground(Color.WHITE);
//        statusPanel.add(scoreLabel);
//        statusPanel.add(livesLabel);
//        statusPanel.add(levelLabel);
//        statusPanel.add(timeLabel);
//        add(statusPanel, BorderLayout.NORTH);
//
//        // Draw the game objects.
//        ball.draw(g);
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw paddle
        g.setColor(Color.GREEN);
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());

        // Draw ball
        g.setColor(Color.YELLOW);
        g.fillOval((int) ball.getXPos(), (int) ball.getYPos(), 20, 20);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (paddle.getX() + (PADDLE_WIDTH / 2) >=  WINDOW_WIDTH) {
                paddle.setX(WINDOW_WIDTH - (PADDLE_WIDTH / 2));
            }
            paddle.moveRight();
        } else {

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        }
    }

}