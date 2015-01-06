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
public class ImproperFraction extends Fraction {

    public ImproperFraction() {
        super();

    }

    public ImproperFraction(int numerator, int denominator) {
        super(numerator, denominator);
        if (this.getNumerator() < this.getDenominator()) {
            System.out.println("Oh no! You made a 'improper fraction' but it is actually an PRoper fraction.");
            //System.out.println("Making it into an PRoper fraction now...");
        } 

    }
    
    public MixedFraction toMixed(){
        MixedFraction newOne;
        int x = this.getNumerator() / this.getDenominator();//whole number
        int y = this.getNumerator() - ( x * this.getDenominator());//new numerator
        newOne = new MixedFraction(y, this.getDenominator(), x);
        System.out.println("Improper converted to mixed.");
        System.out.println("Num: " + y + " Denom: " + this.getDenominator() + " whole: " + x);
        return newOne;
        
        
    }
    
    

}
