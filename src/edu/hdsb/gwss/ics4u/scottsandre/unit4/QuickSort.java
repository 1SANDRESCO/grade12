/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4;

import java.util.Scanner;

/**
 *
 * @author 1SANDRESCO
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, order;
        int[] values;
        System.out.print("Enter how many numbers to sort: ");
        n = input.nextInt();
        System.out.print("Enter 1 for descending order, 2 for ascending order: ");
        order = input.nextInt();
        values = new int[n];
        displayArray(values, n);
        quickSort(values, order);

    }

    public static void quickSort(int[] data, int order) {
        int k = data[0];
        int wall = data.length - 1;
        if (order == 2) {
            for (int i = wall; i > 0; i--) {
//                if (data[i] > k 
//   
//            }
            }
        }
    }

    public static void displayArray(int[] data, int n) {
        for (int i = 0; i < n; i++) {
            data[i] = (int) (Math.random() * 200) - 100;
            System.out.print(data[i] + ", ");
        }
    }

}
