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
        Scanner input = new Scanner (System.in);
        System.out.println("How long does it take to double your money?");
        int p, r, n, t;
        System.out.print("Enter principal (start) amount of $$$: ");
        p = input.nextInt();
        System.out.print("Enter annual nominal interest rate (decimal): ");
        r = input.nextInt();
        System.out.println("Enter number of times interest is compounded each year: ");
        n = input.nextInt();
        
        // 2p = p ( 1 + r/n) ^ nt
        
    }
    
}
