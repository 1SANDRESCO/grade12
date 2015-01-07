/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.random;

import hsa.Console;
import java.awt.event.KeyEvent;

/**
 *
 * @author Owner
 */


public class DuetSpinner extends Console{
    protected static Console c;
    int xLoc = 100;
    int yLoc = 100;
    
    public DuetSpinner() {
        c.fillRect(xLoc, yLoc, 10, 40);
    }
    
        public DuetSpinner (Console console) {
        
//        if (c == null) {
//            c = console;
//            System.out.println("hsa Console has been set.");
//        }
      //  c = console;
        //c.fillRect(xLoc, yLoc, 40, 40);
    }

    public static void main(String[] args) {
        c = new Console();
        DuetSpinner d = new DuetSpinner();
        
    }
    
    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        switch (keyPressed) {

            case KeyEvent.VK_UP://w is up
                System.out.println("UP");
                            
                break;

            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                                
                break;
        }
    }
}
