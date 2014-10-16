/*
 * Android PIN Lock
 *  - three digit lock code
 *  
 * Version: 0.3; NOT THE FINAL VERSION
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

/**
 */
public class AndroidLock {

    // CLASS CONSTANTS
    public static final String LOCK_MANUFACTURER = "ANDROID";
    public static final int MIN_COMBO_VALUE = 0;
    public static final int MAX_COMBO_VALUE = 9;
    public static final int NUMBER_OF_DIGITS = 3;

    // CLASS VARIABLES
    private static int numberOfLocksCreated;

    // OBJECT VARIABLE
    private boolean configurableCombo;
    private boolean open;
    private boolean digit01Revealed;
    private boolean digit02Revealed;
    private boolean digit03Revealed;
    private int serialNumber;
    private int invalidAttempts;
    private int digit01;
    private int digit02;
    private int digit03;

    /*
     * Android Lock
     *      - 3 digit combo (0-9)
     *      - you can reset code, only when lock is open
     *      - default combo values are random
     *      - serial number is DISTINCT for all instances
     */ 
    public AndroidLock() {
        this( 
                (int) ( Math.random() * 10 ), 
                (int) ( Math.random() * 10 ), 
                (int) ( Math.random() * 10 ) 
        );
    }

    /*
     * Android Lock
     *      - 3 digit combo (0-9)
     *      - you can reset code, only when lock
     *      - if the code is not set, combo values are -1
     *      - serial number is DISTINCT for all instances
     */ 
    public AndroidLock( int digit01, int digit02, int digit03 ) {
        System.out.println( "CREATED: " + LOCK_MANUFACTURER + " Lock" );
        this.open = true;
        this.configurableCombo = true;        
        this.serialNumber = -1; // TODO
        this.invalidAttempts = 0;
        this.digit01Revealed = false;
        this.digit02Revealed = false;
        this.digit03Revealed = false;
        this.setCombo( digit01, digit02, digit03 );
        System.out.println( "\tYour Combo: " + this.getCombo() + " | SN: " + this.serialNumber );
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }
    
    /*
     * Setting Combo:
     *      - must be valid values (0-9)
     *      - can only set the combo when the lock is OPEN
     *      - can only be set if the lock is configurable
     */
    public void setCombo( int digit01, int digit02, int digit03 ) { 
        // TODO
        this.digit01 = digit01;
        this.digit02 = digit02;
        this.digit03 = digit03;
        System.out.println( "\tYour Combo: " + this.getCombo() + " | SN: " + this.serialNumber );
    }
        
    /*
     * Digit 01; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit01() {
        int digit = -1;
        if( this.digit01Revealed ) {
            System.out.println( "ERROR: Digit 01 Revealed to the client. " );
        }
        else {
            this.digit01Revealed = true;
            digit = this.digit01;
        }        
        return digit;
    }

    /*
     * Digit 01; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit02() {
        int digit = -1;
        if( this.digit02Revealed ) {
            System.out.println( "ERROR: Digit 02 Revealed to the client. " );
        }
        else {
            this.digit02Revealed = true;
            digit = this.digit02;
        }        
        return digit;
    }

    /*
     * Digit 03; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit03() {
        int digit = -1;
        if( this.digit03Revealed ) {
            System.out.println( "ERROR: Digit 03 Revealed to the client. " );
        }
        else {
            this.digit03Revealed = true;
            digit = this.digit03;
        }        
        return digit;
    }
    
    /*
     * Getting Combo:
     *      - nobody should see the combo; except when the lock is created.
     */
    private String getCombo() {
        // TODO
        return this.digit01 + "-" + this.digit02 + "-" + this.digit03;
    }

    public boolean isOpen() {
        return open;
    }

    /*
     * Lock
     */
    //isLocked
    public boolean lock() {
        // TODO
//        if( this.open == false ){
//            return true;
//        }
        return true;
    }

    /*
     * Unlock; 
     *      - unlock with correct combination
     *      - AFTER three invalid unlocking attempts; lock will not open
     */
    public boolean unlock( int digit01, int digit02, int digit03 ) {
        // TODO
//        if (invalidAttempts < 3 && digit01 == this.getDigit01() && digit02 == this.getDigit02() && digit03 == this.getDigit03()){
//            return true;
//        } else {
//            invalidAttempts++;
//            return false;
//        }
        return false;
    }

    @Override
    public String toString() {
        return "AndroidLock{" + "serialNumber=" + serialNumber + '}';
    }

    /**
     * The method returns the number of locks created.
     *
     * @return the number of locks created.
     */
    public static int getNumberOfLocksCreated() {
        return numberOfLocksCreated;
    }

}
