/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

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
        this.array = new int[capacity()];
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = EMPTY;
        }
        System.out.println("length: " + this.array.length);
    }

    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
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
        //size--;
    }

    @Override
    public int capacity() {

        return primeNumberInRange(this.expectedNumberInputs);
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
    if (size == 0){
        return true;
    } else {
        return false;
    }
            }

    @Override
    public int get(int key) {
        try {
        return this.array[key];
        } 
        catch (IndexOutOfBoundsException e){
            return -1;
        }
    }

    @Override
    public void put(int value) {//calsl hash then places it
        
        value = Math.abs(value);
        
        System.out.println("...." + value);
        int y = hash(value);
        if (y == (array.length - 1) && containsKey((array.length - 1))) {//last one is already full
            System.out.println("Last index is full and u want to add another one. therefore, resize");
            valueCausingResize = value;
            resize();
        } else {
            
            this.array[y] = value;
            
            if (loadFactor() > MAX_FACTOR) {
                resize();
            } else {
                this.size++;
            }
        }
    }

    @Override
    public boolean containsKey(int key) {//see if key has a value
        if (this.array[key] == -1) {
            return false;
        } else {
            return true;
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
                } while (containsKey(indexLocation) && indexLocation != array.length -1);
            } else {
                System.out.println("At end of int and you want me to put on where it is already filled");
            }
        }
        return indexLocation;
    }

    public static void main(String[] args) {
        HashTable h = new HashTable(20);
        System.out.println("Empty array: ");
        System.out.println("IsEmpty: " + h.isEmpty());
        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.collisions + "  Load Factor: " + h.loadFactor());
        h.displayArray();
        System.out.println();

        for (int i = 0; i < 10; i++) {
            h.put((int) (Math.random() * 2 * MAX) - MAX);
        }
        System.out.println("added only 10 numbers. halfway there");
        h.displayArray();
        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.collisions + "  Load Factor: " + h.loadFactor());
        System.out.println();
        for (int i = 0; i < 10; i++) {
            h.put((int) (Math.random() * MAX));
        }

        h.displayArray();
        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.collisions + "  Load Factor: " + h.loadFactor());

        System.out.println();
        System.out.println(h.get(55));
        
        System.out.println("Making empty....");
        h.makeEmpty();
        System.out.println("Displaying array: ");
        h.displayArray();
        System.out.println("IsEmpty: " + h.isEmpty());


    }

}
