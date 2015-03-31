/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import hsa.Console;
import java.awt.Color;

public class BounceBall {

    private int radius;
    private Color ballC;
    private int speed;
    private double direction; //angle
    private int xLoc, yLoc;
    private Console console;
    public static final int GAP = 20;
    public static final int DELAY = 10;

    public BounceBall(int radius, int speed, Color c, Console cons) {
        this.console = cons;
        this.xLoc = console.maxx() / 2;
        this.yLoc = console.maxy() / 2;
        this.radius = radius;
        this.speed = speed;
        this.ballC = c;
        this.direction = Math.random() * 2 * Math.PI;
        drawBall();
        //moveBall();
    }

    public void delay() {
        try {
            Thread.sleep(DELAY);
        } catch (Exception e) {

        }
    }

    public void drawBall() {
        console.setColor(this.ballC);
        console.fillOval(xLoc, yLoc, radius, radius);
        moveBall();
    }

    public void eraseBall() {
        console.setColor(Color.WHITE);
        console.fillOval(xLoc, yLoc, radius, radius);
    }

    public void moveBall() {
        delay();
        eraseBall();
        if (yLoc >= console.maxy() - GAP) {//bottom
            //System.out.println("BOTTOM");
            makeRandomDirection(1); //bottom
        } else if (xLoc <= GAP) {
            //System.out.println("LEFT SIDE");
            makeRandomDirection(2);
        } else if (yLoc <= GAP) {
            //System.out.println("TOP");
            makeRandomDirection(3);
        } else if (xLoc >= console.maxx() - GAP) {
            //System.out.println("RIGHT");
            makeRandomDirection(3);
        }
        checkIfInCorner();
        if (direction == 2 || direction == 4) {
            xLoc = xLoc + (int) (this.speed * Math.cos(direction));
            //System.out.println("x change by " + (int) (this.speed * Math.cos(direction)));
            yLoc = yLoc + (int) (this.speed * Math.sin(direction));
            //System.out.println("y change by " + (int) (this.speed * Math.sin(direction)));
        } else {
            xLoc = xLoc - (int) (this.speed * Math.cos(direction));
            //System.out.println("x change by " + (int) (this.speed * Math.cos(direction)));
            yLoc = yLoc - (int) (this.speed * Math.sin(direction));
            //System.out.println("y change by " + (int) (this.speed * Math.sin(direction)));
        }

        drawBall();

    }
    
    public void checkIfInCorner(){
        if (xLoc< 0 || xLoc > console.maxx() || yLoc < 0 || yLoc > console.maxy()){
            this.xLoc = console.maxx() / 2;
            this.yLoc = console.maxy() / 2;
        }
    }

    public void makeRandomDirection(int x) {
        switch (x) {
            case 1://bottom, bouncing up ish
                direction = Math.random() * Math.PI;
                break;
            case 2://left, bouncing right ish
                direction = Math.random() * Math.PI - Math.PI / 2;
                break;
            case 3://top, bouncing down ish
                direction = -1 * Math.random() * Math.PI;
                break;
            case 4://bottom, bouncing up ish
                direction = Math.random() * Math.PI + Math.PI / 2;
                break;
        }
    }
}
