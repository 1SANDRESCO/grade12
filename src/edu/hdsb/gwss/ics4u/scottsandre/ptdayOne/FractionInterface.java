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
public interface FractionInterface {
    
    public Fraction larger(Fraction f);
    //public static Fraction larger(Fraction f, Fraction g);
    public Fraction times (Fraction f);
    public Fraction times (Fraction f, Fraction g);
    public void reduce();
    public String toString();
    public boolean equals();
    public int hashValue();
    public void invert();
    
}
