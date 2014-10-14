/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit2;

import java.awt.Color;

/**
 *
 * @author Owner
 */
public class Pacman extends PacmanCharacter {
    public static final boolean SHAPE_CIRCLE = true;
    public static int PAC_RADIUS = 40;
    public static int START_LIVES = 3;
    public static int START_KILLS = 0;
    public static int START_COINS = 0;
    public static int START_ORIENTATION = 4;
    private int numberKills;
    private int numberCoins;
    private int numberLivesLeft;
   // private int orientation;
    private boolean killable;

    public Pacman() {
        setNumberLives(START_LIVES);
        setNumberKills(START_KILLS);
        setRadius(PAC_RADIUS);
        setCircular(SHAPE_CIRCLE);
    }

    public Pacman(boolean alive, int xLoc, int yLoc, boolean killable) {
        super(alive, xLoc, yLoc, killable);
        setNumberLives(START_LIVES);//was not able to call this(); as both this() and super () must be first statement in constructor
        setNumberKills(START_KILLS);
        setRadius(PAC_RADIUS);
        setCircular(SHAPE_CIRCLE);
        this.draw(START_ORIENTATION);
    }

    public void setRadius() {
        setRadius(PAC_RADIUS);
    }

    private void setNumberLives(int lives) {
        this.numberLivesLeft = lives;
    }

    public void decreaseNumberLives() {
        if (this.killable == false || this.isAlive() == false) {
            if (this.killable == false) {
                System.out.println("decreaseNumberLives: Pacman is not killable.");
            }
            if (this.isAlive() == false) {
                System.out.println("decreaseNumberLives: Pacman is dead, cannot be killed.");
            }
        } else {
            System.out.println("decreaseNumberLives: Pacman's number of lives has been reduced by 1.");
            this.numberLivesLeft--;
        }

    }

    public void increaseNumberKills() {
        System.out.println("Number of kills has been increased.");
        this.numberKills++;
    }

    private void setNumberKills(int kills) {
        this.numberKills = kills;
    }

//    private void setOrientation() {
//        this.orientation = this.getDirection();
//    }

    public void setNumberCoins() {
        this.numberCoins = START_COINS;
    }

//    public int getOrientation() {
//        return orientation;
//    }

    public int getNumberLives() {
        return numberLivesLeft;
    }

    public int getNumberCoins() {
        return numberCoins;
    }

    public int getNumberKills() {
        return numberKills;
    }
    
    @Override
    public void draw(){
        draw(this.getDirection());
    }

    public void draw(int direction) {
        c.setColor(Color.yellow);
        switch (direction) {
            //left
            case 1:
                c.fillArc(this.getXLoc(), this.getYLoc(), PAC_RADIUS, PAC_RADIUS, 210, 300);

                break;
            //right
            case 2:
                c.fillArc(this.getXLoc(), this.getYLoc(), PAC_RADIUS, PAC_RADIUS, 30, 300);
                break;
            //up
            case 3:
                c.fillArc(this.getXLoc(), this.getYLoc(), PAC_RADIUS, PAC_RADIUS, 120, 300);
                break;
            //down
            case 4:
                c.fillArc(this.getXLoc(), this.getYLoc(), PAC_RADIUS, PAC_RADIUS, 300, 300);

                break;
        }
    }

    @Override
    public String toString() {
        return "Pacman{" + "numberKills=" + numberKills + ", numberCoins=" + numberCoins + ", numberLivesLeft=" + numberLivesLeft + ", orientation=" + this.getDirection() + ", radius= " + PAC_RADIUS + '}';
    }

}
