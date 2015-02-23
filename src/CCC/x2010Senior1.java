/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC;

import java.util.Scanner;

/**
 *
 * @author Scott
 */
public class x2010Senior1 {

    public static String[] names;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());
        names = new String[n];
        int space1, space2;
        String sIn;
        String name = "";

        int[] answer = new int[n];
        int r = 0;
        int s = 0;
        int d = 0;

        for (int i = 0; i < n; i++) {
            space1 = 0;
            space2 = 0;
            sIn = input.nextLine();
            sIn = sIn + " ";
            space2 = sIn.indexOf(" ", space1);
            name = sIn.substring(space1, space2);//NAME

            space1 = space2 + 1;
            space2 = sIn.indexOf(" ", space1);
            r = Integer.parseInt(sIn.substring(space1, space2));//RAM

            space1 = space2 + 1;
            space2 = sIn.indexOf(" ", space1);
            s = Integer.parseInt(sIn.substring(space1, space2));//CPU

            space1 = space2 + 1;
            space2 = sIn.indexOf(" ", space1);
            d = Integer.parseInt(sIn.substring(space1, space2));//DISK
            names[i] = name;
            answer[i] = ((2 * r) + (3 * d) + d);
        }

        bubbleSortArray(answer); // are now sorted, last index is greatest
        //what if there is a tie
        if (answer[n] != answer[n - 1]) {//no tie for first
            System.out.println(names[n]);
        } else {//tie for first
            int lowestLetter = 1000;
            for (int i = 0; i < n - 1; i++) {
                if (answer[i] == answer[n]) {//tie
                    
                }
            }
        }

        displayArray(answer);

    }

    public static void displayArray(int[] data) {
        for (int col = 0; col < data.length; col++) {
            System.out.print(data[col] + ",");
        }
    }

    public static void bubbleSortArray(int[] data) {
        for (int pass = 0; pass < data.length - 1; pass++) {
            for (int i = 0; i < data.length - 1 - pass; i++) {
                if (data[i] > data[i + 1]) {
                    swap(data, i, i + 1);
                    swap(names, i, i + 1);
                }
            }
        }
    }

    public static void swap(String[] data, int i, int j) {
        String holder;
        holder = data[i];
        data[i] = data[j];
        data[j] = holder;
    }

    public static void swap(int[] data, int i, int j) {
        int holder;
        holder = data[i];
        data[i] = data[j];
        data[j] = holder;
    }
}
