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
public class ProperFraction extends Fraction{
    
    public ProperFraction(){
    super();
        
        
    }
    
    
    public ProperFraction(int numerator, int denominator) {
        super(numerator, denominator);
        if (this.getNumerator() >= this.getDenominator()) {
            System.out.println("Oh no! You made a 'proper fraction' but it is actually an IMproper fraction.");
            //sSystem.out.println("Making it into an improper fraction now...");
        }

    }
    
}
