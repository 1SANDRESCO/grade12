///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.hdsb.gwss.ics4u.scottsandre.unit2;
//
//import java.awt.Color;
//import hsa.Console;
//
///**
// *
// * @author Owner
// */
//public abstract class PacmanCharacter implements PacmanCharacterMovement {//don't forget max and mins of console boundaries
//
//    protected static Console c;
//
//    
//    public final int MAX_X = 620;
//    public final int MAX_Y = 460;
//    public final int DIRECTION_LEFT = 1;
//    public final int DIRECTION_RIGHT = 2;
//    public final int DIRECTION_UP = 3;
//     public static int DEFAULT_XY = 300;
//    public final int DIRECTION_DOWN = 4;
//    public final int STEP_SIZE = 30;
//    public final int DELAY = 75;
//    //private int numberLives;
//    //private int numberKills;
//    private int yLoc;
//    private int xLoc;
//    private int direction;
//    private int width;
//    private int height;
//    private boolean killable;
//    public boolean alive;
//    //private boolean valid;
//
//    public PacmanCharacter() {
//        if (c == null) {
//            System.out.println("Warning: HSA console has not been set.");
//        }
//    }
//
//    public PacmanCharacter(Console console) {
//        this();
//        if (c == null) {
//            c = console;
//            System.out.println("hsa Console has been set.");
//        }
//    }
//
//    public PacmanCharacter(boolean alive, int xLoc, int yLoc, boolean killable) {
//        this.alive = alive;
//        if (xLoc < 0 || xLoc > MAX_X){
//            System.out.println("PacmanCharacter: xLoc of " + xLoc + " is not valid.");
//            this.xLoc = DEFAULT_XY;
//        } else {
//            this.xLoc = xLoc;
//        }
//        
//        if (yLoc < 0 || yLoc > MAX_Y){
//            System.out.println("PacmanCharacter: yLoc of " + yLoc + " is not valid.");
//            this.yLoc = DEFAULT_XY;
//        } else {
//            this.yLoc = yLoc;
//        }
//      
//        this.killable = killable;
//        this.direction = 1;
//    }
//
//    public void setKillable(boolean killable) {
//        if (killable){
//            System.out.println("setKillable: CAN be killed.");
//        } else {
//            System.out.println("setKillable: canNOT be killed."); 
//        }
//        this.killable = killable;
//    }
//
//    public String getIsKillable() {
//        if (this.killable){
//            return "Can be killed";
//        } else {
//            return "Cannot be killed";
//        }
//    }
//    
//    public boolean getIsKillableBoolean() {
//        if (this.killable){
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void setDirection(int direction) {
//        if (direction > 0 && direction < 5) {
//            this.direction = direction;
//        } else {
//            System.out.println("Direction entered of " + direction + " is not valid.");
//        }
//    }
//
//    public int getDirection() {
//     return direction;
//                
//       
//    }
//
//    public boolean getIsAlive() {
//        return alive;
//    }
//
//    public void setIsAlive(boolean isAlive) {
//        this.alive = isAlive;
//        if (this.alive){
//            System.out.println("setIsAlive: Pacman is alive");
//        } else {
//            System.out.println("setIsAlive: Pacman is dead");
//        }
//    }
//
//    public int getXLoc() {
//        return xLoc;
//    }
//
//    public void setxLoc(int xLoc) {
//        if (xLoc > 0 && xLoc < MAX_X) {
//            this.xLoc = xLoc;
//        } else {
//            System.out.println("X location entered not valid");
//        }
//    }
//
//    public int getYLoc() {
//        return yLoc;
//    }
//
//    public void setyLoc(int yLoc) {
//        if (yLoc > 0 && yLoc < MAX_Y) {
//            this.yLoc = yLoc;
//        } else {
//            System.out.println("Y location entered not valid");
//        }
//    }
//
//    public void move(int direction) {
//        switch (direction) {
//            case DIRECTION_LEFT://pass the moveLeft and stuff methods the direction/orientation
//                moveLeft();
//                break;
//            case DIRECTION_RIGHT:
//                moveRight();
//                break;
//            case DIRECTION_UP:
//                moveUp();
//                break;
//            case DIRECTION_DOWN:
//                moveDown();
//                break;
//        }
//
//    }
//
//    public void delay() {
//        try {
//            Thread.sleep(DELAY);
//        } catch (Exception e) {
//
//        }
//    }
//    
//     public void delay(int delayValue) {
//        try {
//            Thread.sleep(delayValue);
//        } catch (Exception e) {
//
//        }
//    }
//
//    public void moveLeft() {
//        this.erase();
//        this.xLoc = this.xLoc - STEP_SIZE;
//        this.draw();
//    }
//
//    public void moveRight() {
//        this.erase();
//        this.xLoc = this.xLoc + STEP_SIZE;
//        this.draw();
//    }
//
//    public void moveUp() {
//        this.erase();
//        this.yLoc = this.yLoc - STEP_SIZE;
//        this.draw();
//    }
//
//    public void moveDown() {
//        this.erase();
//        this.yLoc = this.yLoc + STEP_SIZE;
//        this.draw();
//    }
//
//    public void checkIfMustBounce() {
//        if (this.xLoc <= 0) {//left side
//            moveRight();
//            moveRight();
//            moveRight();
//        } else if (this.xLoc >= MAX_X) {//right side
//            moveLeft();
//            moveLeft();
//            moveLeft();
//        } else if (this.yLoc <= 0) {//top
//            moveDown();
//            moveDown();
//            moveDown();
//        } else if (this.yLoc >= MAX_Y) {//bottom
//            moveUp();
//            moveUp();
//            moveUp();
//        }
//    }
//
//    public void draw() {
//
//    }
//
//    public void erase() {
//    }
//
//    public static void setConsole(Console hsaConsole) {
//        c = hsaConsole;
//    }
//
//}
