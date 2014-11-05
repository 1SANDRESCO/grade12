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

    public static final int FRAME_LENGTH = 700;
    public static final int START_SIDE_LENGTH = 400;
    public static final int SMALLEST_R =10;
    public static int heightF;
    public static int widthF;
    public static int startR = 300;
    int i = 0;

 
    public static Color c;

    public Fractal2() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        heightF = this.getHeight();
        widthF = this.getWidth();
        //drawCircle(g, widthF / 2 - startR / 2, 30, startR);
        fractalize(g, widthF / 2 - startR / 2, heightF / 2 - startR / 2, startR);
    }
    
    public void fractalize(Graphics g, int topX, int topY, int r){
    if (r <= SMALLEST_R)return;
    draw(g, topX, topY, r);//center
    
    r = r/2;
    fractalize(g, topX + 2 * r, topY+ r / 2, r);//double right
    fractalize(g, topX - r, topY + r / 2, r);//double left
    fractalize(g, topX - r / 2, topY + r / 2, r);//left
    fractalize(g, topX + r * 6 / 4 , topY + r / 2, r);//right
    //fractalize(g, topX + r * 6 / 4 , topY - r / 2, r);//up and right
    fractalize(g, topX + r / 2 , topY - r / 2, r);//up
    fractalize(g, topX + r / 2 , topY - r , r);//double up
    fractalize(g, topX + r / 2 , topY + r * 6 / 4, r);//down
    fractalize(g, topX + r / 2 , topY + r * 2, r);//down double
    }

    public void draw(Graphics g, int topX, int topY, int r) {
    g.setColor(Color.blue);
    g.drawLine(topX + r / 2, topY - r/ 5, topX + r / 2, topY + 6 * r / 5);
    g.setColor(Color.DARK_GRAY);
    g.drawLine(topX, topY, topX + r, topY + r);
    g.drawLine(topX + r, topY, topX , topY + r );
    
    g.setColor(Color.LIGHT_GRAY);
    g.drawOval(topX, topY, r, r);
    
    
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(FRAME_LENGTH , FRAME_LENGTH );
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Sierpinski Triangle 4");
        window.setVisible(true);
        window.setResizable(true);

        Fractal2 fractal = new Fractal2();

        window.add(fractal);

    }
}
