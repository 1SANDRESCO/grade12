/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
/**
 *
 * @author Owner
 */
public class DuetSpinner2 extends JPanel {
    public static JFrame window = new JFrame();
    public static final int WINDOW_SIZE = 700;
    public static final int DELAY = 1000;
    public static final int SIZE_FACTOR = 1;
    public static final int WIDTH = 100 * SIZE_FACTOR;
    public static final int HALF_W = WIDTH / 2;
    public static final int HEIGHT = 20;
    public static final int HALF_H = HEIGHT / 2;
//    public static int[] xData = new int[2];
//    public static int[] yData = new int[2];
    public static final int CENTRE_X = 300;
    public static final int CENTRE_Y = 300;
    public static Polygon p = new Polygon();
    public static int x = CENTRE_X - HALF_W;// left
    public static int y = CENTRE_Y;//
    public static int xx = CENTRE_X + HALF_W;//right
    public static int yy = CENTRE_Y;
    public static boolean doOnce = true;

    int xLoc = 200;
    int yLoc = 200;

    public static int xShift = 0;
    public static boolean xSB = true;//going right
    public static int yShift = 0;

    public DuetSpinner2() {

        System.out.println("test2");
    }

    @Override
    public void paintComponent(Graphics g) {
        //g.drawLine(x, y, xx, yy);
        //g.setColor(Color.black);
        
        //drawBar(g);
        
        
        
        for (int i = 0; i < 20; i++) {
            rotateLineC();
            drawBar(g);
            
            delay();
            window.update(g);
            erase(g);
            
        }
    }
    
    public void erase(Graphics g){
    g.setColor(Color.white);
        g.drawLine(x, y, xx, yy);
        //window.update(g);
    }

    public void drawBar(Graphics g) {
        System.out.println("test");
        g.setColor(Color.black);
        g.drawLine(x, y, xx, yy);
        //window.update(g);
        
        
        

//        p.addPoint(CENTRE_X - HALF_W + x, CENTRE_Y + HALF_H - y);//bottom left
//        p.addPoint(CENTRE_X + HALF_W - xx, CENTRE_Y + HALF_H + yy);//bottom right
//        p.addPoint(CENTRE_X + HALF_W - x, CENTRE_Y - HALF_H + y);//top right
//        p.addPoint(CENTRE_X - HALF_W + xx, CENTRE_Y - HALF_H + yy);//top left
//        p.addPoint(xLoc, yLoc);//bottom left
//        p.addPoint(xLoc + WIDTH, yLoc);//bottom right
//        p.addPoint(xLoc + WIDTH, yLoc - HEIGHT);//top right
//        p.addPoint(xLoc, yLoc - HEIGHT);//top left
        //g.fillPolygon(p);
    }
    public void delay() {
        try {
            Thread.sleep(DELAY);
        } catch (Exception e) {

        }
    }

    public static void rotateLineC() {
        if (xSB == true) {// going right
            x++;
            xx--;
        } else {
            x--;
            xx++;
        }
        if (x == WIDTH) {
            xSB = false;//going left now
        } else if (x == 0) {
            xSB = true;
        }
        
        
        
        
        //System.out.println(xShift);

    }

    public static void main(String[] args) {

        
        window.setSize(WINDOW_SIZE, WINDOW_SIZE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Duet v2");
        window.setVisible(true);
        window.setResizable(false);

        DuetSpinner2 s = new DuetSpinner2();
        window.add(s);
        
        
//        for (int i = 0; i < 300; i++) {
//            rotateLineC();
//        }

    }

}
