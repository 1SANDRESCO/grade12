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
public class Solution05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int expectedIn = Integer.parseInt(input.nextLine());
        int k = Integer.parseInt(input.nextLine());
        int[][] array = new int[expectedIn][2];//first column is data, second is differences

        for (int i = 0; i < array.length; i++) {
            array[i][0] = Integer.parseInt(input.nextLine());
        }
        System.out.println("Before");
        displayArray(array);
        System.out.println("Sorted by size");
        bubbleSortArray(array, 0);
        displayArray(array);

        for (int i = 0; i < array.length - 1; i++) { // puts in differences. now need to sort by differences
            array[i][1] = array[i + 1][0] - array[i][0];
        }
        array[array.length - 1][1] = array[array.length - 2][1];
        
        bubbleSortArray(array, 1);
        System.out.println("Sorted by differences");
        displayArray(array);

    }

    public static void bubbleSortArray(int[][] data, int x) {
        System.out.println("length" + data.length);
        for (int pass = 0; pass < data.length - 1; pass++) {
            for (int i = 0; i < data.length - pass - 1; i++) {
                if (data[i][x] > data[i + 1][x]) {
                    swap(data, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[][] data, int i, int j) {
        int holder1 = data[i][0];
        int holder2 = data[i][1];

        data[i][0] = data[j][0];
        data[i][1] = data[j][1];

        data[j][0] = holder1;
        data[j][1] = holder2;

    }

    public static void displayArray(int[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                System.out.print(data[row][col] + ",");
            }
            System.out.println();
        }
    }

    public static void displayArray(int[] data) {
        for (int col = 0; col < data.length; col++) {
            System.out.print(data[col] + ",");
        }
    }

}
