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
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n;
        int output;
        System.out.println("Fibonacci Series: 1, 1, 2, 3, 5, 8, 13, 21...");
        System.out.print("Enter an n'th term value to see: ");
        n = input.nextInt();
        output = fibonacci(n);
        System.out.println(output);
        
        
    }
    
    public static int fibonacci(int n){
        
        if (n < 0)
            return -1;
            
        if (n == 1 || n == 2)
            return 1;
        
        return fibonacci(n-1) + fibonacci(n-2);
        
        
        
    }
    
}
