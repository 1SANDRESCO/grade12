/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

import java.util.Arrays;

/**
 *
 * @author 1SANDRESCO
 */
public class Queue {
    
    public static final int DEFAULT_SIZE = 6;
    public int front = -1;
    public int back = -1;
    int data[];
    
    public Queue() {
        this(DEFAULT_SIZE);
        System.out.println("empty constructor called");
    }
    
    public Queue(int size) {
        data = new int[DEFAULT_SIZE];
        System.out.println("Array of length " + size + " made");
        
    }
    
    public void EnQueue(int x) {
               
        if (isEmpty() ){
          front = 0;
          back = 0;
          data[back] = x;  
        } else   if (!isFull()) {            
            if (back >= data.length) {
                back = data.length - back;
            }
            data[back] = x;            
        } else {
            System.out.println("is full..cannot add more numbers");
        }
        back++; 
    }
    
    public int deQueue() {//take out front
        int x = -1;
        if (!isEmpty()) {
            x = data[front];
            data[front] = 0;
            front++;
            
        } else {
            System.out.println("IS empty cannot deQueue");
        }
        return x;
    }
    
    public boolean isFull() {
        if (front == back ) {
            System.out.println("isFull: FULL");
            return true;
        } else {
            System.out.println("isFull: not full");
            return false;
        }
    }
    
    public boolean isEmpty() {
        if (front == -1 && back == -1) {
            System.out.println("isEmpty: EMPTY");
            return true;
        } else {
            System.out.println("isEmpty: not empty");
            return false;
        }
    }
    
    public void makeEmpty(){
        front = -1;
        back = -1;
    }
    
    public void displayArray() {
        //System.out.print("\n");
        for (int i = data.length - 1; i >= 0; i--) {
            System.out.print(data[i] + ",");
        }
        System.out.print("\n");
    }
    
    public  int getFront() {
        return front;
    }
    
    public  int getBack() {
        return back - 1;
    }
    
    public static void main(String[] args) {
        System.out.println("Queue Tester: ");
        //Arrays.toString(data);
        System.out.println();
        System.out.println("Test Case 1: create object (empty)");
        Queue q = new Queue();
        
        System.out.println();
        System.out.println("Test Case 2: create object (size)");
        Queue q2 = new Queue(4);
        
        System.out.println();
        System.out.println("Test Case 3: display array (first one, default length 6)");
        q.displayArray();
        
        System.out.println();
        System.out.println("Test Case 4: Enter queue (55) then (77) then (88)");
        q.EnQueue(55);
        q.EnQueue(77);
        q.EnQueue(88);
        q.displayArray();
        
        System.out.println();
        System.out.println("Test Case 5: DEQUEUE");
        System.out.println("Before: front (index)= " + q.getFront() + "..back = " + q.getBack());
        q.displayArray();
        q.deQueue();
        System.out.println("After: ");
        q.displayArray();
         System.out.println("After: front (index)= " + q.getFront() + "..back = " + q.getBack());
       
        
        System.out.println("adding numbers again...");
        q.EnQueue(11);
        q.EnQueue(5);
        q.EnQueue(777);
        q.displayArray();
         System.out.println("After: front (index)= " + q.getFront() + "..back = " + q.getBack());
       
        System.out.println();
        
        System.out.println("De queueing again...");
        q.deQueue();
        q.displayArray();
        
        System.out.println("\nTest Case 6: QUEUE when back is full. Adding another number...should go to FRONT of array (index 0)");
        q.EnQueue(444);
        q.displayArray();
        
        System.out.println("\nTest case 7: deQue when back is towards front of array");
        System.out.println("Before: ");
        q.displayArray();
        q.deQueue();
        System.out.println("After: ");
        q.displayArray();
        
        System.out.println("\nAdding 2 more numbers 999 then 777...");
        q.EnQueue(999);
        q.EnQueue(777);
        q.displayArray();
        System.out.println("After: front (index)= " + q.getFront() + "..back = " + q.getBack());
       
//        
//        System.out.println("\nTest case 8: add number when array is full");
//        System.out.println("Before: ");
//        q.displayArray();
//        q.EnQueue(2342);
//        System.out.println("After: ");
//        q.displayArray();
//        
    }
    
}
