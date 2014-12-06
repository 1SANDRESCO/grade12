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
        for (int i = 0; i < this.array.length; i++) {
            array[i] = -1;
        }
    }

    @Override
    public void isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int get(int key) {
        return this.array[key];
    }

    @Override
    public void put(int value) {//calsl hash then places it
        int y = hash(value);
        if (y == (array.length - 1) && containsKey((array.length - 1))) {//last one is already full
            System.out.println("Last index is full and u want to add another one. therefore, resize");
            valueCausingResize = value;
            resize();
        } else {
            this.array[y] = value;
            this.size++;
            if (loadFactor() > MAX_FACTOR) {
                resize();
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
                    indexLocation++;
                } while (containsKey(indexLocation));
            } else {
                System.out.println("At end of int and you want me to put on where it is already filled");
            }
        }
        return indexLocation;
    }

    public static void main(String[] args) {
        HashTable h = new HashTable(100);
        System.out.println("Empty array: ");
        System.out.println("Size: " + h.size() + " capacity: " + h.capacity() + " Collisions: " + h.collisions + " Load Factor: " + h.loadFactor());
        h.displayArray();
        System.out.println();
        
        for (int i = 0; i < 50; i++){
            h.put( (int) (Math.random() * MAX) );
        }
        System.out.println("added only 50 numbers. halfway there");
         h.displayArray();
         System.out.println("Size: " + h.size() + " capacity: " + h.capacity() + " Collisions: " + h.collisions + " Load Factor: " + h.loadFactor());
        System.out.println();  
        for (int i = 0; i < 50; i++){
            h.put( (int) (Math.random() * MAX) );
        }
        
        h.displayArray();
        System.out.println("Size: " + h.size() + " capacity: " + h.capacity() + " Collisions: " + h.collisions + " Load Factor: " + h.loadFactor());
        
       
        System.out.println();

//        System.out.println("Some numbers in it : ");
//        h.put(0);
//        h.put(1);
//        h.put(25);
//        h.put(6);
//        h.put(8);
//        h.put(5);
//        h.put(14);
//        System.out.println("Size: " + h.size() + " capacity: " + h.capacity() + " Collisions: " + h.collisions + " Load Factor: " + h.loadFactor());
//        h.displayArray();
//        System.out.println();
//
//        System.out.println("Just under load factor: ");
//        h.put(53);
//        h.put(3423);
//        System.out.println("Size: " + h.size() + " capacity: " + h.capacity() + " Collisions: " + h.collisions + " Load Factor: " + h.loadFactor());
//        h.displayArray();
//        System.out.println();
//
//        System.out.println("Passed load factor, new array, load factor should be about 25% or 0.25 putting 56");
//        h.put(56);
//
//        System.out.println("Size: " + h.size() + " capacity: " + h.capacity() + " Collisions: " + h.collisions + " Load Factor: " + h.loadFactor());
//        h.displayArray();
//        System.out.println();
//        System.out.println("New hash table: ");
//        HashTable h2 = new HashTable(5);
//        h2.displayArray();
//        h2.put(6);
//
//        h2.displayArray();
//        System.out.println("just put 6. 6 is on the end. going to put another 6 now...");
//        h2.put(6);
//
//        h2.displayArray();

    }

}
