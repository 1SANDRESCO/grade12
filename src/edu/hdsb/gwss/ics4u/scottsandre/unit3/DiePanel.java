/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit3;

import java.awt.Color;
import java.awt.Graphics;
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
    public static final int EXTRA_DIE = 3;
    private int value;
    private Color colour;
    private int sizeFactor;
    private int topLeftX;
    private int topLeftY;
    private int pixel;
    private int circleDiameter;
    private Color dotColour;

    public DiePanel() {//empty constructor
        this((int) (Math.random() * MAX_VALUE) + 1, DEFAULT_XY, DEFAULT_XY, 1, DEFAULT_COLOUR.red, Color.white);
    }

    public DiePanel(int value, int xLoc, int yLoc, int sizeFactor, Color colour, Color dotColour) {//everything
        if (value >= MIN_VALUE && value <= MAX_VALUE + EXTRA_DIE) {//7 is blank, 8 is question mark, 9 is circle 
            this.value = value;
        }
        this.topLeftX = xLoc;
        this.topLeftY = yLoc;
        this.sizeFactor = sizeFactor;
        this.colour = colour;
        this.pixel = SIZE_CONSTANT / 10 * this.sizeFactor;
        this.circleDiameter = 2 * pixel;
        this.dotColour = dotColour;
        System.out.println("Die Created!");
    }

    public DiePanel(int xLoc, int yLoc, int sizeFactor, Color colour, Color dotColour) {//everything BESIDES VALUE
        this.value = (int) (Math.random() * MAX_VALUE) + 1;
        this.topLeftX = xLoc;
        this.topLeftY = yLoc;
        this.sizeFactor = sizeFactor;
        this.colour = colour;
        this.pixel = SIZE_CONSTANT / 10 * this.sizeFactor;
        this.circleDiameter = 2 * pixel;
        this.dotColour = dotColour;
        System.out.println("Die Created!");
    }

    public void setValue(int value) {
        if (value >= MIN_VALUE && value <= MAX_VALUE + EXTRA_DIE) {//blank, question mark
            System.out.println("setValue: value set to " + value);
            this.value = value;
        } else {
            System.out.println("value not valid");

        }
    }

    public void setColour(Color colour) {
        if (colour != null){
        this.colour = colour;
        } else {
            System.out.println("Colour cannot be null");
        }
    }
    
    public void setPosition(int x, int y){
        setTopLeftX(x);
        setTopLeftY(y);
    }

    public void setSizeFactor(int sizeFactor) {
        if (sizeFactor > 0) {
            System.out.println("setSizeFactor: sizefactor set to " + sizeFactor);
            this.sizeFactor = sizeFactor;
        } else {
            System.out.println("Size Factor not valid");
        }
    }

    public void setTopLeftX(int topLeftX) {
        if (topLeftX >= 0) { 
            System.out.println("setTopLeftX: xValue set to " + topLeftX);
            this.topLeftX = topLeftX;
        } else {
            System.out.println("X value not valid");
        }
    }

    public void setTopLeftY(int topLeftY) {
        if (topLeftY >= 0) { // && topLeftY < MAX_Y - (SIZE_CONSTANT * sizeFactor
            System.out.println("setTopLeftX: xValue set to " + topLeftY);
            this.topLeftY = topLeftY;
        } else {
            System.out.println("X value not valid");
        }
    }

    @Override
    public String toString() {
        return "Die{" + "value=" + value + ", colour=" + colour + ", sizeFactor=" + sizeFactor + ", topLeftX=" + topLeftX + ", topLeftY=" + topLeftY + '}';
    }

    public void assignRandomValue() {
        this.value = (int) (Math.random() * MAX_VALUE) + 1;
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

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }

    public int getCircleDiameter() {
        return circleDiameter;
    }

    public void setCircleDiameter(int circleDiameter) {
        this.circleDiameter = circleDiameter;
    }

    public Color getDotColour() {
        return dotColour;
    }

    public void setDotColour(Color dotColour) {
        this.dotColour = dotColour;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDie(g);
        drawValue(g);
    }

    private void dot(Graphics g, int row, int col) {
        this.pixel = SIZE_CONSTANT / 10 * this.sizeFactor;
        this.circleDiameter = 2 * pixel;
        g.setColor(this.dotColour);
        int y = this.topLeftY + (row * 3 * this.pixel) - 2 * this.pixel;
        int x = this.topLeftX + (col * 3 * this.pixel) - 2 * this.pixel;
        g.fillOval(x, y, this.circleDiameter, this.circleDiameter);
    }

    private void drawDie(Graphics g) {
        g.setColor(this.getColour());//BOX
        g.fillRect(this.topLeftX, this.topLeftY, this.sizeFactor * SIZE_CONSTANT, this.sizeFactor * SIZE_CONSTANT);

    }

    private void drawValue(Graphics g) {
         this.pixel = SIZE_CONSTANT / 10 * this.sizeFactor;
        if (this.getValue() <= 6) {
            if (this.getValue() != 1) { // 2 3 4 5 6
                dot(g, 1, 1); //top Left
                dot(g, 3, 3); // bottom right
            }
            if (this.getValue() % 2 == 1) {//odd number // 1 3 5
                dot(g, 2, 2); // midle
            }
            if (this.getValue() > 3) { // 4 5 6
                dot(g, 1, 3);//top right
                dot(g, 3, 1);//bottom left
            }
            if (this.getValue() == 6) { // 6
                dot(g, 2, 1);//middle left
                dot(g, 2, 3);//middle right
            }
        }//value == 7 == BLANK
        else if (this.getValue() == 8) {//question mark     
            g.setColor(Color.yellow);
            g.fillRect(this.topLeftX + (this.sizeFactor * SIZE_CONSTANT) / 2 - pixel / 2, this.topLeftY - pixel / 2 - pixel + (this.sizeFactor * SIZE_CONSTANT) - 5 * pixel, pixel, 4 * pixel);
            g.fillRect(this.topLeftX + (this.sizeFactor * SIZE_CONSTANT) / 2 - pixel / 2, this.topLeftY - pixel / 2 + (this.sizeFactor * SIZE_CONSTANT) - 6 * pixel, pixel * 3, pixel);
            g.fillRect(this.topLeftX + (this.sizeFactor * SIZE_CONSTANT) / 2 - 2 * pixel, this.topLeftY - pixel / 2 + pixel, pixel * 4, pixel);
            g.fillRect(this.topLeftX + (this.sizeFactor * SIZE_CONSTANT) / 2 - pixel / 2 + pixel * 2, this.topLeftY - pixel / 2 + pixel, pixel, pixel * 4);
            g.fillRect(this.topLeftX + (this.sizeFactor * SIZE_CONSTANT) / 2 - pixel / 2, this.topLeftY + 8 * pixel + pixel / 2, pixel, pixel);
        } else if (this.getValue() == 9) {
            g.setColor(Color.white);
            g.fillOval(this.topLeftX + (int) 2.8 * pixel, this.topLeftY + (int) 2.7  * pixel, pixel * 6 , pixel * 5);
        }

    }

}
