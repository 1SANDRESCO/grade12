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
public class Problem2CCC {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String answer = "good";
        int n = Integer.parseInt(input.nextLine());
        String[] firstLine = new String[n];
        String[] secondLine = new String[n];
        firstLine = wordsFromStringToArray(n, firstLine);
        secondLine = wordsFromStringToArray(n, secondLine);

        for (int i = 0; i < n - 0; i++) {//not last one
            //index 0 of each array is with one another
            //search through 1st array, look for index 0 of array 2
            for (int a = i + 1; a < n; a++) {
                if (firstLine[a].equalsIgnoreCase(secondLine[i]) && ! secondLine[a].equalsIgnoreCase(firstLine[i])){
                    answer = "bad";
                }
                if (firstLine[a].equalsIgnoreCase(secondLine[a])){
                    answer = "bad";
                }
                
            }
        }
        //displayArray(firstLine);
        System.out.println(answer);
    }

    public static String[] wordsFromStringToArray(int n, String[] data) {//some more than one digit in length
        int space1 = 0;
        int space2 = 0;
        String s = input.nextLine();
        s = s + " ";
        for (int i = 0; i < n; i++) {
            space2 = s.indexOf(" ", space1);
            data[i] = s.substring(space1, space2);
            space1 = space2 + 1;
        }

        return data;
    }

    public static void displayArray(String[] data) {
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
    }

}
