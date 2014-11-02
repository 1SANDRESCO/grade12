/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4.pt;

/**
 *
 * @author Owner
 */
public class RecursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Recursive Functions: ");
        
        System.out.println();
        
        System.out.println("First Function: ");
        System.out.println("(5,3) : " + functionOne(5,3));
        System.out.println("(2,2) : " + functionOne(2,2));
        System.out.println("(1,4) : " + functionOne(1,4));
        System.out.println("(-5, -2) : " + functionOne(-5,-2));
        
        System.out.println();
        
        System.out.println("Second Function: ");
        System.out.println("(1,1) : " + functionTwo(1, 1));
        System.out.println("(2,1) : " + functionTwo(2, 1));
        System.out.println("(3,2) : " + functionTwo(3, 2));
        System.out.println("(5,5) : TOO LARGE");
        
    }

    public static int functionOne(int x, int y) {
        if (x < y) {
            return functionOne(x * -1, y * -1);
        }
        if (x == y) {
            return 30;
        } 
        
        return 1 + functionOne(x - 1, y);
        
    }

    public static long functionTwo (long m, long n){      
        if (m == 0){
            return n + 1;
        }
        if (m > 0 && n == 0){
            return functionTwo(m - 1, 1);
        } 
        if (m > 0 && n > 0){ 
        return functionTwo(m-1, functionTwo(m, n - 1));
        }
        return -1;
     
    }
}