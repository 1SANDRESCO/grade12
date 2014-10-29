/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit4;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class FractionReducer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n, d, greatestCD;
        System.out.println("Fraction Reducer:");
        System.out.print("Enter a numberator: ");
        n = input.nextInt();
        System.out.print("Enter a denominator: ");
        d = input.nextInt();
        greatestCD = GCD (n, d);
        System.out.println (n + "/" + d + " in lowest terms is: " + displayAnswer(greatestCD, n, d));
        
    }
    
    public static String displayAnswer(int greatest, int num, int denom){
        return String.valueOf(num/greatest) + "/" + String.valueOf(denom/greatest);
        
    }
    public static int GCD(int a, int b){  
     if ( b==0 ) {
         return a;
     }
     else {
         return GCD( b, a % b );
     }
    }
    
}
