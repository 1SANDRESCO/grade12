package edu.hdsb.gwss.ics4u.scottsandre.ptDayTwo;

/**
 * Open Hash Table
 *
 *
 * @version v2014.S1
 */
public class OpenHashTable {

    /**
     * Open Hash Table: an array of Linked Lists
     */
    private LinkedListPT[] data;

    /**
     * Creates an Open Hash Table; default size 11
     */
    public OpenHashTable() {
        this(11);
    }

    /**
     * Creates an Open Hash Table
     *
     * @param intialSize the initial capacity, rounded to the next prime.
     */
    public OpenHashTable(int intialSize) {
        data = new LinkedListPT[nextPrime(intialSize)];
        makeEmpty();
    }

    public void makeEmpty() {
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = null;
        }
    }

   
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean indexOccupied(int x) {
       if (x < data.length){
            if (this.data[x] == null) {
                return false;
            } else {
                return true;
            }
       } else {
           return false;
       }
       
    }

    public CSStudent get(int key) {
        boolean found = false;
        
        int x = hash(key);

        if (!indexOccupied(x)) {//no data in that index
            return null;
        } else {//search for it 
            return data[x].get(key);
        }
    }

    /**
     * Puts a student in the Hash Table. Duplicates are fine, and assume student
     * objects are correct and have unique keys.
     *
     * @param student valid student object
     */
    public void put(CSStudent student) {
        int x = hash(student.getStudentNumber());
        if (this.data[x] == null){
            this.data[x] = new LinkedListPT();
        }
        this.data[x].addAtEnd(student);

    }

    /**
     * Determines if a student object exists with the given key (student number)
     *
     * @param key key (student number)
     * @return returns true if the student with the given key (student number)
     * exists
     */
    public boolean containsKey(int key) {
        boolean found = false;
        
        int x = hash(key);

        if (!indexOccupied(x)) {//no data in that index
            return false;
        } else if (data[x].get(key) != null){
            return true;
        }
        return false;
        //CSStudent Student = get(key);
        //return student != null;
    }

    /**
     * The number of student objects in the hash table.
     *
     * @return the number of student objects in the hash table.
     */
    public int size() {
        int size = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null){
                size += data[i].size();
            }
        }
        return size;
    }

    /**
     * The capacity of the Open Hash Table; THINK! THINK! THINK!
     *
     * @return
     */
    public int capacity() {//in linked linsts
        return data.length;
    }

    /**
     * COMPLETE!
     *
     * @return returns a graphic of the Open Hash Table
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                s = s + "\n" + "HT[" + i + "] " + data[i].toString();
            } else {
                s = s + "\n" + "HT[" + i + "] EMPTY";
            }
        }
        return s;
    }

    /**
     * Hash Function; COMPLETE
     *
     * @param key key (student number)
     * @return hash value
     */
    public int hash(int key) {
        return key % data.length;
    }

    /**
     * COMPLETE
     */
    public static int nextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        };
        return n;
    }
    
    public void removeFromHashTable(int key){
        int x = hash(key);
        data[x].remove(key);
        
    }

    /**
     * COMPLETE
     */
    private static boolean isPrime(long n) {
        // EVEN TEST
        if (n > 2 && (n & 1) == 0) {
            return false;
        }
        // ODD FACTORS
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
