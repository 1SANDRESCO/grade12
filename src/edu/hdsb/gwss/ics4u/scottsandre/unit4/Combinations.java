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
public class Combinations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        int r;
        Scanner input = new Scanner(System.in);
        System.out.println("Combinations:");
        System.out.print("Enter # objects to choose: ");
        n = input.nextInt();
        System.out.print("Enter how many objects in total there are: ");
        r = input.nextInt();
        System.out.println("Total number of ways is: " + numberCombinations(n, r));

    }
    
    public static int numberCombinations(int n, int r){
        return ( factorial(n) ) / ( factorial(r) * factorial (n-r));
    }

    public static int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);

    }

}
