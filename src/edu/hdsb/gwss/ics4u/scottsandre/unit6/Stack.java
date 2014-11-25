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
            System.out.println("Data at top (index " + top + ") is " + x);
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
            data[top] = num;
            
        } else {
            System.out.println("Cannot push " + num + " as array is full.");
        }
    }

    @Override
    public int size() {
        return top;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

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
        top = -1;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.print("\n");
    }

}
