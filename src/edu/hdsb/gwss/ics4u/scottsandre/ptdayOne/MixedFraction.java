/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.ptdayOne;

/**
 *
 * @author Scott
 */
public class MixedFraction extends Fraction {
    private int wholeNumber = 0;
    public MixedFraction(){
        super();
        
    }
    
    public MixedFraction(int num, int denom, int whole){
        super(num, denom);
        this.setWholeNumber(whole);
        super.checkNegatives();
        if (num > denom){
            System.out.println(this.toString() + "...this is not a mixed fraction. I am now going to fix your mistake...");
            fixFraction();
        }
        
        if (this.getNumerator() < 0){
            this.setNumerator(this.getNumerator()* -1);
            this.setWholeNumber(this.getWholeNumber() * -1);
        }
        
    }
    
    public void fixFraction(){
        int x = this.getNumerator() / this.getDenominator();
        this.setWholeNumber(this.getWholeNumber() + x);
        this.setNumerator(this.getNumerator() - x * this.getDenominator());
        System.out.println("new, fixed mixed fraction is: " + this.toString());
    }

    public int getWholeNumber() {
        return wholeNumber;
    }
    
    public void toImproper(){
        int x = this.getWholeNumber() * this.getDenominator();
        int y = this.getNumerator() + x;
        System.out.println(this.toString() + " becomes " + y + "/" + this.getDenominator());
    }

    public void setWholeNumber(int wholeNumber) {
        if (wholeNumber != 0){
        this.wholeNumber = wholeNumber;
        } else {
            this.wholeNumber = 0;
            System.out.println("This is not a mixed fraction as whole number is 0");
        }
    }

    @Override
    public String toString() {
        String s = wholeNumber + " and ";
        s += super.toString();
        return s;
        
    }
    
    
    
    
}
