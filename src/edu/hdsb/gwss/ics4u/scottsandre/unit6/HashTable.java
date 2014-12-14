 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

import edu.hdsb.gwss.muir.ics4u.u6.HashTableInterface;

/**
 *
 * @author 1SANDRESCO
 */
public class HashTable implements HashTableInterface {

    public static final int MIN = 0;
    public static final int MAX = 10000;
    public static final int EMPTY = -1;
    public static final double MAX_FACTOR = 0.75;
    public int expectedNumberInputs;
    public int valueCausingResize;
    public int collisions = 0;
    public int array[];
    public int size = 0;
    //public static double loadFactor = 0;

    public HashTable(int x) {
        this.expectedNumberInputs = x;
        this.array = new int[primeNumberInRange(this.expectedNumberInputs)];
        System.out.println("New hastable made. Expect: " + x + ". Size: " + capacity());

        makeEmpty();
        System.out.println("length: " + this.array.length);
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

    public void displayArray() {
        System.out.print("\n");
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + ", ");
        }
        System.out.print("\n");
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

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void resize() {//at 0.75 load factor. make to 0.5 load factor, or 1.5 x
        System.out.println("loadFactor of " + this.loadFactor() + "is too large. resizing... (or there was a number at end of array twice)");
        int[] copyArray = this.array;
        int[] largerArray = new int[primeNumberInRange(this.expectedNumberInputs * 3)];

        for (int i = 0; i < largerArray.length; i++) {
            largerArray[i] = -1;
        }
        this.array = largerArray;
        expectedNumberInputs *= 3;
        System.out.println("new expected number is: " + expectedNumberInputs + ", new capacity is: " + this.capacity());

        for (int i = 0; i < copyArray.length; i++) {
            if (copyArray[i] != -1) {
                this.array[hash(copyArray[i])] = copyArray[i];

            }
        }

        put(valueCausingResize);
        System.out.println("After resizing, the new load factor is: " + loadFactor());
        //size--;
    }

    @Override
    public int capacity() {
        return this.array.length;
        //return primeNumberInRange(this.expectedNumberInputs);
    }

    @Override
    public double loadFactor() {
        double loadFactor = (double) this.size() / (double) this.capacity();
        return loadFactor;

    }

    @Override
    public void makeEmpty() {
        this.size = 0;
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = -1;
        }
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int get(int key) {
        try {
            return this.array[key];
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    @Override
    public void put(int value) {//calls hash then places it

        value = Math.abs(value);

        System.out.println("...." + value);
        int y = hash(value);

        this.array[y] = value;

        if (loadFactor() > MAX_FACTOR) {
            resize();
        } else {
            this.size++;

        }
    }

    @Override
    public boolean containsKey(int key) {//see if key has a value
        if (key <= capacity() && key >= 0) {
            if (this.array[key] == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Key is to large or negative and does not exist in array. ");
            return false;
        }
    }

    @Override
    public int hash(int value) { // pass it the value, it returns where to put it
        int indexLocation = value % this.capacity();
        if (containsKey(indexLocation)) {//number already in that spot
            collisions++;
            if (indexLocation != array.length - 1) {
                do {
                    collisions++;
                    indexLocation++;
                } while (containsKey(indexLocation) && indexLocation != array.length - 1);
            } else {
                System.out.println("Index at end is full. Going to front.");
                indexLocation = -1;
                do {
                    collisions++;
                    indexLocation++;
                } while (containsKey(indexLocation) && indexLocation != array.length - 1);
            }
        }
        return indexLocation;
    }

    public static void main(String[] args) {

        HashTable h = new HashTable(10);
        System.out.println("Empty array: ");
        System.out.println("IsEmpty: " + h.isEmpty());
        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.collisions + "  Load Factor: " + h.loadFactor());
        h.displayArray();
        System.out.println();
        h.put(0);
        h.put(12);
        h.put(12);
        h.put(2);
        h.put(13);
        
//        for (int i = 0; i < 100; i++) {
//            h.put((int) (Math.random() * 10000));
//        }
        h.displayArray();
        System.out.println("contains key (1): " + h.containsKey(1));
        System.out.println("contains key (100): " + h.containsKey(100));
        System.out.println("contains key (-2): " + h.containsKey(-2));
        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.collisions + "  Load Factor: " + h.loadFactor());

    }

}
