/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class Graph01 extends JPanel {

    public static final int SIZE = 800;
    public static final int SPACING = 20;
    public static final int CENTRE_XY = SIZE / 2;
    public static final double DOT_SPACING = 0.01;
    public static final int PIXELS_PER_UNIT = 10;
    public static final int DOT_SIZE = 4;
    public static boolean doOnce = true;
    public static final Scanner input = new Scanner(System.in);

    public Graph01() {

    }

    public void paintComponent(Graphics g) {
        if (doOnce) {
            drawGrid(g);
            getInput(g);
            doOnce = false;
        }
        
    }

    public int ensureGoodInput(String q, int l, int h) {
        boolean noError = true;
        int answer = -1;
        while (noError) {
            System.out.print(q);

            try {
                answer = Integer.parseInt((input.nextLine()));
                if (answer >= l && answer <= h) {
                    noError = false;
                } else {
                    System.out.println("Integer not within range. Lowest # can be " + l + " and highest is " + h);
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer, not letters or decimals. please");
            }

        }
        return answer;

    }

    public void getInput(Graphics g) {
        double m, a, b, c, d;
        System.out.println("Graph version 1.0");

        int f = ensureGoodInput("Enter 1 for linear, 2 for quadratic, for 3 cubic: ", 1, 3);
        if (f == 1) {
            System.out.println("y = mx + b");
            System.out.println("Enter value for x: ");
            m = Double.parseDouble(input.nextLine());
            System.out.println("Enter value for b: ");
            b = Double.parseDouble(input.nextLine());
            drawDots(m, b, g);

        } else if (f == 2) {
            System.out.println("y = ax^2 + bx + c");
            System.out.println("Enter value for a: ");
            a = Double.parseDouble(input.nextLine());
            System.out.println("Enter value for b: ");
            b = Double.parseDouble(input.nextLine());
            System.out.println("Enter value for c: ");
            c = Double.parseDouble(input.nextLine());
            drawDots(a, b, c, g);

        } else if (f == 3) {
            System.out.println("y = ax^3 + bx^2 + cx + d");

            a = ensureGoodInput("Enter value for a: ", -10, 10);
            b = ensureGoodInput("Enter value for b: ", -10, 10);
            c = ensureGoodInput("Enter value for c: ", -10, 10);
            d = ensureGoodInput("Enter value for d: ", -20, 20);

            drawDots(a, b, c, d, g);

        }
    }

    public void drawDots(double a, double b, double c, double d, Graphics g) {
        g.setColor(Color.red);
        for (double x = -100; x < 100; x = x + DOT_SPACING) {
            g.drawLine((int) (x * PIXELS_PER_UNIT) + CENTRE_XY - DOT_SIZE / 2, (int) (CENTRE_XY - (PIXELS_PER_UNIT * a * (Math.pow(x, 3))) - (PIXELS_PER_UNIT * b * (Math.pow(x, 2))) - (c * x * PIXELS_PER_UNIT) - (d * PIXELS_PER_UNIT) - DOT_SIZE / 2), (int) ((x + DOT_SPACING) * PIXELS_PER_UNIT) + CENTRE_XY - DOT_SIZE / 2, (int) (CENTRE_XY - (PIXELS_PER_UNIT * a * (Math.pow((x + DOT_SPACING), 3))) - (PIXELS_PER_UNIT * b * (Math.pow((x + DOT_SPACING), 2))) - (c * (x + DOT_SPACING) * PIXELS_PER_UNIT) - (d * PIXELS_PER_UNIT) - DOT_SIZE / 2));
            //g.fillOval((int) (x * PIXELS_PER_UNIT) + CENTRE_XY - DOT_SIZE / 2, (int) (CENTRE_XY - (PIXELS_PER_UNIT * a * (Math.pow(x, 3))) - (PIXELS_PER_UNIT * b * (Math.pow(x, 2))) - (c * x * PIXELS_PER_UNIT) - (d * PIXELS_PER_UNIT) - DOT_SIZE / 2), DOT_SIZE, DOT_SIZE);
        }
    }

    public void drawDots(double a, double b, double c, Graphics g) {//quadratic
        g.setColor(Color.red);
        for (double x = -100; x < 100; x = x + 0.1) {
            g.fillOval((int) (x * PIXELS_PER_UNIT) + CENTRE_XY - DOT_SIZE / 2, (int) (CENTRE_XY - (PIXELS_PER_UNIT * a * (Math.pow(x, 2))) - b * x * PIXELS_PER_UNIT - c * PIXELS_PER_UNIT) - DOT_SIZE / 2, DOT_SIZE, DOT_SIZE);
        }

        double xV = -1 * (b / (2 * a));
        double yV = a * Math.pow(xV, 2) + b * xV + c;
        double xInt1 = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        double xInt2 = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        System.out.println("The vertex is at ( " + xV + ", " + yV + " )");
        System.out.println("The roots are " + xInt1 + " and " + xInt2);

    }

    public void drawDots(double m, double b, Graphics g) {//lienar
        g.setColor(Color.red);
        for (double x = -100; x < 100; x = x + 0.5) {
            g.fillOval((int) (x * PIXELS_PER_UNIT) + CENTRE_XY - DOT_SIZE / 2, (int) (CENTRE_XY - (m * x * PIXELS_PER_UNIT) - b * PIXELS_PER_UNIT) - DOT_SIZE / 2, DOT_SIZE, DOT_SIZE);
        }

    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(SPACING, CENTRE_XY, SIZE - SPACING, CENTRE_XY);
        g.drawLine(CENTRE_XY, SPACING, CENTRE_XY, SIZE - 2 * SPACING);
        for (int i = 0; i < SIZE - 2 * SPACING; i++) {
            g.drawLine(i + SPACING, CENTRE_XY + 2, i + SPACING, CENTRE_XY - 2);
            g.drawLine(CENTRE_XY + 2, i + SPACING, CENTRE_XY - 2, i + SPACING);
            i += PIXELS_PER_UNIT - 1;//i increases by one each time anyways
        }

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(SIZE, SIZE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Graph01 Scott Sandre");
        window.setVisible(true);
        window.setResizable(false);
        Graph01 graph = new Graph01();

        window.add(graph);

    }

}
