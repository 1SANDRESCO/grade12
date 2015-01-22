/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank;

import java.io.*;
import java.util.*;

public class Solution01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array;
        long[] solutions;

        int expectedN, x;
        expectedN = input.nextInt();//get total number
        solutions = new long [expectedN];

        for (int i = 0; i < expectedN; i++) {
            x = input.nextInt();//check that x isn't too large
            array = decToBin(x);
            
            for (int i2 = 0; i2 < array.length; i2++) {
                if (array[i2] == 1) {
                    array[i2] = 0;
                } else {
                    array[i2] = 1;
                }

            }

            //displayArray(array);
            
            solutions[i] = binToDec(array);
        }
        
        displayArray(solutions);

    }

    public static long binToDec(int[] array) {

        long sum = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 1) {

                sum = sum + (long) Math.pow(2, 31 - i);
            }
        }

        return sum;
    }

    public static void displayArray(long[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

    }

    public static int[] decToBin(int x) {
        int[] array = new int[32];
        int dividend = x;

        int quotient, remainder;
        for (int i = 31; i >= 0; i--) {
            quotient = dividend / 2;
            remainder = dividend - quotient * 2;
            array[i] = remainder;
            dividend = quotient;

        }
        return array;
    }

}
