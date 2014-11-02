/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit4;

import static edu.hdsb.gwss.ics4u.scottsandre.unit4.SierpinskiTriangle.FRAME_LENGTH;
import static edu.hdsb.gwss.ics4u.scottsandre.unit4.SierpinskiTriangle.sideLength;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class SierpinskiTriangle2 extends JPanel{
    public static final int FRAME_LENGTH = 850;
    public static int sideLength = 500;
    int height;
    int xDifference;
   
    
    public SierpinskiTriangle2(){
        
    }
    
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fractal (350, 50 , g);
    }
    
    public void fractal(int topX, int topY, Graphics g){
     
    if (sideLength <= 150){
        xDifference = (int) (0.5 * sideLength);
        height =  (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((xDifference), 2)))); 
       drawTriangle(topX, topY, g);
       drawTriangle(topX - xDifference, topY + height, g);
       drawTriangle(topX + xDifference, topY + height, g);

    }
    else {
      
        sideLength = (int) (sideLength * 0.5);
        xDifference = (int) (0.5 * sideLength);
        height =  (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((xDifference), 2))));
        
        
        fractal(topX, topY, g);
        
        fractal(topX - xDifference, topY + height, g);
        
       // fractal(topX + xDifference, topY + height, g);
      
    }
    }
    
     public void drawTriangle(int topX, int topY, Graphics g){
    g.setColor(Color.black);
    g.drawLine(topX, topY, topX - xDifference, topY + height);
    g.drawLine(topX, topY, topX + xDifference, topY + height);
    g.drawLine(topX - xDifference, topY + height, topX + xDifference, topY + height);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(FRAME_LENGTH, FRAME_LENGTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Sierpinski Triangle");
        window.setVisible(true);
        window.setResizable(true);
        
        SierpinskiTriangle2 triangle = new SierpinskiTriangle2();
        
        window.add(triangle);

    }
}
