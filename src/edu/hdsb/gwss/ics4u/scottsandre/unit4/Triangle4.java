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
public class Triangle4 extends JPanel {

    public static final int FRAME_LENGTH = 800;
    public static final int START_SIDE_LENGTH = 380;
    public static final int SMALLEST_LENGTH = 4;
    //public static int length = 500;
    public static int height;
    public static int i = 0;
    public static Color c;

    public Triangle4() {

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
        g.setColor(Color.black);
        height = (int) (Math.sqrt(Math.pow(length, 2) - Math.pow(length / 2, 2)));
        g.drawLine(topX, topY, topX - length / 2, topY + height);
        g.drawLine(topX, topY, topX + length / 2, topY + height);
        g.drawLine(topX + length / 2, topY + height, topX - length / 2, topY + height);
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

        Triangle4 triangle = new Triangle4();

        window.add(triangle);

    }
}
