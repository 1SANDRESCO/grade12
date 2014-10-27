/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit3;

/**
 *
 * @author 1SANDRESCO
 */
public class LockTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AndroidLock android1 = new AndroidLock();
        
        //Test Case 1: create new adroid lock, empty constructor
        System.out.println("Test Case 1: Create new android lock, empty constructor");
        AndroidLock android2 = new AndroidLock();
        System.out.println(android2.toString());
        System.out.println();
        
        //Test Case 2: create new adroid lock, pass parameters
        System.out.println("Test Case 2: Create new android lock, pass parameters 3,4,5");
        AndroidLock android3 = new AndroidLock(3, 4, 5);
        System.out.println(android3.toString());
        System.out.println();
        
        //Test Case 3: create new adroid lock, pass parameters
        System.out.println("Test Case 3: Create new android lock, pass INVALID parameters -3,-4,-5");
        AndroidLock android4 = new AndroidLock(-3, -4, -5);
        System.out.println(android4.toString());
        System.out.println();
        
        //Test Case 4: create new adroid lock, pass parameters
        System.out.println("Test Case 4: Lock the lock");
        //android2.
        System.out.println(android4.toString());
        System.out.println();
    }
    
    
}
