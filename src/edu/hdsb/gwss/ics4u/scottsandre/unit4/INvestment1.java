/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4;

import java.util.Scanner;

/**
 *
 * @author 1SANDRESCO
 */
public class INvestment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How long does it take to double your money?");
        double p, r, n, t, startT;
        System.out.print("Enter principal (start) amount of $$$: ");
        p = input.nextDouble();
        System.out.print("Enter annual nominal interest rate (decimal): ");
        r = input.nextDouble();
        System.out.print("Enter number of times interest is compounded each year: ");
        n = input.nextDouble();
        startT = 0;
        t = findYear(p, r, n, startT);
        System.out.println("Number years is: " + t);

    }

    public static double findYear(double p, double r, double n, double startT) {
        if (p * Math.pow((1 + r / n), n * startT) >= 2 * p) {
            return startT;
        } else {
        startT = startT + 0.1;
        return findYear(p, r, n, startT );
        
        }
        
     

    }
}
