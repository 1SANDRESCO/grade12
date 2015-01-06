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
public class Fraction implements FractionInterface{

    private int numerator = 0, denominator = 0;
    private static int smallNumber, largeNumber, divisorNumber;

    public Fraction(int numerator, int denominator) {
        this.setNumerator(numerator);
        this.setDenominator(denominator);
        checkNegatives();
    }

    public Fraction() {

    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double size() {//decimal value
        return ((double) numerator) / ((double) denominator);
    }

    @Override
    public Fraction larger(Fraction f) {
        if (this.size() >= f.size()) {
            return this;//this fraction is larger or both same
        } else {
            return f;//other fraction is larger
        }
    }
    @Override
    public Fraction larger(Fraction f, Fraction g) {
        if (f.size() >= g.size()) {
            return f; //either the same or f is bigger
        } else {
            return g;
        }
    }
    @Override
    public Fraction times(Fraction f) {
        Fraction newFraction = new Fraction();
        newFraction.setNumerator(this.getNumerator() * f.getNumerator());
        newFraction.setDenominator(this.getDenominator() * f.getDenominator());
        newFraction.reduce();
        return newFraction;
    }
    @Override
    public Fraction times(Fraction f, Fraction g) {
        Fraction newFraction = new Fraction();
        newFraction.setNumerator(g.getNumerator() * f.getNumerator());
        newFraction.setDenominator(g.getDenominator() * f.getDenominator());
        return newFraction;
    }
    @Override
    public void reduce() {
        if (this.getNumerator() < 0 && this.getDenominator() < 0) {
            this.setNumerator(this.getNumerator() * -1);//absolute value, both positive if both negative
            this.setDenominator(this.getDenominator() * -1);
        }
        sortNumbers(this.getNumerator(), this.getDenominator());
        divisorNumber = determineGreatestCommonDivisor(smallNumber, largeNumber);
        this.setNumerator(numerator / divisorNumber);
        this.setDenominator(denominator / divisorNumber);
    }
    @Override
    public String toString() {//string representation of fraction that's all
        return this.getNumerator() + " / " + this.getDenominator();
    }

    public boolean equals(Fraction f) {
        if (this.size() == f.size()) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int hashValue() {
        int hash = 7;
        hash = 37 * hash + this.numerator;
        hash = 37 * hash + this.denominator;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        return true;
    }
    
    public void checkNegatives(){
        if (this.getDenominator() < 0 ) {
            this.setNumerator(this.getNumerator() * -1);
            this.setDenominator(this.getDenominator() * -1);

        } 
        
    }
    @Override
    public void invert() {
        int holder;
        holder = this.getNumerator();
        this.setNumerator(this.getDenominator());
        this.setDenominator(holder);
        checkNegatives();
        //reduce();
    }

    public static void sortNumbers(int a, int b) {//sorts the numbers from lowest to highest
        int holder;
        if (a < 0 && b < 0) {
            a *= -1;//absolute value, both positive if both negative
            b *= -1;
        }
        if (a > b) {//makes Two be larger number
            holder = a;
            a = b;
            b = holder;
        }
        smallNumber = a;
        largeNumber = b;

    }

    public static int determineGreatestCommonDivisor(int smallInt, int largeInt) {
        int remainder = 1;
        int quotient;

        while (remainder > 0) {//continiously divids the large number by the small number, then replaces the small number with the remainder 
            // left over from the previus trial, until the remainder is 0 
            quotient = (int) Math.floor(largeInt / smallInt);
            remainder = largeInt - quotient * smallInt;

            largeInt = smallInt;
            smallInt = remainder;

        }

        return largeInt;//this is the GCD
    }

    @Override
    public boolean equals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
