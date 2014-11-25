/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

/**
 *
 * @author Owner
 */
public class StackTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Stack tester");

        System.out.println("Test Case 1: Empty constructor");
        Stack s = new Stack();
        System.out.println("Length is: " + s.getLength());
        System.out.println("Display Array: ");
        s.displayArray();

        System.out.println("\nTest case 2: push 5");
        s.push(5);
        s.displayArray();

        System.out.println("\nTest case 3: push 7 (should be beside 5)");
        s.push(7);
        s.displayArray();

        System.out.println("\nTest Case 4: Pass constructor 3 (length)");
        Stack s2 = new Stack(3);
        s2.displayArray();
        
        System.out.println("\nTest Case 5: push more numbers than length of array");
        s2.push(1);
        s2.push(2);
        s2.push(3);
        s2.displayArray();
        System.out.println("Pushing one more number... (99)");
        s2.push(99);
        
        System.out.println("\nTest Case 6: is array empty/full (array is not empty or full)");
        s.displayArray();
        System.out.println("\nIs it empty: " + s.isEmpty());
        System.out.println("Is it full: " + s.isFull());
        
        System.out.println("\nTest Case 7: is array empty/full (array is full)");
        s2.displayArray();
        System.out.println("\nIs it empty: " + s2.isEmpty());
        System.out.println("Is it full: " + s2.isFull());
        
        System.out.println("\nTest Case 8: is array empty/full (array is empty)");
        Stack s3 = new Stack(7);
        System.out.println("\nIs it empty: " + s3.isEmpty());
        System.out.println("Is it full: " + s3.isFull());
        
        System.out.println("\nTest Case 9: top");
        s.push(245);
        s.push(827);
        s.push(99);
        s.displayArray();
        s.top();
        
        System.out.println("\nTest Case 10: pop");
        s.displayArray();
        s.pop();
        
        System.out.println("Test case 11: size");
        s.displayArray();
        System.out.println("Top is at index: " + s.size());
        
        
        
        
        
        

    }

}
