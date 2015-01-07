/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

/**
 *
 * @author Scott
 */
public class HashTable2 {
  
    public static final int EMPTY = -1;
    public static final double MAX_FACTOR = 0.75;
    public int expectedNumberInputs;
    public int valueCausingResize;
    public int collisions = 0;
    public Chair array[];
    public int size = 0;
    
    public HashTable2(int x) {
        this.expectedNumberInputs = x;
        this.array = new Chair[primeNumberInRange(this.expectedNumberInputs)];
        System.out.println("New hastable made. Expect: " + x + ". Size: " + capacity());

        makeEmpty();
        System.out.println("length: " + this.array.length);
    }
    
    public int capacity() {
        return this.array.length;
        
    }
    
    public int primeNumberInRange(int number) {
        boolean prime = false;
        number = (int) (number / 0.76);

        while (prime == false) {

            if (isPrime(number) == true) {
                prime = true;
            } else {
                number++;
            }

        }
        return number;
    }
    
    public void resize() {//at 0.75 load factor. make to 0.5 load factor, or 1.5 x
//        System.out.println("loadFactor of " + this.loadFactor() + "is too large. resizing..");
//        int[] copyArray = this.array;
//        int[] largerArray = new int[primeNumberInRange(this.expectedNumberInputs * 3)];
//
//        for (int i = 0; i < largerArray.length; i++) {
//            largerArray[i] = -1;
//        }
//        this.array = largerArray;
//        expectedNumberInputs *= 3;
//        System.out.println("new expected number is: " + expectedNumberInputs + ", new capacity is: " + this.capacity());
//
//        for (int i = 0; i < copyArray.length; i++) {
//            if (copyArray[i] != -1) {
//                this.array[hash(copyArray[i])] = copyArray[i];
//
//            }
//        }
//
//        put(valueCausingResize);
//        System.out.println("After resizing, the new load factor is: " + loadFactor());
//        //size--;
    }
    
    public static boolean isPrime(int number) {//not my code I do not take credit for this
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is even - no prime
                return false;
            }
        }
        return true;
    }
    
   
    public void makeEmpty() {
        this.size = 0;
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = null;
        }
    }
    
    public void put(){
        
    }
    
     public static void main(String[] args) {
         
     }
    
}
