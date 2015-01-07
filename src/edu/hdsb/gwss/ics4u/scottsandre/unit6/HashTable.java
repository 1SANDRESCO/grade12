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
        System.out.println("loadFactor of " + this.loadFactor() + "is too large. resizing..");
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
    public int get(int key) {//not an index location
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
        int y = hash2(value);

        this.array[y] = value;
        this.size++;

        if (loadFactor() > MAX_FACTOR) {
            System.out.println("put >> resize");
            resize();
//        } else {
//            this.size++;
//
        }
    }
    
    @Override
    public boolean containsKey(int key) {
        boolean found = false;
        int x = hash(key);
        while (found == false) {
            for (int i = x; i < array.length; i++) {
                
                if (array[i] == EMPTY) {//does not equist
                    found = false;
                    return found;
                }
                if (array[i] == key) {
                    found = true;
                    return found;
                }
            }
            x = 0;
       
    }
         return false;
    }

   // @Override
    public boolean containsKey2(int key) {//see if key has a value
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
    public int hash(int value){
        return value % capacity();
    }
    public int hash2(int value) { // pass it the value, it returns where to put it
        int indexLocation = value % this.capacity();
        if (containsKey2(indexLocation)) {//number already in that spot
            collisions++;
            if (indexLocation != array.length - 1) {
                do {
                    collisions++;
                    indexLocation++;
                } while (containsKey2(indexLocation) && indexLocation != array.length - 1);
            } else {
                System.out.println("Index at end is full. Going to front.");
                indexLocation = -1;
                do {
                    collisions++;
                    indexLocation++;
                } while (containsKey2(indexLocation) && indexLocation != array.length - 1);
            }
        }
        return indexLocation;
    }

    public static void main(String[] args) {
        int[] valuesAdded = new int[100];
        int nextSpot = 0;
        for ( int i = 0; i < valuesAdded.length; i++ ) {
            valuesAdded[i] = -1;
        }

        HashTable ht = new HashTable( 20 );

        // EMPTY
        assert ( ht.size() == 0 );
        assert ( ht.isEmpty() );
        assert ( ht.capacity() == 23 );
        assert ( ht.loadFactor() == 0.0 );

        // HASH
        assert ( ht.hash( 0 ) == 0 );
        assert ( ht.hash( 1 ) == 1 );
        assert ( ht.hash( ht.capacity() ) == 0 );
        assert ( ht.hash( ht.capacity() - 1 ) == ht.capacity() - 1 );

        // PUT
        ht.put( 0 );
        valuesAdded[nextSpot] = 0;
        nextSpot++;
        assert ( !ht.isEmpty() );
        assert ( ht.size() == 1 );
        assert ( ht.containsKey( 0 ) );
        assert ( ht.get( 0 ) == 0 );
        assert ( ht.loadFactor() == ( 1.0 / (double) ht.capacity() ) );

        // PUT; SAME HASH VALUE
        ht.put( ht.capacity() );
        valuesAdded[nextSpot] = ht.capacity();
        nextSpot++;
        assert ( !ht.isEmpty() );
        assert ( ht.size() == 2 );
        assert ( ht.containsKey( ht.capacity() ) );
        assert ( ht.get( ht.capacity() ) == ht.capacity() );
        assert ( ht.loadFactor() == ( 2.0 / (double) ht.capacity() ) );

        // FILL WITH RANDOM NUMBERS TILL LOAD FACTOR REACHED
        int size = 2;
        for ( ; size < 17; size++ ) {
            int value = (int) ( Math.random() * 100 );
            ht.put( value );
            valuesAdded[nextSpot] = value;
            nextSpot++;
            assert ( ht.size() == size + 1 );
            assert ( ht.containsKey( value ) );
            assert ( ht.get( value ) == value );
            System.out.println( "Load Factor: " + ht.loadFactor() );
        }

        // BEFORE RESIZE: 17/23 == Load Factor > 0.74
        assert ( ht.size() == 17 );
        assert ( ht.loadFactor() < 0.75 );
        assert ( ht.capacity() == 23 );

        // BEFORE RESIZE: 18/23 --> New Size: 18 / 0.25
        System.out.println( "RESIZED" );
        ht.put( 666 );
        valuesAdded[nextSpot] = 666;
        nextSpot++;
        assert ( ht.capacity() == 73 );
        assert ( ht.loadFactor() < 0.25 );
        
        // MAKE SURE RESIZE WORKED; ALL VALUES ADDED CORRECTLY
        nextSpot = 0;
        int value;
        while( valuesAdded[nextSpot] > -1 ) {
            value = valuesAdded[nextSpot];
            assert ( ht.containsKey( value ) );
            assert ( ht.get( value ) == value );
            nextSpot++;
        }
        
        // MAKE EMPTY
        ht.makeEmpty();
        // EMPTY
        assert ( ht.size() == 0 );
        assert ( ht.isEmpty() );
        assert ( ht.capacity() == 73 );
        assert ( ht.loadFactor() == 0.0 );


}
}
