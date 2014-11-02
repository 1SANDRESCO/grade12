/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4.pt;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Owner
 */
public class FiveTerms {

    public static final int SHOW_TERMS = 5;

    public static void main(String[] args) {

        System.out.println("Sequence One: ");
        displayTerms(true);
        System.out.println("\nSequence Two: ");
        displayTerms(false);
    }

    public static void displayTerms(boolean option) {
        if (option) {
            for (int i = 1; i < SHOW_TERMS + 1; i++) {
                System.out.print(sequenceOne(i) + " .. ");//first sequence
            }
        } else {
            NumberFormat formatter = new DecimalFormat("#0.00");   
            for (double i = 1; i < SHOW_TERMS + 1; i++) {
                System.out.print(formatter.format(sequenceTwo(i)) + " .. ");//second sequence
            } 
        }
    }

    public static int sequenceOne(int n) {//first sequence
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        return sequenceOne(n - 1) + sequenceOne(n - 2);

    }

    public static double sequenceTwo(double n) {//second sequence
        if (n < 1){
            return -1;
        }
        if (n == 1){
            return 1;
        }
        return Math.sqrt( ( 3 * sequenceTwo(n-1) + 4));
    }

}
