/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit2;

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
        Pacman pacman9 = new Pacman(false, 400, 400, true);
        Ghost ghost1 = new Ghost("Scott", true, false, Color.red, 0, 0);
        Ghost ghost2 = new Ghost("Bob", true, false, Color.blue, 100, 170);
        Ghost ghost3 = new Ghost("Candy", true, false, Color.orange, 320, 100);
        Ghost ghost4 = new Ghost("Jiggy", true, false, Color.pink, 620, 460);
        System.out.println(ghost1.MAX_X);
        System.out.println(ghost1.MAX_Y);

        //Pacman test cases
        System.out.println("------------ Pacman Test Cases ------------ ");
        System.out.println();
        //Test Case 1: Create a pacman with good input
        System.out.println("Test Case 1: Create pacman, valid parameters to constructor");
        Pacman pacman = new Pacman(true, 300, 300, true);
        System.out.println();

        //Test Case 2: Pacman to string
        System.out.println("Test Case 2: Pacman toString method");
        System.out.println(pacman.toString());
        System.out.println("Therefore all of the getters work. No need to be annoying and check all of them too");
        System.out.println();

        //Test Case 3: pass invalid xLoc to constructor
        System.out.println("Test Case 3: Invalid xLoc of 1400 passed to constructor.");
        Pacman pacman2 = new Pacman(false, 1400, 200, true);
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
        System.out.println("Before: Pacman Direction: " + pacman.getDirection() + " (" + pacman.getOrientation() + ")");
        pacman.setDirection(4);
        System.out.println("After: Pacman Direction: " + pacman.getDirection() + " (" + pacman.getOrientation() + ")");
        System.out.println();

        //Test Case 10: Change direction, bad input
        System.out.println("Test Case 10: Change direction, NON valid input (pass value 55)");
        System.out.println("Before: Pacman Direction: " + pacman.getDirection() + " (" + pacman.getOrientation() + ")");
        pacman.setDirection(55);
        System.out.println("After: Pacman Direction: " + pacman.getDirection() + " (" + pacman.getOrientation() + ")");
        System.out.println();

        //Test Case 11: Make pacman not killable
        System.out.println("Test Case 11: Make pacman NOT killable and alive");
        System.out.println("Before: Pacman killable: " + pacman.getIsKillable());
        pacman.setKillable(false);
        System.out.println("After: Pacman Lives: " + pacman.getIsKillable());
        System.out.println();

        //Test Case 12: Make pacman killable
        System.out.println("Test Case 12: Make pacman  killable and alive");
        System.out.println("Before: Pacman killable: " + pacman.getIsKillable());
        pacman.setKillable(true);
        System.out.println("After: Pacman Lives: " + pacman.getIsKillable());
        System.out.println();

        //Test Case 13: Set number of lives
        System.out.println("Test Case 13: Set number of lives to 100");
        System.out.println("Before: Pacman Lives: " + pacman.getNumberLives());
        System.out.println(" setNumberLives method is private ");
        System.out.println();

        //Test Case 14: Reduce number of lives, NOT killable, alive
        System.out.println("Test Case 14: Reduce number of lives by 1 when pacman is NOT killable");
        pacman.setKillable(false);
        System.out.println("Before: Pacman Lives: " + pacman.getNumberLives());
        pacman.decreaseNumberLives();
        System.out.println("After: Pacman Lives: " + pacman.getNumberLives());
        System.out.println();

        //Test Case 15: Reduce number of lives, IS killable, alive
        System.out.println("Test Case 15: Reduce number of lives by 1 when pacman IS killable");
        System.out.println("Before: Pacman Lives: " + pacman.getNumberLives());
        pacman.setKillable(true);
        pacman.decreaseNumberLives();
        System.out.println("After: Pacman Lives: " + pacman.getNumberLives());
        System.out.println();

        //Test Case 16: Reduce number of lives, NOT killable, dead
        System.out.println("Test Case 16: Reduce number of lives by 1 when pacman NOT killable, dead");
        pacman.setIsAlive(false);
        pacman.setKillable(false);
        System.out.println("Before: Pacman Lives  -----: " + pacman.getNumberLives() + "----- Pacman alive: " + pacman.getIsAlive());
        pacman.decreaseNumberLives();
        System.out.println("After: Pacman Lives: " + pacman.getNumberLives());
        System.out.println();

        //Test Case 17: Reduce number of lives, IS killable, dead
        System.out.println("Test Case 17: Reduce number of lives by 1 when pacman IS killable, dead");
        pacman.setIsAlive(false);
        pacman.setKillable(true);
        System.out.println("Before: Pacman Lives: ----- " + pacman.getNumberLives() + "----- Pacman alive: " + pacman.getIsAlive());
        pacman.decreaseNumberLives();
        System.out.println("After: Pacman Lives: " + pacman.getNumberLives());
        System.out.println();

        //Test Case 18: Set number coins
        System.out.println("Test Case 18: Set number coins to 999");
        System.out.println("Before: Pacman number coins: " + pacman.getNumberCoins());
        System.out.println("setNumberCoins is private, cannot be accessed");
        System.out.println();

        //Test Case 19: Increase coins
        System.out.println("Test Case 19: Increase number coins");
        System.out.println("Before: Pacman number coins: " + pacman.getNumberCoins());
        pacman.increaseNumberCoins();
        System.out.println("After: Pacman number coins: " + pacman.getNumberCoins());
        System.out.println();

        //Test Case 20: Set number coins
        System.out.println("Test Case 20: Set number kills to 40");
        System.out.println("Before: Pacman number kills: " + pacman.getNumberKills());
        System.out.println("setNumberKills is private, cannot be accessed");
        System.out.println();

        //Test Case 21: Increase coins
        System.out.println("Test Case 21: Increase number kills");
        System.out.println("Before: Pacman number kills: " + pacman.getNumberKills());
        pacman.increaseNumberKills();
        System.out.println("After: Pacman number kills: " + pacman.getNumberKills());
        System.out.println();

        //Test Case 22: Draw alive pacman
        System.out.println("Test Case 22: Draw alive pacman (bottom right part of screen");
        Pacman pacman10 = new Pacman(true, 500, 420, false);
        System.out.println("X Loc: " + pacman10.getXLoc() + "Y Loc: " + pacman10.getYLoc());
        System.out.println();

        //Test Case 23: Draw dead pacman
        System.out.println("Test Case 23: Draw dead pacman (top right part of screen");
        Pacman pacman11 = new Pacman(false, 500, 70, false);
        System.out.println("X Loc: " + pacman11.getXLoc() + "Y Loc: " + pacman11.getYLoc());
        System.out.println();

        //Test Case 24: Erasealive pacman
        System.out.println("Test Case 24: Erase pacman (middle right side of screen)");
        Pacman pacman12 = new Pacman(true, 500, 300, true);
        pacman12.delay(1500);
        pacman12.erase();
        System.out.println("X Loc: " + pacman10.getXLoc() + "Y Loc: " + pacman10.getYLoc());
        System.out.println();

        //Test Case 25: Move pacman, do coins increase as it ?
        System.out.println("Test Case 25: Move pacman and see if coins increased. )");
        pacman.setIsAlive(true);
        System.out.println("Before: Pacman number coins: " + pacman.getNumberCoins());

        for (int i = 0; i < 500; i++) {
            a = (int) (Math.random() * 4) + 1;
            b = (int) (Math.random() * 4) + 1;
            d = (int) (Math.random() * 4) + 1;
            e = (int) (Math.random() * 4) + 1;
            f = (int) (Math.random() * 4) + 1;
            ghost1.move(a);
            ghost2.move(b);
            ghost3.move(d);
            ghost4.move(e);
            pacman.setDirection(f);
            pacman.move(f);
            pacman.checkIfMustBounce();
            ghost1.checkIfMustBounce();
            ghost2.checkIfMustBounce();
            ghost3.checkIfMustBounce();
            ghost4.checkIfMustBounce();
            ghost1.delay();

        }

        System.out.println("After: Pacman number coins: " + pacman.getNumberCoins());

        System.out.println("---------- Ghost Test Cases ---------");
        System.out.println();
        //Test Case Ghosts
        //Test Case 26: Create ghost with good input
        System.out.println("Test Case 26: Make new Ghost (green) w good Input ");
        Ghost ghost5 = new Ghost("GhostyBoi", true, false, Color.GREEN, 250, 250);
        System.out.println();
        //Test Case 26: Create ghost with good input
        System.out.println("Test Case 26: Make new Ghost (green) w good Input ");
        System.out.println("Note: The methods that call the super, like setx/y, make \n"
                + "dead/alive, make killable, already work. Because they each call the \n"
                + "super and don't override it,they are the same. No point in checking them\n"
                + "all again that's just time consuming and annoying.\n");
        System.out.println();

        //Test Case 27: Set name valid input
        System.out.println("Test Case 27: Set ghost name, valid input (not null)");
        System.out.println("Ghost 5 (green) Before name: " + ghost5.getName());
        ghost5.setName("TestTestTestTest");
        System.out.println("After name: " + ghost5.getName());
        System.out.println();

        //Test Case 28: Set name non valid input
        System.out.println("Test Case 28: Set ghost name, NON valid input ( null)");
        System.out.println("Ghost 5 (green) Before name: " + ghost5.getName());
        ghost5.setName(null);
        System.out.println("After name: " + ghost5.getName());
        System.out.println();

        //Test Case 29: Set colour valid input
        System.out.println("Test Case 29: Set ghost colour, valid colour");
        System.out.println("Ghost 5 (green) Before colour: " + ghost5.getColour());
        ghost5.setColour(Color.gray);
        System.out.println("After colour: " + ghost5.getColour());
        System.out.println();

        //Test Case 30: Draw ghost
        System.out.println("Test Case 30: Draw that new colour ghost");
        ghost5.delay(1500);
        ghost5.draw();
        System.out.println();

        //Test Case 31: Set colour NOT valid input
        System.out.println("Test Case 31: Set ghost colour, NON valid colour (pass it NULL)");
        System.out.println("Ghost 5 (green) Before colour: " + ghost5.getColour());
        ghost5.setColour(null);
        System.out.println("After colour: " + ghost5.getColour());
        System.out.println();

        //Test Case 32: toString
        System.out.println("Test Case 32: Ghost toString method");
        System.out.println(ghost5.toString());
        System.out.println();
        
        //Test Case 33: move
        System.out.println("Test Case 33: Can ghosts move");
        System.out.println("yes. You have already seen that ghosts and pacman can move.");
        System.out.println();
        
        //Test Case 34: erase
        System.out.println("Test Case 34: Erase all the ghosts");
        ghost1.erase();
        ghost2.erase();
        ghost3.erase();
        ghost4.erase();
        ghost5.erase();
        System.out.println();
        
        //Test Case 35: call empty constructor
        System.out.println("Test Case 35: create new ghost, empty constructor");
        Ghost ghost6 = new Ghost();

    }
}
