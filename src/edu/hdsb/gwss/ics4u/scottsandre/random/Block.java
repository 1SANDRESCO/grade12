/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import hsa.Console;
import java.awt.Color;

/**
 *
 * @author Scott
 */
public class Block {

    protected static Console c;
    private int blockSize;
    private Color blockColour;
    private int blockSpeed;
    private int blockX, blockY;
    private int direction;
    public static final int DELAY = 50;

    public Block(int blockX, int blockY, int blockSize, int blockSpeed, Color blockColour, int direction, Console xx) {
        this.c = xx;
        this.setBlockSize(blockSize);
        this.setBlockColour(blockColour);
        this.setBlockSpeed(blockSpeed);
        this.setBlockX(blockX);
        this.setBlockY(blockY);
        this.setDirection(direction);
        drawBlock();
    }

    public void delay() {
        try {
            Thread.sleep(DELAY);
        } catch (Exception e) {

        }
    }

    public void drawBlock() {
        c.setColor(blockColour);
        c.fillRect(blockX, blockY, blockSize, blockSize);

        delay();
        erase();
        switch (direction) {//1 up, 2 down, 3 left, 4 right
            case 1:
                this.blockY -= this.blockSpeed;
                break;
            case 2:
                this.blockY += this.blockSpeed;
                break;
            case 3:
                this.blockX -= this.blockSpeed;
                break;
            case 4:
                this.blockX += this.blockSpeed;
                break;
        }
        if (this.blockX < 0 || this.blockY > c.maxx() || this.blockY < 0 || this.blockY > c.maxy()) {
            erase();
            
            
        } else {
            drawBlock();
        }

    }

    public void erase() {
        c.setColor(Color.white);
        c.fillRect(blockX, blockY, blockSize, blockSize);

    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public Color getBlockColour() {
        return blockColour;
    }

    public void setBlockColour(Color blockColour) {
        this.blockColour = blockColour;
    }

    public int getBlockSpeed() {
        return blockSpeed;
    }

    public void setBlockSpeed(int blockSpeed) {
        this.blockSpeed = blockSpeed;
    }

    public int getBlockX() {
        return blockX;
    }

    public void setBlockX(int blockX) {
        this.blockX = blockX;
    }

    public int getBlockY() {
        return blockY;
    }

    public void setBlockY(int blockY) {
        this.blockY = blockY;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
