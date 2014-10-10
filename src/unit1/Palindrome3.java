/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unit1;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class Palindrome3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sentence = getPhrase();
        boolean answer = false;
        answer = checkPalindrome(sentence);
        if (answer == true){
            System.out.println("Sentence is a palindrome!");
        } else {
            System.out.println("Sentence is not a palindrome!");
        }    
    }
    
    public static String getPhrase(){
        Scanner input = new Scanner (System.in);
        String str1;
        System.out.print("Please enter a sentence to count number of Palindromes: ");
        str1 = input.nextLine();
        return str1;
    }
    
    public static boolean checkPalindrome(String str){
        String reverse = "";
        
        for (int i = str.length() - 1; i >= 0; i--){
            reverse += str.charAt(i);
        }  
        if (reverse.equalsIgnoreCase(str)) {
            return true;
        } else {
            return false;
        }
    }
    
}
