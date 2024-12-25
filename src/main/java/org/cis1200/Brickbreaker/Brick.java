package org.cis1200.Brickbreaker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Represents a single Brick object on the game board.
 * <>
 * Stores the Brick's position, width, height, color, score
 * and the number of hits required to destroy it.
 * <>
 * Provides methods to decrease the number of hits, and
 * check weather the brock is destroyed.
 */
public class Brick {

    // Brick's instance variables.
    private int x, y;
    private final int width, height;
    private Color color;
    private int score;

    // times the player must hit the Brick to destroy it.
    private int hitsRemaining;

    /**
     * Constructor to create a Brick:
     * Sets the score of the brick - 100 points each number
     * of hits needed to be destroyed.
     * Sets the brick dimensions to default.
     */
    public Brick(int x, int y, Color color, int hitsRemaining) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 20;
        this.color = color;
        this.hitsRemaining = hitsRemaining;
        this.score = 100 * hitsRemaining;
    }

    /**
     * @return the x-cord of the Brick's position.
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y-cord of the Brick's position.
     */
    public int getY() {
        return y;
    }

    /**
     * @return the width of the Brick.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height of the Brick.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the color of the Brick.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the Brick.
     * <>
     * @param color the color to set.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return true if the Brick has no remaining hits
     *          to be destroyed, and false otherwise.
     */
    public boolean isDestroyed() {
        return this.hitsRemaining <= 0;
    }

    /**
     * Decrease the number of hits of the Brick by 1.
     */
    public void decreaseHits() {
        hitsRemaining--;
    }

    /**
     * @return the amount of point that the player gets
     *          when destroying the Brick.
     */
    public int getScore() {
        return score;
    }

    /**
     * public boolean collide.
     */
    public boolean collide(Ball ball) {
        return ball.getXPos() >= x &&
                ball.getXPos() <= x + width &&
                ball.getYPos() >= y &&
                ball.getYPos() <= y + height;
    }

    /**
     *
     */
    public void draw(Graphics g) {

        g.setColor(this.color);
        g.fillRect(x, y, 50, 20);

        // If the Brick has more than 1 hits to be destroyed,
        // write the remaining hits in its center.
        if (hitsRemaining > 1) {
            int centerX = x + 25;
            int centerY = y + 10;
            g.setColor(Color.BLACK);
            String hitsText = String.valueOf(hitsRemaining);
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(hitsText);
            int textHeight = fm.getHeight();
            int textX = centerX - textWidth / 2;
            int textY = centerY + textHeight / 2;
            g.drawString(hitsText, textX, textY);
        }
    }

}
