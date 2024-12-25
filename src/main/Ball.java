package org.cis1200.Brickbreaker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Represents the Ball on the game board.
 * <>
 * Stores the Ball's position and dimensions.
 * <>
 * Provides methods to
 */
public class Ball {

    // Balls' instance variables.
    private int xPos, yPos, xVel, yVel;
    private final int radius;

    /**
     * Constructor to create a Brick:
     */
    public Ball(int x, int y, int radius) {
        this.xPos = x;
        this.yPos = y;
        this.radius = radius;
        this.xVel = 1;
        this.yVel = -1;
    }

    /**
     * @return the x-cord of the Balls' position.
     */
    public double getXPos() {
        return xPos;
    }

    /**
     * @return the y-cord of the Balls' position.
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * @return the x-velocity of the Ball.
     */
    public int getXVel() {
        return xVel;
    }

    /**
     * @return the y-velocity of the Ball.
     */
    public int getYVel() {
        return yVel;
    }

    /**
     * @return the radius of the Ball.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param xPos new x-cord to set the Ball.
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @param yPos new y-cord to set the Ball.
     */
    public void setYPos(int yPos) {
        this.yPos = xPos;
    }

    /**
     * @param xVel new x-velocity to set the Ball.
     */
    public void setXVel(int xVel) {
        this.xVel = xVel;
    }

    /**
     * @param yVel new y-velocity to set the Ball.
     */
    public void setYVel(int yVel) {
        this.yVel = yVel;
    }

    /**
     *
     */
    public void reverseYDirection() {
        yVel *= -1;
    }

    /**
     *
     */
    public void move() {
        xPos += xVel;
        yPos += yVel;

        if (xPos < radius) {
            setXVel(1);
        }
        if (xPos > Board.WINDOW_WIDTH - radius) {
            setXVel(-1);
        }
        if (yPos < radius) {
            reverseYDirection();
        }
    }

    public void reset(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = 1;
        this.yVel = -1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(xPos, yPos, radius * 2, radius * 2);
    }

}
