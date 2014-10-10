/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit2;

import java.awt.Color;
import hsa.Console;

/**
 *
 * @author Owner
 */
public class PacmanCharacter implements PacmanCharacterMovement{//don't forget max and mins of console boundaries

    private static Console c;

    private boolean alive;
    private final int DIRECTION_LEFT = 1;
    private final int DIRECTION_RIGHT = 2;
    private final int DIRECTION_UP = 3;
    private final int DIRECTION_DOWN = 4;
    private final int STEP_SIZE = 20;
    private int yLoc;
    private int xLoc;
    private int maxX;
    private int maxY;
    private int direction;
    private int radius;

    public PacmanCharacter() {
        if (c == null) {
            System.out.println("Warning: HSA console has not been set.");
        }
    }

    public PacmanCharacter(Console console) {
        this();
        if (c == null) {
            c = console;
            System.out.println("hsa Console has been set.");
        }
    }

    public PacmanCharacter(boolean alive, int xLoc, int yLoc) {
        this.alive = alive;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    public void setMaxHeight() {
        if (c != null) {
            this.maxY = c.getHeight();
        }

    }

    public void setRadius(int r) {
        this.radius = r;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getMaxHeight() {
        return maxY;
    }

    public int getMaxWidth() {
        return maxX;
    }

    public void setMaxWidth() {
        if (c != null) {
            this.maxX = c.getWidth();
        }
    }

    public boolean isIsAlive() {
        return alive;
    }

    public void setIsAlive(boolean isAlive) {
        this.alive = isAlive;
    }

    public int getXLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public void move() {
        switch (direction) {
            case DIRECTION_LEFT:
                moveLeft();
                break;
            case DIRECTION_RIGHT:
                moveRight();
                break;
            case DIRECTION_UP:
                moveUp();
                break;
            case DIRECTION_DOWN:
                moveDown();
                break;
        }

    }

    public void moveLeft() {
        this.erase();
        this.xLoc  = this.xLoc - STEP_SIZE;
        this.draw();
    }

    public void moveRight() {
        this.erase();
        this.xLoc  = this.xLoc + STEP_SIZE;
    }

    public void moveUp() {
        this.erase();
        this.xLoc  = this.yLoc + STEP_SIZE;
    }

    public void moveDown() {
        this.erase();
        this.xLoc  = this.yLoc - STEP_SIZE;   
    }

    private void draw() {
        
        
    }

    private void erase() {
    c.setColor(Color.white);
    c.drawOval(getXLoc(), getYLoc(), this.radius, this.radius);
    }

    public static void setConsole(Console hsaConsole) {
        c = hsaConsole;
    }

}
