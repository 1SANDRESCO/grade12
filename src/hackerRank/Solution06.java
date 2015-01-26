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
public class Solution06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 0;
        //97 is a, 122 is z
        int[] data = new int [26]; // index is letter index in alphabet, value is number of those letters
        String s = input.nextLine();
        
        if (s.length() % 2 == 1){//odd number of letters, chance it is a palindrome
            for (int i = 0; i < s.length(); i++){
                data[(int) s.charAt(i) - 97]++;
            }
        }
        for (int i = 0; i < data.length; i++){
            if (data[i] % 2 == 1){//odd
                counter++;
            }
        }
      
        if (counter == 1) System.out.println("YES");
        else System.out.println("NO");
    }


}
