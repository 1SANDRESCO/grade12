/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Unit01;

import java.util.Scanner;

/**
 *
 * @author 1SANDRESCO
 */
public class Palindrome2 {
public static int start = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String sentence = "";
        String word = "";
        int numberWords = 0;
        int numberPalindromes = 0;
        
        System.out.print("Enter a sentence to count the number of palindromes: ");
        sentence = input.nextLine();
        numberWords = numberOfWords(sentence);
        System.out.println(numberWords);
        for (int i = 0; i < numberWords; i++){
            if (splitIntoWords(sentence) == true){
                numberPalindromes++;
            }
        }
        
        
        
    }
    
    public static int numberOfWords(String sentence){
        int counter = 0;
        for (int i = 0; i < sentence.length(); i++){
            if (sentence.charAt(i) == ' ')
                counter++;
            }
        if (sentence.charAt(sentence.length() - 1) == ' '){
            counter--;
        }
        return counter + 1;
        }
        
    
    
    public static boolean splitIntoWords(String sentence){
        int wordLength; 
        boolean palD;
        String word = "";
        wordLength = sentence.indexOf(" ", start);
        word = sentence.substring(start, wordLength);
        start +=wordLength;
        System.out.println(word);
        palD = checkPalindrome(word);
        return palD;
    }
    
    public static boolean checkPalindrome(String word){
        String reverse = "";
        
        for (int i = word.length() - 1; i >= 0; i--){
            reverse += word.charAt(i);
        }
        System.out.println("Reverse: " + reverse);
        if (reverse.equals(word)){
            System.out.println("yes");
            return true;
            
        } else {
            return false;
        }
        
    }
    
}


