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

    public void displayArray() {
        for (int i = 0; i < this.data.length; i++) {
            if (this.front == i && this.back == i) {
                System.out.format("%4s", "FB");
            } else if (this.front == i) {
                System.out.format("%4s", "F-");
            } else if (this.back == i) {
                System.out.format("%4s", "B-");
            } else {
                System.out.format("%4s", "");
            }
        }
        System.out.println();
        for (int i = 0; i < this.data.length; i++) {
            System.out.format("%4s", this.data[i] + "-");
        }
        System.out.println();
    }

    public void enqueue(int x) {

        if (isEmpty()) {
            front = 0;
            back = 0;
            data[back] = x;
        } else if (!isFull()) {
            if (back >= data.length) {
                back = data.length - back;
            }
            data[back] = x;
        } else {
            System.out.println("is full..cannot add more numbers");
        }
        back++;
    }

    public int dequeue() {//take out front
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
        if (front == back) {
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

    public void makeEmpty() {
        front = -1;
        back = -1;
    }



    public int getFront() {
        return front;
    }

    public int getBack() {
        return back ;
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
        q.enqueue(55);
        q.enqueue(77);
        q.enqueue(88);
        q.displayArray();

        System.out.println();
        System.out.println("Test Case 5: DEQUEUE");
        System.out.println("Before: front (index)= " + q.getFront() + "..back = " + q.getBack());
        q.displayArray();
        q.dequeue();
        System.out.println("After: ");
        q.displayArray();
        System.out.println("After: front (index)= " + q.getFront() + "..back = " + q.getBack());

        System.out.println("adding numbers again...");
        q.enqueue(11);
        q.enqueue(5);
        q.enqueue(777);
        q.displayArray();
        System.out.println("After: front (index)= " + q.getFront() + "..back = " + q.getBack());

        System.out.println();

        System.out.println("De queueing again...");
        q.dequeue();
        q.displayArray();

        System.out.println("\nTest Case 6: QUEUE when back is full. Adding another number...should go to FRONT of array (index 0)");
        q.enqueue(444);
        q.displayArray();

        System.out.println("\nTest case 7: deQue when back is towards front of array");
        System.out.println("Before: ");
        q.displayArray();
        q.dequeue();
        System.out.println("After: ");
        q.displayArray();

        System.out.println("\nAdding 2 more numbers 999 then 777...");
        q.enqueue(999);
        q.enqueue(777);
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
