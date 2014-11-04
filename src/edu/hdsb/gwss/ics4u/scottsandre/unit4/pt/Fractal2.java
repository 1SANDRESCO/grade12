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
 * @author 1SANDRESCO
 */
public class Fractal2 extends JPanel {

    public static final int FRAME_LENGTH = 800;
    public static final int START_SIDE_LENGTH = 380;
    public static final int SMALLEST_LENGTH = 10;
    //public static int length = 500;
    public static int height;
    public static int i = 0;
    public static Color c;

    public Fractal2() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fractalize(g, FRAME_LENGTH / 2, 50, START_SIDE_LENGTH);

    }
    
    public void fractalize(Graphics g, int topX, int topY, int length){
        if (length <= SMALLEST_LENGTH){
            drawTriangle(g, topX, topY, length * 2);
        } else {
        int height = (int) (Math.sqrt(Math.pow(length, 2) - Math.pow(length / 2, 2)));
        fractalize(g, topX , topY , length / 2);
        fractalize(g, topX + length / 2, topY + height, length / 2);
        fractalize(g, topX - length / 2, topY + height, length / 2);
        }
    }

    public void drawTriangle(Graphics g, int topX, int topY, int length) {
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
        g.setColor(c);
        height = (int) (Math.sqrt(Math.pow(length, 2) - Math.pow(length / 2, 2)));
        g.drawLine(topX, topY, topX - length / 2, topY + height);
        g.drawLine(topX, topY, topX + length / 2, topY + height);
        g.drawLine(topX + length / 2, topY + height, topX - length / 2, topY + height);
        g.fillOval(topX, topY, length , length);
        g.drawLine(topX, topY, topX + length * 6, topY + length);
        g.drawLine(topX, topY, topX - 2 * length , topY +  4 *length);
        g.drawLine(topX, topY, topX - 5 * length , topY -  4 *length);
        i++;
        if (i == 7){
            i = 0;
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(FRAME_LENGTH, FRAME_LENGTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Sierpinski Triangle 4");
        window.setVisible(true);
        window.setResizable(false);

        Fractal2 fractal = new Fractal2();

        window.add(fractal);

    }
}
