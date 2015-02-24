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
public class Solution11ServiceLane {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String s1 = input.nextLine();//n at 0, t at 2
        String s2;
        int[] firstLine = new int[2];
        int[] data;
        int[] answers;
        int enter, exit;
        firstLine = intsFromStringToArray(2, firstLine);
        int hwLength = firstLine[0];
        int nCases = firstLine[1];
        data = new int[hwLength];
        answers = new int [nCases];
        data = intsFromStringToArray(hwLength, data);
        
        for (int i = 0; i < nCases; i++){//get each test case
            s2 = "";
            s2 = input.nextLine();
            enter = Integer.parseInt( s2.charAt(0) + "");
            exit = Integer.parseInt( s2.charAt(2) + "");
            answers[i] = returnLargestVehicle(data, enter, exit);
        }
        displayArray(answers);

    }
    
    public static int returnLargestVehicle (int[] data, int in, int out){
        int x = 3;
        for (int i = in; i < out; i++){
            if (data[i] < x) x = data[i];
        }
        return x;
    }

    public static int[] intsFromStringToArray(int n, int[] data) {//some more than one digit in length
        int space1 = 0;
        int space2 = 0;
        String s = input.nextLine();
        s = s + " ";
        for (int i = 0; i < n; i++) {
            space2 = s.indexOf(" ", space1);
            data[i] = Integer.parseInt(s.substring(space1, space2));
            space1 = space2 + 1;
        }

        return data;
    }
    
    public static void displayArray(int[] data) {
        for (int col = 0; col < data.length; col++) {
            System.out.println(data[col]);
        }
    }

}
