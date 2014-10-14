/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit2;

import java.awt.Color;

/**
 *
 * @author Owner
 */
public class Ghost extends PacmanCharacter {

    public static int BODY_HEIGHT = 60;
    public static int HEAD_RADIUS = 40;
    public static int BODY_WIDTH = 2 * HEAD_RADIUS;
    public static int EYE_RADIUS = 12;
    //private int orientation;
    private Color colour;
    private String name;
    

    public Ghost() {

    }

    public Ghost(String name, boolean alive, boolean killable, Color colour, int xLoc, int yLoc) {
        super(alive, xLoc, yLoc, killable);
        this.colour = colour;
        this.name = name;
        this.draw();
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

    

}
