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
 * @author Scott
 */
public class Graph02 extends JPanel {

    public static final int SIZE = 600;
    public static final int CENTRE_XY = SIZE / 2;
    public static final int PIXELS_PER_UNIT = 60;
    public static final int SPACING = 20;
    public static final double STEP_SIZE_FOR_LOOP = 0.0625;
    public static final double X_RANGE = Math.PI * 4;
    public static JFrame window;
    Scanner input = new Scanner(System.in);

    public Graph02() {

    }

    public void paintComponent(Graphics g) {

        drawGrid(g);

        getInput(g);

    }

    public void getInput(Graphics g) {
        double a = 0;
        double b = 0;
        int choice = 0;
        boolean goodInput = false;
        String trigR = "";

        System.out.println("Enter polar equation in form r = a [___(b Q)]");
        do {
            System.out.print("Enter a: ");
            try {
                a = Double.parseDouble(input.nextLine());
                if (a != 0 && Math.abs(a) < 10) {
                    goodInput = true;
                } else {
                    System.out.println("a cannot equal 0 and must be less than (abs) 10");
                }
            } catch (NumberFormatException e) {
                System.out.println("a must be int or double, not string.");
            }
        } while (goodInput == false);

        System.out.println("1 for ____ = sin");
        System.out.println("2 for ____ = cos");
        System.out.println("3 for ____ = tan");
        System.out.println("0 for no trig ratio");
        System.out.print("Triginometric Choice is: ");

        goodInput = false;
        do {
            System.out.print("\nEnter trig ratio choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice >= 0 && choice <= 3) {
                    goodInput = true;
                } else {
                    System.out.println("not within range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("choice must be int or double, not string.");
            }
        } while (goodInput == false);

        switch (choice) {
            case 1:
                trigR = "sin";
                break;
            case 2:
                trigR = "cos";
                break;
            case 3:
                trigR = "tan";
                break;

        }

        goodInput = false;
        do {
            System.out.print("Enter b: ");
            try {
                b = Double.parseDouble(input.nextLine());
                if (b != 0 && Math.abs(b) < 10) {
                    goodInput = true;
                } else {
                    System.out.println("b cannot equal 0 and |b| must be less than 10");
                }
            } catch (NumberFormatException e) {
                System.out.println("a must be int or double, not string.");
            }
        } while (goodInput == false);

        System.out.print("Therefore r = ");
        if (a != 1) {
            System.out.print(a + "*");
        }
        System.out.print(trigR);
        if (b != 1) {
            System.out.print("(" + b + "Q)\n");
        } else {
            System.out.print(" Q \n");
        }
        System.out.println();
        plotFunction(a, b, choice, g);

    }

    public void plotFunction(double a, double b, int trig, Graphics g) {
        double x, x2, y, y2, r, r2, i2;
        g.setColor(Color.red);
        switch (trig) {
            case 1: // sin
                for (double i = -X_RANGE; i < X_RANGE; i = i + STEP_SIZE_FOR_LOOP) {
                    r = a * Math.sin(b * i);
                    x = r * Math.cos(i);
                    y = r * Math.sin(i);

                    i2 = i + STEP_SIZE_FOR_LOOP;
                    r2 = a * Math.sin(b * i2);
                    x2 = r2 * Math.cos(i2);
                    y2 = r2 * Math.sin(i2);
                    g.drawLine((int) (x * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y * PIXELS_PER_UNIT), (int) (x2 * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y2 * PIXELS_PER_UNIT));

                }
                break;
            case 2: //cos
                for (double i = -X_RANGE; i < X_RANGE; i = i + STEP_SIZE_FOR_LOOP) {
                    r = a * Math.cos(b * i);
                    x = r * Math.cos(i);
                    y = r * Math.sin(i);

                    i2 = i + STEP_SIZE_FOR_LOOP;
                    r2 = a * Math.cos(b * i2);
                    x2 = r2 * Math.cos(i2);
                    y2 = r2 * Math.sin(i2);
                    g.drawLine((int) (x * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y * PIXELS_PER_UNIT), (int) (x2 * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y2 * PIXELS_PER_UNIT));

                }
                break;
            case 3: //tan
                //for (double i = - Math.PI / 2; i < Math.PI / 2; i = i + STEP_SIZE_FOR_LOOP) {
                for (double i = -Math.PI / 2 + 0.01; i < Math.PI / 2 - 0.01; i = i + STEP_SIZE_FOR_LOOP) {
                    r = a * Math.tan(b * i);
                    x = r * Math.cos(i);
                    y = r * Math.sin(i);

                    i2 = i + STEP_SIZE_FOR_LOOP;
                    r2 = a * Math.tan(b * i2);
                    x2 = r2 * Math.cos(i2);
                    y2 = r2 * Math.sin(i2);
                    g.drawLine((int) (x * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y * PIXELS_PER_UNIT), (int) (x2 * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y2 * PIXELS_PER_UNIT));

                }
                ;
                break;
            case 0://no trig ratio

                for (double i = -X_RANGE; i < X_RANGE; i = i + STEP_SIZE_FOR_LOOP) {
                    r = a * (b * i);
                    x = r * Math.cos(i);
                    y = r * Math.sin(i);

                    i2 = i + STEP_SIZE_FOR_LOOP;
                    r2 = a * (b * i2);
                    x2 = r2 * Math.cos(i2);
                    y2 = r2 * Math.sin(i2);
                    g.drawLine((int) (x * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y * PIXELS_PER_UNIT), (int) (x2 * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y2 * PIXELS_PER_UNIT));
                    //g.fillOval( (int) (x * PIXELS_PER_UNIT + CENTRE_XY), (int) (CENTRE_XY - y * PIXELS_PER_UNIT), 4, 4);
                }
                ;
                break;
        }
        window.repaint();

    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(0, CENTRE_XY, SIZE, CENTRE_XY);
        g.drawLine(CENTRE_XY, 0, CENTRE_XY, SIZE);

        for (int i = 0; i < SIZE - SPACING; i += PIXELS_PER_UNIT) {
            g.drawLine(i, CENTRE_XY + 2, i, CENTRE_XY - 2);//horizontal
            g.drawLine(CENTRE_XY + 2, i, CENTRE_XY - 2, i);
        }

    }

    public static void main(String[] args) {
        window = new JFrame();
        window.setSize(SIZE, SIZE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Graph02 Scott Sandre");
        window.setVisible(true);
        window.setResizable(false);
        Graph02 graph = new Graph02();

        window.add(graph);

    }

}
