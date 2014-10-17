/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author 1SANDRESCO
 */
public class DiePanel extends JPanel {

    public static final int SIZE_CONSTANT = 100;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 6;
    public static final int MAX_X = JPanel.WIDTH;
    public static final int MAX_Y = JPanel.HEIGHT;
    public static final int DEFAULT_XY = 0;
    public static final Color DEFAULT_COLOUR = Color.RED;
    private int value;
    private Color colour;
    private int sizeFactor;
    private int topLeftX;
    private int topLeftY;
    
    public DiePanel(){
     this((int) (Math.random() * MAX_VALUE) + 1, DEFAULT_XY, DEFAULT_XY, 1, DEFAULT_COLOUR.red );
    }
    
    public DiePanel(int value, int xLoc, int yLoc, int sizeFactor, Color colour){
    if (value >= MIN_VALUE && value <= MAX_VALUE) {
        this.value = value;
    }
    this.topLeftX = xLoc;
    this.topLeftY = yLoc;
    this.sizeFactor = sizeFactor;
    this.colour = colour;
    System.out.println("Die Created!");
    }

    public void setValue(int value) {
        if (value >= MIN_VALUE && value <= MAX_VALUE) {
            System.out.println("setValue: value set to " + value);
            this.value = value;
        } else {
            System.out.println("value not valid");

        }
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setSizeFactor(int sizeFactor) {
        if (sizeFactor > 0) {
            System.out.println("setSizeFactor: sizefactor set to " + sizeFactor);
            this.sizeFactor = sizeFactor;
        }else {
            System.out.println("Size Factor not valid");
        }
    }

    public void setTopLeftX(int topLeftX) {
        if (topLeftX >= 0 && topLeftX < MAX_X - (SIZE_CONSTANT * sizeFactor)) {
            System.out.println("setTopLeftX: xValue set to " + topLeftX);
            this.topLeftX = topLeftX;
        } else {
            System.out.println("X value not valid");
        }
    }

    public void setTopLeftY(int topLeftY) {
        if (topLeftY >= 0 && topLeftY < MAX_Y - (SIZE_CONSTANT * sizeFactor)) {
            System.out.println("setTopLeftX: xValue set to " + topLeftY);
            this.topLeftY = topLeftY;
        } else {
            System.out.println("X value not valid");
        }
    }

    public int getValue() {
        return value;
    }

    public Color getColour() {
        return colour;
    }

    public int getSizeFactor() {
        return sizeFactor;
    }

    public int getTopLeftX() {
        return topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }
    
    public void paintComponent(){
       
    }
    
    

}
