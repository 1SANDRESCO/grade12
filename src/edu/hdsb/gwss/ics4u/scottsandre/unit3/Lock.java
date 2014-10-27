/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit3;

/**
 *
 * @author 1SANDRESCO
 */
public abstract class Lock {

    private int minValue;
    private int maxValue;
    private int numberDigits;
    private static int numberLocksCreated = 0;
    private String serialNumber;
    private boolean created;
    private int[] combo;
    private int digit01, digit02, digit03, digit04;
    private boolean digit01Revealed;
    private boolean digit02Revealed;
    private boolean digit03Revealed;
    private boolean open;
    
//    public Lock(){
//    this( 
//                (int) ( Math.random() * this.getMaxValue()+ 1 ), 
//                (int) ( Math.random() * MAX_VALUE + 1 ), 
//                (int) ( Math.random() * MAX_VALUE + 1 ) 
//                 
//        );     
//        
//    }
//    
//    public Lock(int digit01, int digit02, int digit03){
//        
//    }
    
    

    public void setCombo(int digit01, int digit02, int digit03) {
        // TODO
        this.digit01 = digit01;
        this.digit02 = digit02;
        this.digit03 = digit03;
        System.out.println("\tYour Combo: " + this.getCombo(3) + " | SN: " + this.serialNumber);
    }

    public void setCombo(int digit01, int digit02, int digit03, int digit04) {
        // TODO
        this.digit01 = digit01;
        this.digit02 = digit02;
        this.digit03 = digit03;
        this.digit04 = digit04;
        System.out.println("\tYour Combo: " + this.getCombo(4) + " | SN: " + this.serialNumber);
    }
    

    public String getCombo(int x) {
        if (x == 3) {
            if (this.getCreated()) {
                return this.digit01 + "-" + this.digit02 + "-" + this.digit03;
            } else {
                return "Lock not yet created";
            }
        } else if (x == 4) {
            if (this.getCreated()) {
                return this.digit01 + "-" + this.digit02 + "-" + this.digit03 + "-" + this.digit04;
            } else {
                return "Lock not yet created";
            }
        }
        return "Incorrect length of combo ";
     }
    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean getCreated() {
        return this.created;
    }

    public void setMinValue(int minValue) {
        if (minValue < 0) {
            System.out.println("setMinValue: Min Value too low");
        } else {
            this.minValue = minValue;
        }
    }

    public int getMinValue() {
        return this.minValue;
    }

    public void setMaxValue(int maxValue) {
        if (maxValue < 0) {
            System.out.println("setMaxValue: Max value too low");
        } else {
            this.maxValue = maxValue;
        }

    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public void setNumberDigits(int numberDigits) {
        if (numberDigits < 1) {
            System.out.println("number digits too few");
        } else {
            this.numberDigits = numberDigits;
        }
    }

    public int getNumberDigits() {
        return this.numberDigits;
    }

    public void setSerialNumber(String serialNumber) {
        if (serialNumber.length() != 9) {
            System.out.println("Serial Number length does not equal 9");
        } else {
            this.serialNumber = serialNumber;
        }
    }

    public void increaseNumberLocksCreated() {
        numberLocksCreated++;
    }

    public int getNumberLocksCreated() {
        return numberLocksCreated;
    }

}
