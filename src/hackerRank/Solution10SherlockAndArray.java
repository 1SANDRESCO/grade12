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
public class Solution10SherlockAndArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int testCases = Integer.parseInt(input.nextLine());//number of test cases
        int nInTestCase;
        String s;
        int space1, space2;
        String[] answers = new String[testCases];
        
        for (int i = 0; i < testCases; i++) {
            answers[i] = "NO";
        }
        
        int[] data;
        
        for (int i = 0; i < testCases; i++) {
            nInTestCase = 0;
            s = "";
            space1 = 0;
            space2 = 0;
            nInTestCase = Integer.parseInt(input.nextLine());//number of elements in next line
            data = new int[nInTestCase];
            s = input.nextLine();//get values of the array as a string
            s = s + " ";

            for (int b = 0; b < nInTestCase; b++) {//puts into integer array
                space2 = s.indexOf(" ", space1);
                data[b] = Integer.parseInt(s.substring(space1, space2));
                space1 = space2 + 1;
            }

            for (int c = 0; c < nInTestCase; c++) {//compares
                if (calculateSumLeft(data, c) == calculateSumRight(data, c)) {
                    answers[i] = "YES";
                }
            }

        }
        
        //display answer
        for (int i = 0; i < testCases; i++){
            System.out.println(answers[i]);
        }

    }

    public static int calculateSumLeft(int[] data, int i) {
        int sum = 0;
        for (int x = 0; x < i; x++) {
            sum = sum + data[x];
        }
        return sum;
    }

    public static int calculateSumRight(int[] data, int i) {
        int sum = 0;
        for (int x = i + 1; x < data.length; x++) {
            sum = sum + data[x];
        }
        return sum;
    }

    public static void displayArray(int[] data) {
        for (int col = 0; col < data.length; col++) {
            System.out.print(data[col] + ",");
        }
    }

}
