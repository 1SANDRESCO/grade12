/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class Solution3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();//low
        int y = input.nextInt();//high
        int originalHigh = y;
        int z = 0;
        int answer = 0;
        boolean answerFound = false;
        int[] a, b;

            for (; x < originalHigh; x++) {
                for (y = x + 1; y <= originalHigh; y++) {
                    a = decToBin(x);
                    b = decToBin(y);
                    z = xorMax(a, b);
                    if (z > answer) {
                        answer = z;
                    }

                }
            }
        
        System.out.println(answer);


    }

    public static int[] decToBin(int x) {
        int[] array = new int[10];
        int dividend = x;

        int quotient, remainder;
        for (int i = array.length - 1; i >= 0; i--) {
            quotient = dividend / 2;
            remainder = dividend - quotient * 2;
            array[i] = remainder;
            dividend = quotient;

        }
        return array;
    }

    public static void displayArray(int[] data) {
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }

    }

    public static int xorMax(int[] a, int[] b) {
        int[] answer = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if ((a[i] == 1 && b[i] == 0) || (b[i] == 1 && a[i] == 0)) {
                answer[i] = 1;
            }
        }
        //displayArray(answer);
        return binToDec(answer);

    }

    public static int binToDec(int[] array) {

        int sum = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 1) {

                sum = sum + (int) Math.pow(2, array.length - 1 - i);
            }
        }

        return sum;
    }

}
