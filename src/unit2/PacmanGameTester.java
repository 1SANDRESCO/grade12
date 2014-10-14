/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit2;

import hsa.Console;

/**
 *
 * @author Owner
 */
public class PacmanGameTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Console c = new Console();
        PacmanCharacter.setConsole(c);

        Pacman pacman = new Pacman(true, 200, 200, true);
        pacman.erase(true);
        pacman.setDirection(2);
        pacman.draw();
        pacman.move(1);
        pacman.move(3);
        pacman.move(3);
        pacman.draw();
        pacman.decreaseNumberLives();
        pacman.increaseNumberKills();
        
        System.out.println("direction: " + pacman.getDirection());
        System.out.println(pacman.getRadius());
        

        System.out.println(pacman.toString());
        //pacman.erase();

    }
}
