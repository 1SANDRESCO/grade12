/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

import edu.hdsb.gwss.muir.ics4u.u6.StackInterface;

/**
 *
 * @author Owner
 */
public class Stack implements StackInterface {

    public static final int DEFAULT_SIZE = 10;
    int top;
    int[] data;
    int x;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        data = new int[size];
        top = -1;
        System.out.println("Array of length " + size + " has been created.");
        for (int i = 0; i < size; i++){
            data[i] = -1;
        }
    }

    public int getLength() {
        return data.length;
    }

    @Override
    public int top() {
        if (!isEmpty()) {
            System.out.println("Top is " + data[top]);
            return data[top];
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int pop() {
        if (!isEmpty()) {
            x = data[top];
            data[top] = -1;
            System.out.println("Data at top (index " + top + ") is " + x);
            System.out.println("TOP: " + top);
            top--;
            System.out.println("Top is now at index " + top + " with value " + data[top]);
            return x;
        } else {
            System.out.println("Cannot pop as stack is empty");
            return -1;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push(int num) {
        if (!isFull()) {
            top++;
            
            data[top] = Math.abs(num);
            
        } else {
            System.out.println("Cannot push " + num + " as array is full.");
        }
    }

    @Override
    public int size() {
        return top + 1;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    public int capacity(){
    return 0;    
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < data.length; i++){
            data[i] = -1;
        }
        top = -1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFull() {
        if (top == data.length - 1) {
            return true;
        } else {
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayArray() {
        //System.out.print("\n");
        for (int i =  data.length - 1; i >= 0; i--) {
            System.out.println(data[i] );
        }
       
    }
    
    public static void main(String[] args) {
        System.out.println("Stack tester");
        
        System.out.println("New stack (s4) 5 long, make full, try to push");
        Stack s4 = new Stack(5);
        s4.push(1);
        s4.push(2);
        s4.push(3);
        s4.push(4);
        s4.push(5);
        s4.displayArray();
        s4.push(6);
        s4.displayArray();
        
        System.out.println("pop..");
        s4.pop();
        s4.displayArray();
        
        System.out.println("pop once more than until empty");
        s4.pop();
        s4.pop();
        s4.pop();
        //s4.pop();
        //s4.pop();
        s4.displayArray();
        
        

        System.out.println("Test Case 1: Empty constructor");
        Stack s = new Stack();
        System.out.println("Length is: " + s.getLength());
        System.out.println("Display Array: ");
        s.displayArray();

        System.out.println("\nTest case 2: push 5");
        s.push(5);
        s.displayArray();
        System.out.println("Size: " + s.size());

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
        System.out.println("Size: " + s2.size());
        
        System.out.println("\nTest Case 6: is array empty/full (array is not empty or full)");
        s.displayArray();
        System.out.println("\nIs it empty: " + s.isEmpty());
        System.out.println("Is it full: " + s.isFull());
        System.out.println("Size: " + s.size());
        
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
       
        System.out.println("\nTest case 11: size");
        s.displayArray();
        System.out.println("Top is at index: " + s.size());
        
        System.out.println("Test case 12: make empty");
        s.displayArray();
        s.makeEmpty();
        System.out.println("-----empty now.....");
        s.displayArray();
        
    }


}
