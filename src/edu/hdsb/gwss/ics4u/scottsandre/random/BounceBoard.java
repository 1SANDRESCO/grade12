/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import hsa.Console;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author Scott
 */
public class BounceBoard extends Console {

    private static int width;
    private static int height;

    private static Color boardColour;
    private static final int GAP_FROM_EDGE = 20;
    private static int xLoc, yLoc, speed, holder;
    private static final int MAX_X = 639;
    private static final int MAX_Y = 499;
    private static int location = 1;

    public BounceBoard(int w, int h, Color c, int x, int y, int s) {
        this.setWidth(w);
        this.setHeight(h);
        this.setColor(c);
        this.setxLoc(x);
        this.setyLoc(y);
        this.speed = s;
        drawBoard();

    }

    public void drawBoard() {
        System.out.println("TEST");
        setColor(boardColour);
        fillRect(xLoc, yLoc, width, height);
    }

    public void erase() {
        System.out.println("ERASE");
        setColor(Color.WHITE);
        fillRect(xLoc, yLoc, width, height);
    }

    public void eraseCorner(int z) {
        setColor(Color.WHITE);
        switch (z){
            case 1://bottom left
                System.out.println("CORNER " + z);
                fillRect(xLoc, yLoc, width*2, height);
                break;
            case 2://top left
                System.out.println("CORNER " + z);
                fillRect(xLoc, yLoc, width * 3, height * 2);
                break;
            case 4:
                fillRect(xLoc, yLoc - 2 * height, width * 3, height * 3);
                break;
        }
        
    }

    public void moveCW() {
        System.out.println(location);
        switch (location) {
            case 1: //bottom
                erase();
                xLoc -= speed;//move left
                drawBoard();
                if (xLoc < GAP_FROM_EDGE) {//DONE
                    eraseCorner(1);
                    yLoc -= height;
                    location = 2;
                    switchHeightWidth();
                } else if (xLoc + width > (MAX_X - GAP_FROM_EDGE)) {

                    location = 4;
                    switchHeightWidth();
                }
                break;
            case 2://left
                erase();
                yLoc -= speed;//move up
                drawBoard();
                if (yLoc < GAP_FROM_EDGE) {//DONE
                    eraseCorner(2);
                    yLoc += width;
                    location = 3;
                    switchHeightWidth();
                } else if (yLoc > MAX_Y - GAP_FROM_EDGE) {
                    location = 1;
                    switchHeightWidth();
                }
                break;
                
            case 3://top
                erase();
                xLoc += speed;//ove right
                drawBoard();
                if (xLoc < GAP_FROM_EDGE) { 
                    //yLoc += height;
                    location = 2;
                    switchHeightWidth();
                } else if (xLoc + width/2> (MAX_X - GAP_FROM_EDGE)) {
                    eraseCorner(1);//top right
                    
                    location = 4;
                    switchHeightWidth();
                }
                break;
            case 4://right
                erase();
                yLoc += speed;//move up
                drawBoard();
                if (yLoc < GAP_FROM_EDGE) {
                    eraseCorner(3);
                    yLoc += width;
                    location = 3;
                    switchHeightWidth();
                } else if (yLoc > MAX_Y - GAP_FROM_EDGE) {
                    eraseCorner(4);
                    yLoc -= width;
                    location = 1;
                    switchHeightWidth();
                }
                break;
        }

    }

    public void moveCCW() {
        System.out.println(location);
        switch (location) {
            case 1: //bottom
                erase();
                xLoc += speed;//move left
                drawBoard();
                if (xLoc < GAP_FROM_EDGE) {//DONE
                    eraseCorner(1);
                    yLoc -= height;
                    location = 2;
                    switchHeightWidth();
                } else if (xLoc + width/2 > (MAX_X - GAP_FROM_EDGE)) {
                    eraseCorner(2);
                    location = 4;
                    switchHeightWidth();
                }
                break;
            case 2://left
                erase();
                yLoc += speed;//move up
                drawBoard();
                if (yLoc < GAP_FROM_EDGE) {//DONE
                    eraseCorner(2);
                    yLoc += width;
                    location = 3;
                    switchHeightWidth();
                } else if (yLoc > MAX_Y - GAP_FROM_EDGE) {
                    location = 1;
                    switchHeightWidth();
                }
                break;
                
            case 3://top
                erase();
                xLoc -= speed;//ove right
                drawBoard();
                if (xLoc < GAP_FROM_EDGE) {
                    eraseCorner(2);
                    location = 2;
                    switchHeightWidth();
                } else if (xLoc + width/2> (MAX_X - GAP_FROM_EDGE)) {
                    eraseCorner(1);//top right
                    
                    location = 4;
                    switchHeightWidth();
                }
                break;
            case 4://right
                erase();
                yLoc -= speed;//move up
                drawBoard();
                if (yLoc < GAP_FROM_EDGE) {
                    eraseCorner(2);
                    yLoc += width;
                    location = 3;
                    switchHeightWidth();
                } else if (yLoc > MAX_Y - GAP_FROM_EDGE) {
                    eraseCorner(2);
                    yLoc -= width;
                    location = 1;
                    switchHeightWidth();
                }
                break;
        }

    }

    public void switchHeightWidth() {
        holder = this.height;
        this.height = this.width;
        this.width = holder;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public static Color getBoardColour() {
        return boardColour;
    }

    public void setBoardColour(Color c) {
        this.boardColour = c;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int x) {
        this.xLoc = x;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int y) {
        this.yLoc = y;
    }

    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        switch (keyPressed) {

            case KeyEvent.VK_LEFT:
                System.out.println("ClockWise");
                moveCW();
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("Counter ClockWise");
                moveCCW();
                break;

        }
    }

    public static void main(String[] args) {

        BounceBoard b = new BounceBoard(60, 15, Color.BLACK, MAX_X / 2, MAX_Y - GAP_FROM_EDGE, 12);
        System.out.println("Max X value" + b.maxx());
        System.out.println("Max y value" + b.maxy());

    }

}
