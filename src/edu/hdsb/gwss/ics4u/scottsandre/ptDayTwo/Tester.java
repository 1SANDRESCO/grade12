package edu.hdsb.gwss.ics4u.scottsandre.ptDayTwo;

/**
 * Open Hash Table Tester
 *
 * @version v2014.S1
 */
public class Tester {

    /**
     */
    public static void main( String[] args ) {

        CSStudent studentTA = new CSStudent( "Tami", "A", 7110, 12 );
        CSStudent studentSA = new CSStudent( "Sami", "A", 2221, 12 );
        CSStudent studentKB = new CSStudent( "Kael", "B", 2332, 12 );
        CSStudent studentAG = new CSStudent( "Aryan", "G", 1443, 12 );
        CSStudent studentFH = new CSStudent( "Farzan", "H", 2554, 12 );
        CSStudent studentAK = new CSStudent( "Adriana", "K", 6665, 12 );
        CSStudent studentAL = new CSStudent( "Alex", "L", 7976, 12 );
        CSStudent studentSL = new CSStudent( "Steven", "L", 8387, 12 );
        CSStudent studentAM = new CSStudent( "Adil", "M", 9098, 12 );
        CSStudent studentSN = new CSStudent( "Sam", "N", 1120, 12 );
        CSStudent studentRQ = new CSStudent( "Rasheed", "Q", 2231, 12 );
        CSStudent studentFR = new CSStudent( "Farjaad", "R", 1342, 12 );
        CSStudent studentFR2 = new CSStudent( "Francis", "R", 4453, 12 );
        CSStudent studentSS = new CSStudent( "Scott", "S", 5564, 12 );
        CSStudent studentDS = new CSStudent( "Dan", "S", 6675, 12 );
        CSStudent studentLW = new CSStudent( "Leon", "W", 2896, 12 );

        System.out.println("Constructor setting size to 10, not 11");
        OpenHashTable ht = new OpenHashTable(10);
        
        System.out.println("So make empty works... now To string: ");
        System.out.println( ht.toString() );
        System.out.println("Empty? " + ht.isEmpty());
        
        System.out.println("Adding 8  students. Before size: " + ht.size());
        ht.put(studentTA);
        ht.put(studentSA);
        ht.put(studentKB);
        ht.put(studentAG);
        ht.put(studentFH);
        ht.put(studentAK);
        ht.put(studentAL);
        ht.put(studentSL);
        ht.put(studentAM);
        ht.put(studentSN);
        ht.put(studentRQ);
        ht.put(studentFR);
        ht.put(studentFR2);
        ht.put(studentSS);
        ht.put(studentDS);
        ht.put(studentLW);
        
        System.out.println( ht.toString() );
        System.out.println("After size: " + ht.size());
        
        System.out.println("testing get. getting scott w key 5564 who has been added.");
        System.out.println((ht.get(5564).toString()));
        
        System.out.println("testing get with key not added ");
        System.out.println((ht.get(1111)));
        
        System.out.println("\nprinting hashtable again to make sure it hasn't changed");
        System.out.println( ht.toString() );
        
        System.out.println("testing contains key with kael #2332 who has been added");
        System.out.println(ht.containsKey(2332));
        
        System.out.println("testing contains key with not-added number");
        System.out.println(ht.containsKey(1233));
        
        
        System.out.println("removing scott with key 5564");
        System.out.println("Before size: " + ht.size());
        ht.removeFromHashTable(5564);
        System.out.println( ht.toString() );
        System.out.println("After size: " + ht.size() + " so scott was removed.");
        
        System.out.println("capacity (in linked lists): " + ht.capacity());
        
        System.out.println("making it empty: ");
         ht.makeEmpty();
         System.out.println( ht.toString() );
         
        System.out.println("After size: " + ht.size() ) ;
        
        System.out.println(ht.get(-11));
        

    }

}
