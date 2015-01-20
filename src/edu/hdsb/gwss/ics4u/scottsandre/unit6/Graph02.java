/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;


import static edu.hdsb.gwss.ics4u.scottsandre.unit6.Graph01.CENTRE_XY;
import static edu.hdsb.gwss.ics4u.scottsandre.unit6.Graph01.PIXELS_PER_UNIT;
import static edu.hdsb.gwss.ics4u.scottsandre.unit6.Graph01.SIZE;
import static edu.hdsb.gwss.ics4u.scottsandre.unit6.Graph01.SPACING;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Scott
 */
public class Graph02 extends JPanel{
    public static final int SIZE = 600;
    Scanner input = new Scanner (System.in);
    
    public Graph02(){
        
    }
    
    public void paintComponent(Graphics g) {
        drawGrid(g);
    getInput(g);  
    
    }
    
     public void getInput(Graphics g){
        double a, b;
        int choice;
        String trigR = "";
        
        System.out.println("Enter polar equation in form r = a [___(b Q)]");
        System.out.print("Enter a: ");
        a = Double.parseDouble(input.nextLine());
       
        System.out.println("1 for ____ = sin");
        System.out.println("2 for ____ = cos");
        System.out.println("3 for ____ = tan");
        System.out.println("0 for no trig ratio");
        System.out.println("Triginometric Choice is: ");
        choice = Integer.parseInt(input.nextLine());
        
        switch (choice){
            case 1: trigR = "sin";
                break;
            case 2: trigR = "cos";
                break;
            case 3: trigR = "tan";
                break;
            
        }
        System.out.print("Enter b: ");
        b = Double.parseDouble(input.nextLine());
        
        System.out.println("Therefore r = " + a + "*" + trigR + "(" + b + "Q )");
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
    
    public static void main(String[] args)  {
        JFrame window = new JFrame();
        window.setSize(SIZE, SIZE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Graph02 Scott Sandre");
        window.setVisible(true);
        window.setResizable(false);
        Graph02 graph = new Graph02();

        window.add(graph);
    }
    
   
    
    
    
}
