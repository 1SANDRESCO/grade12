/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit4.pt;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class Fractal1 extends JPanel{
    
    public static final int FRAME_LENGTH = 800;
    public static final int START_LOC = 100;
    public static int width = 500;
    
    public Fractal1 (){
        
    }
    
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fractalize(g);
        //drawCircle(Color.yellow, START_LOC, START_LOC, width, g);
           
    }
     
    public void fractalize(Graphics g){
    int i = 0;
    int xLoc = START_LOC;
    int yLoc = START_LOC;
    Color c = Color.yellow;
    while (width > 1){
        switch (i) {
            case 0: c = Color.BLUE;
                break;
            case 1: c = Color.CYAN;
                break;
            case 2: c = Color.RED;
                break;
            case 3: c = Color.ORANGE;
                break;
            case 4: c = Color.GREEN;
                break;
            case 5: c = Color.pink;
                break;
            case 6: c = Color.LIGHT_GRAY;
                break;
            case 7: c = Color.BLACK;
                break;    
        } 
        drawCircle(c,xLoc, yLoc, width, g );
//        drawCircle(c,yLoc / 3, xLoc / 3, width, g );
//        drawCircle(c,yLoc / 9, xLoc / 9, width, g );
//        drawCircle(c,yLoc * 2, xLoc * 2, width, g );
//        drawCircle(c,yLoc * 4, xLoc * 2, width, g );
//        drawCircle(c,xLoc * 3, xLoc * 7, width, g );
        i++;
        xLoc += 5;
        yLoc += 5;
        width = (int) (width * 4 / 5);
        if (i == 7){
            i = 0;
        }
        //fractalize(g);
        
    }    
    
       
    } 
     
    public void drawCircle(Color colour, int topLeftX, int topLeftY, int width, Graphics g){
    g.setColor(colour);
    g.fillOval(topLeftX, topLeftY, width, width);
    } 
    
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(FRAME_LENGTH, FRAME_LENGTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Scott Sandre First Fractal");
        window.setVisible(true);
        window.setResizable(false);
        
        Fractal1 fractal = new Fractal1();
        
        window.add(fractal);

    }
    
}
