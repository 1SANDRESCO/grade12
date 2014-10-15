/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit2;

import hsa.Console;
import java.awt.Color;

/**
 *
 * @author Owner
 */
public class PacmanGameTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a, b, d, e, f;
        Console c = new Console();
        PacmanCharacter.setConsole(c);

        //Pacman pacman = new Pacman(true, 1200, 6000, true);
       // Pacman pacman2 = new Pacman (true, 300, 300, true);
//        Pacman pacman = new Pacman();
//        pacman.setIsAlive(true);
//        pacman.setKillable(true);
//        pacman.setxLoc(3000);
//        pacman.setyLoc(200);
        //pacman.erase();
      
        //pacman.erase();

//        System.out.println("direction: " + pacman.getDirection());
//        System.out.println(pacman.getRadius());
        

       // System.out.println(pacman.toString());
        
        Ghost ghost1 = new Ghost("Scott", true, false, Color.red, 0, 0);
        Ghost ghost2 = new Ghost("Bob", true, false, Color.blue, 100, 170);
        Ghost ghost3 = new Ghost("Candy", true, false, Color.orange, 320, 100);
        Ghost ghost4 = new Ghost("Jiggy", true, false, Color.pink, 620, 460);
        System.out.println(ghost1.MAX_X);
        System.out.println(ghost1.MAX_Y);
        
        //Pacman test cases
        //Test Case 1: Create a pacman with good input
        System.out.println("Test Case 1: Create pacman, valid parameters to constructor");
        Pacman pacman = new Pacman (true, 300, 300, true);
        System.out.println();
        
        //Test Case 2: Pacman to string
        System.out.println("Test Case 2: Pacman toString method");
        System.out.println(pacman.toString());
        System.out.println();
        
        //Test Case 3: pass invalid xLoc to constructor
        System.out.println("Test Case 3: Invalid xLoc of 1400 passed to constructor.");
        Pacman pacman2 = new Pacman(true, 1400, 200, true);
        System.out.println("X value is not 1400, it is: " + pacman2.getYLoc());
        System.out.println();
        
        //Test Case 4: pass invalid xLoc to constructor
        System.out.println("Test Case 4: Invalid xLoc of -777 passed to constructor.");
        Pacman pacman3 = new Pacman(true, -777, 200, true);
        System.out.println("X value is not -777, it is: " + pacman3.getYLoc());
        System.out.println();
        
        //Test Case 5: pass invalid yLoc to constructor
        System.out.println("Test Case 5: Invalid yLoc of 1666 passed to constructor.");
        Pacman pacman4 = new Pacman(true, 100, 1666, true);
        System.out.println("Y value is not 1666, it is: " + pacman4.getYLoc());
        System.out.println();
        
        //Test Case 6: pass invalid yLoc to constructor
        System.out.println("Test Case 6: Invalid yLoc of -333 passed to constructor.");
        Pacman pacman5 = new Pacman(true, 100, -333, true);
        System.out.println("Y value is not -333, it is: " + pacman4.getYLoc());
        System.out.println();
        
        //Test Case 7: make PacMan dead
        System.out.println("Test Case 7: Make pacman dead");
        System.out.println("Before: Pacman alive :" + pacman.getIsAlive());
        pacman.setIsAlive(false);
        System.out.println("After: Pacman alive :" + pacman.getIsAlive());
        System.out.println();
        
        //Test Case 8: make PacMan alive
        System.out.println("Test Case 8: Make pacman alive");
        System.out.println("Before: Pacman alive :" + pacman.getIsAlive());
        pacman.setIsAlive(true);
        System.out.println("After: Pacman alive :" + pacman.getIsAlive());
        System.out.println();
        
        //Test Case 9: Change direction, valid input
        System.out.println("Test Case 9: Change direction, valid input");
        System.out.println("Before: Pacman Direction: " + pacman.getDirection() + " (" + pacman.getOrientation() + ")" ) ;
        pacman.setDirection(4);
        System.out.println("After: Pacman Direction: " + pacman.getDirection() + " (" + pacman.getOrientation() + ")" ) ;
        System.out.println();
        
        //Test Case 10: Change direction, bad input
        System.out.println("Test Case 10: Change direction, NON valid input (pass value 55)");
        System.out.println("Before: Pacman Direction: " + pacman.getDirection() + " (" + pacman.getOrientation() + ")" ) ;
        pacman.setDirection(55);
        System.out.println("After: Pacman Direction: " + pacman.getDirection() + " (" + pacman.getOrientation() + ")" ) ;
        System.out.println();
        
        //Test Case 11: Make pacman not killable
        System.out.println("Test Case 11: Make pacman NOT killable and alive");
        System.out.println("Before: Pacman killable: " + pacman.getIsKillable()) ;
        pacman.setKillable(false);
        System.out.println("After: Pacman Lives: " + pacman.getIsKillable() ) ;
        System.out.println();
        
        //Test Case 12: Make pacman killable
        System.out.println("Test Case 12: Make pacman  killable and alive");
        System.out.println("Before: Pacman killable: " + pacman.getIsKillable()) ;
        pacman.setKillable(true);
        System.out.println("After: Pacman Lives: " + pacman.getIsKillable() ) ;
        System.out.println();
        
        //Test Case 13: Set number of lives
        System.out.println("Test Case 13: Set number of lives to 100");
        System.out.println("Before: Pacman Lives: " + pacman.getNumberLives() ) ;
        System.out.println(" setNumberLives method is private " ) ;
        System.out.println();
        
        //Test Case 14: Reduce number of lives, NOT killable
        System.out.println("Test Case 14: Reduce number of lives by 1 when pacman is NOT killable");
        pacman.setKillable(false);
        System.out.println("Before: Pacman Lives: " + pacman.getNumberLives() ) ;
        pacman.decreaseNumberLives();
        System.out.println("After: Pacman Lives: " + pacman.getNumberLives() ) ;
        System.out.println();
        
        //Test Case 15: Reduce number of lives, IS killable
        System.out.println("Test Case 15: Reduce number of lives by 1 when pacman IS killable");
        System.out.println("Before: Pacman Lives: " + pacman.getNumberLives() ) ;
        pacman.setKillable(true);
        pacman.decreaseNumberLives();
        System.out.println("After: Pacman Lives: " + pacman.getNumberLives() ) ;
        System.out.println();
        
        //Test Case 16: Reduce number of lives, IS killable
        System.out.println("Test Case 15: Reduce number of lives by 1 when pacman IS killable");
        System.out.println("Before: Pacman Lives: " + pacman.getNumberLives() ) ;
        pacman.setKillable(true);
        pacman.decreaseNumberLives();
        System.out.println("After: Pacman Lives: " + pacman.getNumberLives() ) ;
        System.out.println();
        
//       for (int i = 0; i < 10; i++){
//            a= (int) (Math.random() * 4 ) + 1;
//            b= (int) (Math.random() * 4 ) + 1;
//            d= (int) (Math.random() * 4 ) + 1;
//            e= (int) (Math.random() * 4 ) + 1;
//            f= (int) (Math.random() * 4 ) + 1;
//            ghost1.move(a);
//            ghost2.move(b);
//            ghost3.move(d);
//            ghost4.move(e);
//            pacman.setDirection(f);
//            pacman.move(f);
//            pacman.checkIfMustBounce();
//            ghost1.checkIfMustBounce();
//            ghost2.checkIfMustBounce();
//            ghost3.checkIfMustBounce();
//            ghost4.checkIfMustBounce();
//            ghost1.delay();
//        System.out.println(pacman.closedOrOpenCounter);
//        } 
//        
        

    }
}
