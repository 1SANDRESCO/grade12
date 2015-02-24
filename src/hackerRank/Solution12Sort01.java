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
public class Solution12Sort01 {

    /**
     * @param args the command line arguments
     */
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int s = Integer.parseInt(input.nextLine());
        int[] data = new int[s];
        
        boolean finished = false;
        data = intsFromStringToArray(s, data);
        int value = data[s - 1];
        //displayArray(data);
        int index = s - 1;
        while (finished == false){
            if (data[index - 1] > value){
                data[index] = data[index - 1];
                displayArray(data);
                index--;
            } else {
                data[index] = value;
                displayArray(data);
                finished = true;
            }
        
       }
            

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
    
    public static void displayArray(int data[]){
       for (int i = 0; i < data.length; i++){
           System.out.print(data[i] + " ");
       }
       System.out.print("\n");
    }

} 
