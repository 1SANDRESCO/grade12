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
public class FractionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Case 1: New Regular Fraction");
        Fraction f = new Fraction();
        f.setNumerator(15);
        f.setDenominator(3);
        System.out.println("To String: " + f.toString());
        f.reduce();
        System.out.println("After being reduced with two positives: " + f.toString());
        
        System.out.println("Setting num to - 22, denom to - 11");
        f.setNumerator(-22);
        f.setDenominator(-11);
        System.out.println("To String: " + f.toString());
        f.reduce();
        System.out.println("After being reduced with two negatives: " + f.toString());
        
        System.out.println("Making top negative, bottom positive, then reducing");
        f.setNumerator(-45);
        f.setDenominator(9);
        f.reduce();
        System.out.println("To String: " + f.toString());
        
        System.out.println("Making top +, bottom -, then reducing");
        f.setNumerator(9);
        f.setDenominator(-3);
        f.reduce();
        System.out.println("To String: " + f.toString());
        
        System.out.println("\n\nTesting all other functions for regular fraction:");
        System.out.println("To String: " + f.toString());
        System.out.println("size: " + f.size());
        System.out.println("\ntesting larger (f) so making new fraction 13/2");
        Fraction f2 = new Fraction (13, 2);
        System.out.println(f.larger(f2).toString());
        
        System.out.println("\nTesting larger (f, g) so making new fraction 34/3");
        Fraction f3 = new Fraction (34, 3);
        System.out.println("Largest is " + f.larger(f2,f3).toString());
        
        System.out.println("Testing times (f) using f1 and f2");
        System.out.println(f.times(f2).toString());
        
        System.out.println("Testing times (f, g) using f2 and f3");
        System.out.println("f2: " + f2.toString());
        System.out.println("f3: " + f3.toString());
        System.out.println("Multiplied together and then reduced because that is in 'times' function: " + f.times(f2, f3).toString());
        
        System.out.println("testing equals with two DIFFERENT functions (f2 and f3)");
        System.out.println(f2.equals(f3));
        
        System.out.println("testing equals with two SAME functions (f1 and f4 with same values)");
        Fraction f4 = new Fraction (36, -12);
        System.out.println("f1: " + f.toString());
        System.out.println("f4: " + f4.toString());
        
        System.out.println(f.equals(f4));
        
        System.out.println("testing invert: ");
        System.out.println("f4: " + f4.toString());
        f4.invert();
        System.out.println("After inverted f4: " + f4.toString());
        System.out.println("testing hash value of f4: ");
        System.out.println(f4.hashValue());
        
        System.out.println("Making a general fraction with + num and - denom: (4/-99) should check negatives");
        Fraction f5 = new Fraction (4, -99);
        System.out.println("to string f5: " + f5.toString());
        
        System.out.println("this therefore tests the functionality of im/proper fractions...");
        
        System.out.println("-------------------------------------------------------");
        System.out.println("PROPER FRACTION:");
        System.out.println("making bad proper fraction 55/2");
        ProperFraction pf = new ProperFraction (55,2);
        
        System.out.println("-------------------------------------------------------");
        System.out.println("IMPROPER FRACTION:");
        System.out.println("making bad improper fraction 2/7");
        ImproperFraction ipf = new ImproperFraction (2,7);
        
        System.out.println("making goog improper fraction: ");
        ImproperFraction ipf2 = new ImproperFraction (11,7);
        System.out.println(ipf2.toString());
        
        System.out.println("to mixed: ");
        ipf2.toMixed();
        System.out.println("returns object. object to string: " + ipf2.toMixed().toString());
        
         System.out.println("-------------------------------------------------------");
        System.out.println("MIXED FRACTION:");
        System.out.println("good mixed fraction: ");
        MixedFraction m = new MixedFraction (3, 4, 5);
        System.out.println("to string: " + m.toString());
        
        System.out.println("to improper: ");
        m.toImproper();
        System.out.println("returns an object. object to string: " + m.toImproper().toString() );
        
        System.out.println("bad mixed fraction #1: ");
        MixedFraction m2 = new MixedFraction (4, 3, 2);
        System.out.println("to string: " + m2.toString());
        
        System.out.println("bad mixed fraction #2: (0 as whole number)");
        MixedFraction m3 = new MixedFraction (2, 3, 0);
        System.out.println("to string: " + m3.toString());
        
        System.out.println("bad mixed fraction #3: negative not in front of whole number like 5 and 1/-3");
        MixedFraction m4 = new MixedFraction (1, -3, 5);
        System.out.println("to string: " + m4.toString());
        
        System.out.println("testing mixed fraction all negatives");
        MixedFraction m5 = new MixedFraction (-2, -3, -6);
        System.out.println("to string: " + m5.toString());
        
        System.out.println("mixed fraction invert");
        System.out.println("m5 before: " + m5.toString());
        m5.invert();
        System.out.println("m5 after: " + m5.toString());
        System.out.println("nothing happned.");
        
        
        
        
    }
    
}
