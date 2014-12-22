/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.random;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Owner
 */
public class DuetSpinner2 extends JPanel{
    public static final int WINDOW_SIZE = 700;
    public static final int WIDTH = 100;
    public static int[] xData = new int[2];
    public static int[] yData = new int[2];
    
    int xLoc = 200;
    int yLoc = 200;

    public void paintComponent(Graphics g) {
        
    }
    
    public void drawBar(Graphics g){
        //g.fillRect(xLoc, xLoc, xLoc, xLoc);
        xData = {4, 2};
        g.fillPolygon([xLoc, xLoc + WIDTH], [xLoc, xLoc + WIDTH], 4);
    }
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setSize(WINDOW_SIZE, WINDOW_SIZE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Duet v2");
        window.setVisible(true);
        window.setResizable(false);
           
    }
}
