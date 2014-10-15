/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit2;

import java.awt.Color;

/**
 *
 * @author Owner
 */
public class Ghost extends PacmanCharacter {

    
    public static int HEAD_RADIUS = 30;
    public static int BODY_HEIGHT = (int) (HEAD_RADIUS * 0.8 );
    public static int BODY_WIDTH = HEAD_RADIUS;
    public static int EYE_RADIUS = 8;
    public static Color EYE = Color.black;
    //private int orientation;
    private Color colour;
    private String name;
    

    public Ghost() {
        super(true, DEFAULT_XY, DEFAULT_XY, true);
        this.colour = Color.CYAN;
        this.name = null;
        this.draw();
        System.out.println("Ghost with no name has been created.");
    }

    public Ghost(String name, boolean alive, boolean killable, Color colour, int xLoc, int yLoc) {
        super(alive, xLoc, yLoc, killable);
        this.colour = colour;
        this.name = name;
        this.draw();
        System.out.println("Ghost named: " + name + " has been created.");
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
            System.out.println("setName: Ghost's name set to: " + this.name);
        } else {
            System.out.println("setName: Ghost name not valid.");
        }
    }

    public void setColour(Color colour) {
        if (colour != null) {
            this.colour = colour;
        } else {
            System.out.println("setColour: Ghost colour cannot be null.");
        }
    }
    

    public Color getColour() {
        return colour;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Ghost{" + "colour=" + colour + ", Y Location =" + this.getYLoc() + ", X "
                + "Location=" + this.getXLoc() + " killable=" + this.getIsKillable() + " alive=" + this.getIsAlive() + ", name=" + name + '}';
    }
    
    
    
    public void draw(){
        c.setColor(this.colour);
        c.fillArc(this.getXLoc(), this.getYLoc(), HEAD_RADIUS, HEAD_RADIUS, 0, 180);
        c.fillRect(this.getXLoc(), this.getYLoc() + (int) (HEAD_RADIUS / 2) , BODY_WIDTH, BODY_HEIGHT); 
         c.setColor(EYE);
        c.fillOval(this.getXLoc() + (int) (0.5 * HEAD_RADIUS) - (int) (0.5 * EYE_RADIUS), this.getYLoc() + (int) (0.25 * HEAD_RADIUS), EYE_RADIUS, EYE_RADIUS);
    }
    
    public void erase(){
        c.setColor(Color.white);
         c.fillArc(this.getXLoc(), this.getYLoc(), HEAD_RADIUS, HEAD_RADIUS, 0, 180);
        c.fillRect(this.getXLoc(), this.getYLoc() + (int) (HEAD_RADIUS / 2) , BODY_WIDTH, BODY_HEIGHT); 
    }

    

}
