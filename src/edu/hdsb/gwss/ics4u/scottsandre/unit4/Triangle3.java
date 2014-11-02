/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit4;



import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class Triangle3 extends JPanel{
    public static int sideLength = 650;
    public static final int FRAME_LENGTH = 800;
    
    public Triangle3() {
    
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTriangle(FRAME_LENGTH / 2, 0, g);//draw largest triangle
        fractal(FRAME_LENGTH / 2, 0, g);
        
    }
    
    public void fractal(int topX, int topY, Graphics g){
    
    while (sideLength >= 10){
        sideLength = sideLength / 2;
        drawTriangle(topX, topY, g);
        drawTriangle(topX - sideLength / 2, topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((sideLength / 2), 2)))), g);
        drawTriangle(topX + sideLength / 2, topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((sideLength / 2), 2)))), g);   
    }    
    
    
    }
    
     public void drawTriangle(int topX, int topY, Graphics g){
    g.setColor(Color.red);
    g.drawLine(topX, topY, topX - sideLength / 2, topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow(sideLength / 2, 2)))));
    g.drawLine(topX, topY, topX + sideLength / 2, topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow(sideLength / 2, 2)))));
    g.drawLine(topX - sideLength / 2, topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow(sideLength / 2, 2)))), topX + (int) (sideLength / 2), topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((0.5 * sideLength), 2)))));
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(FRAME_LENGTH, FRAME_LENGTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Sierpinski Triangle 3");
        window.setVisible(true);
        window.setResizable(false);
        
        Triangle3 triangle = new Triangle3();
        
        window.add(triangle);

    }
}
