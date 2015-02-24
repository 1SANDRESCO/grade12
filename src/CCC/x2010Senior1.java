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
            answer[i] = ((2 * r) + (3 * s) + d);
        }

        bubbleSortArray(answer); // are now sorted, last index is greatest        
        checkForTieAtIndex(answer, names, 1, n);
        checkForTieAtIndex(answer, names, 2, n);

    }

    public static void checkForTieAtIndex(int[] answer, String[] names, int xx, int n) {//xx is 1 for first, xx is 2 for second
        if (answer[n - xx] != answer[n - 1 - xx]) {//no tie for first
            System.out.println(names[n - xx]);
        } else {//tie for first

            int indexOfLowestLetter = -1;
            for (int i = 0; i < n - xx; i++) {
                if (answer[i] == answer[n - xx]) {//tie for first or second
                    if (indexOfLowestLetter != - 1) {
                        if (names[i].compareToIgnoreCase(names[n - xx]) < 0 && names[i].compareToIgnoreCase(names[indexOfLowestLetter]) < 0) {
                            indexOfLowestLetter = i;
                        }
                    } else if (names[i].compareToIgnoreCase(names[n - xx]) < 0) { //lower, less than
                        indexOfLowestLetter = i;
                    } else {
                        indexOfLowestLetter = n - xx;
                    }
                }
            }

            System.out.println(names[indexOfLowestLetter]);
        }
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
