package org.cis1200.Brickbreaker;

/**
 * The Paddle class represents the paddle in the Brick Breaker game.
 */
public class Paddle {

    private int x, y, width, height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
        if (this.x < 0) {
            this.x = 0;
        } else if (this.x > Board.WINDOW_WIDTH - width) {
            this.x = Board.WINDOW_WIDTH - width;
        }
    }
    public void moveLeft() {
        setX(x - 10);
    }
    public void moveRight() {
        setX(x + 10);
    }
    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean intersects(Ball ball) {
        return ball.getXPos() >= x &&
                ball.getXPos() <= x + width &&
                ball.getYPos() + ball.getRadius() >= y;
    }
}

