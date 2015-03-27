/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

/**
 *
 * @author Owner
 */
import hsa.Console;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Spinner  extends Console{

    protected static Console c;
    private static int circleR = 30;
    private static final int SMALL_CIRCLE_R = 15;
    //private int lineLength;

    private static final int START_XY = 200;
    private static final int LINE_LENGTH = circleR * 3;
    private static final int HALF_L = LINE_LENGTH / 2;
    private static final int ROTATE_SPEED = 13;
    private static final double RADS_SPEED = ROTATE_SPEED * Math.PI / 180;
    private static final int SHIFT_SPEED = 20;
    private static final int SIDE = (int) Math.sqrt((2 * Math.pow(HALF_L, 2)) - (2 * HALF_L * HALF_L * Math.cos(RADS_SPEED)));

    private static double calculatedLength;
    private static int xLoc;
    private static int yLoc;
    private static double x2, x3, y2, y3;
    private static double angle = 0;
    private static double rads;

    private static double xChange, yChange;

    public Spinner() {

        xLoc = START_XY;
        yLoc = START_XY;
        x2 = xLoc - LINE_LENGTH;
        x3 = xLoc + LINE_LENGTH + circleR;
        y2 = yLoc + (int) (0.5 * circleR);
        y3 = yLoc + (int) (0.5 * circleR);
        System.out.println("SIDE: " + SIDE);
        System.out.println("RADS SPEED: " + RADS_SPEED);
        drawSpinner();
        playGame();

    }

    public void playGame(){
        //make block
        
        
    }
    public void makeBlock() {//size, colour, x, y, speed

    }

    public int getxLoc() {
        return xLoc;
    }

    private void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    private void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }
    //private static Console c;

    public void rotateCW() {
        erase();
        angle += ROTATE_SPEED;
        if (Math.abs(angle) == 180) {
            angle = 0;
        }
        rads = angle * Math.PI / 180.0;
        yChange = (Math.sin(rads) * (LINE_LENGTH + circleR / 2));
        xChange = (Math.cos(rads) * (LINE_LENGTH + circleR / 2));
        x2 = xLoc - xChange;
        x3 = xLoc + xChange + circleR;

        y2 = yLoc - yChange + circleR / 2;
        y3 = yLoc + yChange + circleR / 2;
        drawSpinner();

    }

    public void rotateCCW() {
        erase();
        angle -= ROTATE_SPEED;
        if (Math.abs(angle) == 180.0) {
            angle = 0;
        }
        rads = angle * Math.PI / 180;
        yChange = (Math.sin(rads) * LINE_LENGTH);
        xChange = (Math.cos(rads) * LINE_LENGTH);
        x2 = xLoc + xChange;
        x3 = xLoc - xChange + circleR;

        y2 = yLoc + yChange + circleR / 2;
        y3 = yLoc - yChange + circleR / 2;
        drawSpinner();

    }

    private void drawSpinner() {
        setColor(Color.BLACK);
        fillOval(xLoc, yLoc, circleR, circleR);
        setColor(Color.RED);
        drawLine((int) x2, (int) y2, (int) x3, (int) y3);
        setColor(Color.BLUE);
        fillOval((int) x2 - SMALL_CIRCLE_R / 2, (int) y2 - SMALL_CIRCLE_R / 2, SMALL_CIRCLE_R, SMALL_CIRCLE_R);
        fillOval((int) x3 - SMALL_CIRCLE_R / 2, (int) y3 - SMALL_CIRCLE_R / 2, SMALL_CIRCLE_R, SMALL_CIRCLE_R);

        System.out.println("Angle: " + angle);
    }

    public void erase() {
        setColor(Color.WHITE);
        fillOval(xLoc, yLoc, circleR, circleR);
        drawLine((int) x2, (int) y2, (int) x3, (int) y3);
        fillOval((int) x2 - SMALL_CIRCLE_R / 2, (int) y2 - SMALL_CIRCLE_R / 2, SMALL_CIRCLE_R, SMALL_CIRCLE_R);
        fillOval((int) x3 - SMALL_CIRCLE_R / 2, (int) y3 - SMALL_CIRCLE_R / 2, SMALL_CIRCLE_R, SMALL_CIRCLE_R);

    }

    public void moveLeft() {
        erase();
        xLoc = xLoc - SHIFT_SPEED;
        x2 = x2 - SHIFT_SPEED;
        x3 = x3 - SHIFT_SPEED;
        drawSpinner();

    }

    public void moveUp() {
        erase();
        yLoc = yLoc - SHIFT_SPEED;
        y2 = y2 - SHIFT_SPEED;
        y3 = y3 - SHIFT_SPEED;

        drawSpinner();
    }

    public void moveDown() {
        erase();
        yLoc = yLoc + SHIFT_SPEED;
        y2 = y2 + SHIFT_SPEED;
        y3 = y3 + SHIFT_SPEED;

        drawSpinner();
    }

    public void moveRight() {
        erase();
        xLoc = xLoc + SHIFT_SPEED;
        x2 = x2 + SHIFT_SPEED;
        x3 = x3 + SHIFT_SPEED;

        drawSpinner();
    }

    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        switch (keyPressed) {

            case KeyEvent.VK_UP://w is up
                System.out.println("UP");
                moveUp();
                break;

            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                moveLeft();
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                moveDown();
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                moveRight();
                break;

            case KeyEvent.VK_D:
                System.out.println("ROTATED CW");
                rotateCW();
                break;
            case KeyEvent.VK_A:
                System.out.println("ROTATED Counter CW");
                rotateCCW();
                break;

        }

    }

    public static void main(String[] args) {
        //makes spinner 
        Spinner s = new Spinner();
        Block b1 = new Block (300, 300, 50, 4, Color.red, 4, s);
    }

}
