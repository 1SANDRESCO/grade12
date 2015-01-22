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
public class Solution04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int expectedIn = Integer.parseInt(input.nextLine());
        String s;
        int counter = 0;
        int [] answer = new int [expectedIn];
        for (int i = 0; i < expectedIn; i++){
            counter = 0;
            s = input.nextLine();
            for (int z = 0; z < s.length() - 1; z++){
                if (s.charAt(z) == s.charAt(z + 1)){
                    counter++;
                }
            }
            answer[i] = counter;
        }
        
        
        displayArray(answer);
    }
    
    public static void displayArray(int[] data) {
       
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i] );
        }

    }

}
