/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank;

import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array;
        //int[] flipped = new int[32];
        int expectedN, x;
        expectedN = input.nextInt();//get total number

        for (int i = 0; i < expectedN; i++) {
            x = input.nextInt();//check that x isn't too large
            array = decToBin(x);
            displayArray(array);
            for (int i2 = 0; i2 < array.length; i2++) {
                if (array[i2] == 1) {
                    array[i2] = 0;
                } else {
                    array[i2] = 1;
                }
            }
            System.out.println("Flipped: ");
                displayArray(array);
        }

    }

    public static void binToDec() {

    }

    public static void displayArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
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
