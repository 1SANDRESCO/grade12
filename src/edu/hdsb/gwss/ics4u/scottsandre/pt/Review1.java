/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.pt;

/**
 *
 * @author Scott
 */
public class Review1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    System.out.println("find term number where -0.25 is.");
    System.out.println(gFunction (-0.25));
    }
    
    public static int gFunction(double l){
        return function(l, 1, -4);
    }
    
    private static int function(double l, int n, double tv){
        if (l < -4 || tv > l) return -1;
        if (tv == l) return n;
        return function (l, n+1, tv / 2);
           
        
    }
    
}
