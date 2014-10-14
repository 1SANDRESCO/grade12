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

        Pacman pacman = new Pacman(true, 1200, 6000, true);
       // Pacman pacman2 = new Pacman (true, 300, 300, true);
//        Pacman pacman = new Pacman();
//        pacman.setIsAlive(true);
//        pacman.setKillable(true);
//        pacman.setxLoc(3000);
//        pacman.setyLoc(200);
        //pacman.erase();
      
        //pacman.erase();
        pacman.decreaseNumberLives();
        pacman.decreaseNumberLives();
        pacman.decreaseNumberLives();
        pacman.decreaseNumberLives();
        pacman.increaseNumberKills();
        
        System.out.println("direction: " + pacman.getDirection());
        System.out.println(pacman.getRadius());
        

        System.out.println(pacman.toString());
        
        Ghost ghost1 = new Ghost("Scott", true, false, Color.red, 0, 0);
        Ghost ghost2 = new Ghost("Bob", true, false, Color.blue, 100, 170);
        Ghost ghost3 = new Ghost("Candy", true, false, Color.orange, 320, 100);
        Ghost ghost4 = new Ghost("Jiggy", true, false, Color.pink, 620, 460);
        System.out.println(ghost1.MAX_X);
        System.out.println(ghost1.MAX_Y);
        
        
//        for (int i = 0; i < 60; i++){
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
        
        

    }
}
