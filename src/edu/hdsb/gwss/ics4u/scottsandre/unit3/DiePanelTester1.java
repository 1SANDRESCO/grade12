/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit3;

import java.awt.Color;

/**
 *
 * @author Owner
 */
public class DiePanelTester1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DiePanel die1 = new DiePanel();
        System.out.println(die1.getValue());
        //die1.paintComponent(a);
        System.out.println("Create die1, pass no parameters.");
        System.out.println("Die 1 : Get x: " + die1.getTopLeftX());
        System.out.println("Die 1 : Get y: " + die1.getTopLeftY());
        System.out.println("Die 1 : Get colour: " + die1.getColour());
        System.out.println("Die 1 : Get size Factor: " + die1.getSizeFactor());

        System.out.println("Create die2, pass parameters.");
        DiePanel die2 = new DiePanel(6, 200, 200, 3, Color.BLACK, Color.white);
        System.out.println("die 2 to string");
        System.out.println(die2.toString());

        System.out.println("Set die2 values");
        System.out.println("Set value to 99...Before: value = " + die2.getValue());
        die2.setValue(99);
        System.out.println("Set value to 99...After: value = " + die2.getValue());
        System.out.println();

        System.out.println("Set value to 4...Before: value = " + die2.getValue());
        die2.setValue(4);
        System.out.println("Set value to 4...After: value = " + die2.getValue());
        System.out.println();

        System.out.println("Set xLoc to -40...Before: value = " + die2.getTopLeftX());
        die2.setTopLeftX(-40);
        System.out.println("Set xLoc to -40...After: value = " + die2.getTopLeftX());
        System.out.println();

        System.out.println("Set xLoc to 100...Before: value = " + die2.getTopLeftX());
        die2.setTopLeftX(100);
        System.out.println("Set xLoc to 100...After: value = " + die2.getTopLeftX());
        System.out.println();
        
        System.out.println("Set yLoc to 144...Before: value = " + die2.getTopLeftY());
        die2.setTopLeftY(144);
        System.out.println("Set yLoc to 144...After: value = " + die2.getTopLeftY());
        System.out.println();

        System.out.println("Set size Factor to -10...Before: value = " + die2.getSizeFactor());
        die2.setSizeFactor(-10);
        System.out.println("Set size Factor to -10...After: value = " + die2.getSizeFactor());
        System.out.println();

        System.out.println("Set size Factor to 2...Before: value = " + die2.getSizeFactor());
        die2.setSizeFactor(2);
        System.out.println("Set size Factor to 2...After: value = " + die2.getSizeFactor());
        System.out.println();

        System.out.println("Set colour to green....Before colour: " + die2.getColour());
        die2.setColour(Color.green);
        System.out.println("Set colour pass it null....After colour: " + die2.getColour());
        System.out.println();

        System.out.println("Set colour pass it null....Before colour: " + die2.getColour());
        die2.setColour(null);
        System.out.println("Set colour pass it null....After colour: " + die2.getColour());
        System.out.println();
        
        System.out.println("Set Position to 122, 133 ...Before: X value = " + die2.getTopLeftX() + " Y value = " + die2.getTopLeftY());
        die2.setPosition(122, 133);
        System.out.println("Set Position to 122, 133 ...After: X value = " + die2.getTopLeftX() + " Y value = " + die2.getTopLeftY());
        System.out.println();
        
        

    }

}
