/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 1SANDRESCO
 */
public class DiePanelTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Die die1 = new Die();
        JFrame guiWindow = new JFrame("Die Panel Tester");
        guiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiWindow.setSize(800, 600);
        guiWindow.setVisible(true);

        JLabel label1 = new JLabel("Test");
        JPanel panel1 = new JPanel();
        guiWindow.add(panel1);
        panel1.add(label1);
        
        
        JButton button1 = new JButton("Click here");
        guiWindow.add(button1);
        
    }

}
