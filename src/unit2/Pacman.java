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

    public static int PAC_RADIUS = 60;
    public static int EYE_RADIUS = (int) (PAC_RADIUS / 6);
    public static Color EYE_COLOUR = Color.black;
    public static int START_LIVES = 3;
    public static int START_KILLS = 0;
    public static int START_COINS = 0;
   
    public static int START_ORIENTATION = 1;
    public static boolean OPEN = true;
    private int numberKills;
    private int numberCoins;
    private int radius;
    private int numberLivesLeft;
    public int closedOrOpenCounter = 0;
    // private int orientation;
    private boolean killable;

    public Pacman() {
//        setNumberLives(START_LIVES);
//        setNumberKills(START_KILLS);
//        setRadius(PAC_RADIUS);
    }

    public Pacman(boolean alive, int xLoc, int yLoc, boolean killable) {
        
        super(alive, xLoc, yLoc, killable);
        System.out.println("Pacman has been created");
            setNumberLives(START_LIVES);//was not able to call this(); as both this() and super () must be first statement in constructor
            setNumberKills(START_KILLS);
            setRadius(PAC_RADIUS);
            this.draw(START_ORIENTATION, OPEN);
            
        

    }

    public void setRadius(int r) {
        if (r > 0) {
            this.radius = r;
        } else {
            System.out.println("Radius entered not valid");
        }

    }

    public int getRadius() {
        return this.radius;
    }

    private void setNumberLives(int lives) {
        this.numberLivesLeft = lives;
    }

    public void decreaseNumberLives() {
        if (this.getIsKillableBoolean() == false || this.getIsAlive() == false) {
            if (this.getIsKillableBoolean() == false) {
                System.out.println("decreaseNumberLives: Pacman is not killable.");
            }
            if (this.getIsAlive() == false) {
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
    
    public void increaseNumberCoins(){
        System.out.println("Number of coins has been increased by 1.");
        this.numberCoins++;
    }

    private void setNumberKills(int kills) {
        this.numberKills = kills;
    }

    public void setNumberCoins() {
        this.numberCoins = START_COINS;
    }

    public int getNumberLives() {
        return numberLivesLeft;
    }

    public int getNumberCoins() {
        return numberCoins;
    }

    public int getNumberKills() {
        return numberKills;
    }
    
    public String getOrientation(){
        switch (this.getDirection()){
            case DIRECTION_LEFT://pass the moveLeft and stuff methods the direction/orientation
                return "Left";
              
            case DIRECTION_RIGHT:
                return "Right";
              
            case DIRECTION_UP:
                return "Up";
              
            case DIRECTION_DOWN:
                return "Down";
        }
        return "xx";
    }
    

    @Override
    public void draw() {
        if (closedOrOpenCounter % 2 == 0) {
            draw(this.getDirection(), false);
        } else {
            draw(this.getDirection(), true);
        }
        if (closedOrOpenCounter == 500) {
            closedOrOpenCounter = 1;
        }
        increaseNumberCoins();
        closedOrOpenCounter++;
    }

    public void draw(int direction, boolean open) {
        c.setColor(Color.yellow);
        c.fillOval(this.getXLoc(), this.getYLoc(), this.radius, this.radius);
        
        
        switch (direction) {

            //left
            case DIRECTION_LEFT:

                if (open == OPEN) {
                    c.setColor(Color.white);
                    c.fillArc(this.getXLoc(), this.getYLoc(), PAC_RADIUS, PAC_RADIUS, 210, -60);
                }
                c.setColor(EYE_COLOUR);
                c.fillOval(this.getXLoc() + (int) (0.5 * PAC_RADIUS) - (int) (0.5 * EYE_RADIUS), this.getYLoc() + (int) (0.9 * EYE_RADIUS), EYE_RADIUS, EYE_RADIUS);

                break;
            //right
            case DIRECTION_RIGHT:

                if (open == OPEN) {
                    c.setColor(Color.white);
                    c.fillArc(this.getXLoc(), this.getYLoc(), PAC_RADIUS, PAC_RADIUS, 30, -60);
                }
                c.setColor(EYE_COLOUR);
                c.fillOval(this.getXLoc() + (int) (0.5 * PAC_RADIUS) - (int) (0.5 * EYE_RADIUS), this.getYLoc() + (int) (0.9 * EYE_RADIUS), EYE_RADIUS, EYE_RADIUS);
                break;
            //up
            case DIRECTION_UP:

                if (open == OPEN) {
                    c.setColor(Color.white);
                    c.fillArc(this.getXLoc(), this.getYLoc(), PAC_RADIUS, PAC_RADIUS, 120, -60);
                }
                c.setColor(EYE_COLOUR);
                c.fillOval(this.getXLoc() + (int) (0.75 * PAC_RADIUS) - (int) (0.5 * EYE_RADIUS), this.getYLoc() + (int) (0.5 * PAC_RADIUS) - (int) (0.5 * EYE_RADIUS), EYE_RADIUS, EYE_RADIUS);
                break;
            //down
            case DIRECTION_DOWN:

                if (open == OPEN) {
                    c.setColor(Color.white);
                    c.fillArc(this.getXLoc(), this.getYLoc(), PAC_RADIUS, PAC_RADIUS, 300, -60);
                }
                c.setColor(EYE_COLOUR);
                c.fillOval(this.getXLoc() + (int) (0.25 * PAC_RADIUS) - (int) (0.5 * EYE_RADIUS), this.getYLoc() + (int) (0.5 * PAC_RADIUS) - (int) (0.5 * EYE_RADIUS), EYE_RADIUS, EYE_RADIUS);
                break;
        }
    }

    public void erase() {
        c.setColor(Color.white);
        c.fillOval(this.getXLoc(), this.getYLoc(), this.radius, this.radius);
    }

    @Override
    public String toString() {
        return "Pacman{" + "numberKills=" + numberKills + ", numberCoins=" + numberCoins + ", numberLivesLeft=" 
        + numberLivesLeft + ", Orientation=" + this.getOrientation() + ", Y Location =" + this.getYLoc()+ ", X "
                + "Location=" + this.getXLoc() + ", Direction=" + this.getDirection() + " alive= " + this.getIsAlive() +" killable= " + this.getIsKillable() + " radius= " + PAC_RADIUS + '}';
    }

}
