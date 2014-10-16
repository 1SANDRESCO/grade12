
/*
 * Android PIN Lock
 *  - three digit lock code
 *  
 * Version: 0.3; NOT THE FINAL VERSION
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

/**
 */
public class AndroidLock extends Lock {

    // CLASS CONSTANTS
    public static final String LOCK_MANUFACTURER = "ANDROID";
    public static final int MIN_COMBO_VALUE = 0;
    public static final int MAX_COMBO_VALUE = 9;
    public static final int NUMBER_OF_DIGITS = 3;

    // CLASS VARIABLES
    //private static int numberOfLocksCreated;
    // OBJECT VARIABLE
    private boolean configurableCombo;
    private boolean open;
    private boolean digit01Revealed;
    private boolean digit02Revealed;
    private boolean digit03Revealed;
    private String serialNumber;
    public int invalidAttempts;
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
                (int) (Math.random() * 10),
                (int) (Math.random() * 10),
                (int) (Math.random() * 10)
              
        );
    }

    /*
     * Android Lock
     *      - 3 digit combo (0-9)
     *      - you can reset code, only when lock
     *      - if the code is not set, combo values are -1
     *      - serial number is DISTINCT for all instances
     */
    public AndroidLock(int digit01, int digit02, int digit03) {
        System.out.println("CREATED: " + LOCK_MANUFACTURER + " Lock");
        if (digit01 < 0) {
            digit01 = digit01 * -1;
        }
        if (digit02 < 0) {
            digit02 = digit02 * -1;
        }
        if (digit03 < 0) {
            digit03 = digit03 * -1;
        }
        this.setCreated(true);
        this.open = true;
        this.configurableCombo = true;
        this.serialNumber = "-1"; 
        this.invalidAttempts = 0;
        this.digit01Revealed = false;
        this.digit02Revealed = false;
        this.digit03Revealed = false;
        this.setCombo(digit01, digit02, digit03);
        System.out.println("\tYour Combo: " + this.getCombo(NUMBER_OF_DIGITS) + " | SN: " + this.serialNumber);
    }

    /*
     * Setting Combo:
     *      - must be valid values (0-9)
     *      - can only set the combo when the lock is OPEN
     *      - can only be set if the lock is configurable
     */
//    public void setCombo( int digit01, int digit02, int digit03 ) { 
//        // TODO
//        this.digit01 = digit01;
//        this.digit02 = digit02;
//        this.digit03 = digit03;
//        System.out.println( "\tYour Combo: " + this.getCombo() + " | SN: " + this.serialNumber );
//    }
    /*
     * Digit 01; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit01() {
        int digit = -1;
        if (this.getCreated()) {

            if (this.digit01Revealed) {
                System.out.println("ERROR: Digit 01 Revealed to the client. ");
            } else {
                this.digit01Revealed = true;
                digit = this.digit01;
            }
            return digit;
        } else {
            System.out.println("Lock not yet set");
            return digit;
        }
    }

    /*
     * Digit 01; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit02() {
        if (this.getCreated()) {
            int digit = -1;
            if (this.digit02Revealed) {
                System.out.println("ERROR: Digit 02 Revealed to the client. ");
            } else {
                this.digit02Revealed = true;
                digit = this.digit02;
            }
            return digit;
        } else {
            System.out.println("Lock not yet set");
            return -1;
        }
    }

    /*
     * Digit 03; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit03() {
        if (this.getCreated()) {
            int digit = -1;
            if (this.digit03Revealed) {
                System.out.println("ERROR: Digit 03 Revealed to the client. ");
            } else {
                this.digit03Revealed = true;
                digit = this.digit03;
            }
            return digit;
        } else {
            System.out.println("Lock not yet set");
            return -1;
        }
    }
   
    public boolean isOpen() {
        return open;
    }

    public boolean unlock(int digit01, int digit02, int digit03) {

        if (invalidAttempts < 3 && digit01 == this.getDigit01() && digit02 == this.getDigit02() && digit03 == this.getDigit03()) {
            return true;
        } else {
            invalidAttempts++;
            return false;
        }

    }

    /*
     * Lock
     */
    //isLocked
    public boolean isLocked() {

        if (this.open == false) {
            return true;
        } else {
            return false;
        }

    }

    /*
     * Unlock; 
     *      - unlock with correct combination
     *      - AFTER three invalid unlocking attempts; lock will not open
     */
    @Override
    public String toString() {
        return "AndroidLock{" + "serialNumber=" + serialNumber + '}';
    }

    /**
     * The method returns the number of locks created.
     *
     * @return the number of locks created.
     */
}
