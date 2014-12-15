/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

import edu.hdsb.gwss.muir.ics4u.u6.QueueInterface;

/**
 *
 * @author Scott
 */
public class Queue implements QueueInterface {

    public static final int DEFAULT_SIZE = 6;
    public static final int EMPTY = -1;
    public int front = -1;
    public int back = -1;
    int data[];

    public Queue() {
        this(DEFAULT_SIZE);
        System.out.println("empty constructor called");
    }

    public Queue(int size) {
        data = new int[DEFAULT_SIZE];
        makeEmpty();
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
            System.out.format("%4s", this.data[i] + ",");
        }
        System.out.println();
    }

    @Override
    public int front() {
        return front;
    }

    @Override
    public int back() {
        return back;
    }

    @Override
    public void enqueue(int x) {
        if (x < 0){
            x = Math.abs(x);
            System.out.println("Number was negative, is now positive");
        }
        back++;
        if (isEmpty()) {//empty
            front = 0;
            //back = 0;
            data[front] = x;
        } else if (!isFull()) {//not full
            if (back >= data.length) {
                back = data.length - back;
            }
            data[back] = x;
        } else {//full
            System.out.println("is full, cannot add number " + x);
            back--;
        }
        
    }

    @Override
    public int dequeue() {
    int x = -1;
        if (!isEmpty()) {
            x = data[front];
            data[front] = EMPTY;
            front++;
            if (front >= data.length) {
                front = data.length - front;
            }
        } else {
            System.out.println("IS empty cannot deQueue");
        }
        if (size() == 0){//resets to how it was at start
            front = -1;
            back = -1;
        }
        return x;}

    @Override
    public int size() {
        int x = 0;
        for (int i = 0; i < capacity(); i++) {
            if (data[i] != -1) {
                x++;
            }
        }
        return x;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (size() == capacity() ){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < capacity(); i++) {
            data[i] = -1;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Size: " + q.size());
        System.out.println("Capacity: " + q.capacity());
        System.out.println("Front: " + q.front() + ", Back: " + q.back());
        q.displayArray();
        
        System.out.println();
        System.out.println("queuing 1");
        q.enqueue(1);
        q.displayArray();
        System.out.println("Front: " + q.front() + ", Back: " + q.back());
        
        System.out.println();
        System.out.println("queuing 2 then 3 then 4 then 5 then 6");
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.displayArray();
        System.out.println("Front: " + q.front() + ", Back: " + q.back());
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Size: " + q.size());
        
        System.out.println();
        System.out.println("Deque twice");
        System.out.println("Deque: " + q.dequeue());
        System.out.println("Deque: " + q.dequeue());
        q.displayArray();
        
        q.enqueue(7);
        q.displayArray();
        
        System.out.println("Deque: " + q.dequeue());
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Size: " + q.size());
        q.displayArray();
        
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.displayArray();
        
        System.out.println();
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Size: " + q.size());
        System.out.println("Dequing so that it is empty: ");
        q.dequeue();
        q.displayArray();
        
        q.enqueue(-33);
        q.displayArray();
        
                

    }

}
