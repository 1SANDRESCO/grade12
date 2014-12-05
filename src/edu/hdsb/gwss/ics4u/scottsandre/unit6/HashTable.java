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
    public int collisions;
    public int array[];
    public int size = 0;
    //public static double loadFactor = 0;

    public HashTable(int x) {
        this.expectedNumberInputs = x;
        this.array = new int [capacity()];
        for (int i = 0; i < this.array.length; i++){
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
    
    public void displayArray(){
        System.out.print("\n");
        for (int i = 0; i < this.array.length; i++){
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
    public void resize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int get(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void put(int value) {//calsl hash then places it
        array[hash(value)] = value;
        size++;
        if (loadFactor() > MAX_FACTOR){
            resize();
        }
   }

    @Override
    public boolean containsKey(int key) {//see if key has a value
    if (array[key] == -1){
        return false;
    } else {
        return true;
    }
    }

    @Override
    public int hash(int value) { // pass it the value, it returns where to put it
        int indexLocation = value % this.capacity();
        if (containsKey(indexLocation)){//number already in that spot
            do {
                indexLocation++;
            } while (containsKey(indexLocation));
        }
        return indexLocation;
     }

    public static void main(String[] args) {
        HashTable h = new HashTable(10);
        System.out.println(h.capacity());
        
        h.put(18);
        h.put(5);
        h.put(6);
        h.displayArray();
        System.out.println("Load Factor: " + h.loadFactor());
        System.out.println("Size: " + h.size() + " capacity: " + h.capacity());
   
        

    }

}
