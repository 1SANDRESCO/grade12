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
 * @author 1SANDRESCO
 */
public class SierpinskiTriangle extends JPanel {

    public static final int FRAME_LENGTH = 700;
    public static int sideLength = 500;

    public SierpinskiTriangle() {
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fractal (350, 50 , g);
    }
    
    public void fractal(int topX, int topY, Graphics g){
    if (sideLength < 10){
        drawTriangle(topX, topY, g);    
    } else {
    sideLength = (int) (sideLength * 0.5);
    fractal(topX, topY, g);
    fractal(topX - (int) (0.5 * sideLength), topY + (int) Math.sqrt(  (Math.pow(sideLength, 2)) - (Math.pow( (int) (0.5 * sideLength ), 2 )))    , g);
    fractal(topX + (int) (0.5 * sideLength), topY + (int) Math.sqrt(  (Math.pow(sideLength, 2)) - (Math.pow( (int) (0.5 * sideLength ), 2 )))    , g);
    }
    }
    
    public void drawTriangle(int topX, int topY, Graphics g){
    g.setColor(Color.black);
    g.drawLine(topX, topY, topX - (int) (0.5 * sideLength), topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((0.5 * topX), 2)))));
    g.drawLine(topX, topY, topX + (int) (0.5 * sideLength), topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((0.5 * topX), 2)))));
    g.drawLine(topX - (int) (0.5 * sideLength), topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((0.5 * topX), 2)))), topX + (int) (0.5 * sideLength), topY + (int) (Math.sqrt( (Math.pow(sideLength, 2)) - (Math.pow((0.5 * topX), 2)))));
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(FRAME_LENGTH, FRAME_LENGTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Sierpinski Triangle");
        window.setVisible(true);
        window.setResizable(false);
        
        SierpinskiTriangle triangle = new SierpinskiTriangle();
        
        window.add(triangle);

    }
}
