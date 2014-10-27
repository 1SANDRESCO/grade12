/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit3;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 1SANDRESCO
 */
public class DiePanelTester2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DiePanel die1 = new DiePanel();
        die1.setSizeFactor(6);
        die1.setColour(Color.blue);
        die1.setDotColour(Color.GREEN);
        
        DiePanel die2 = new DiePanel(350, 0, 2, Color.BLACK, Color.ORANGE);
        
        JFrame guiWindow = new JFrame("Die Panel Tester");
        guiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiWindow.setSize(800, 600);
        die1.setVisible(true);
        die2.setVisible(true);
        guiWindow.setVisible(true);
       // JPanel container = new JPanel();

//        container.add(die1);
//        container.add(die2);
//        container.setBounds(0, 0, 500, 500);
       // guiWindow.add(container);
        System.out.println(die1.getPixel());
        //JButton button1 = new JButton("Click here");
        //guiWindow.add(button1);
        

        guiWindow.add(die1);
        //guiWindow.add(die2);
        
        
//            
       
        
        
    }

}
