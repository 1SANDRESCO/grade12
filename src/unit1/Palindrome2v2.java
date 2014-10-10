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
public class Palindrome2v2 {
public static int startIndex = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sentence = getPhrase();
        String word = "";
        int counter = 0;
        int numberWords;
        if (sentence.charAt(sentence.length() - 1) != ' '){
            sentence += " ";
            //System.out.println("Space added");
        }
        numberWords = numberOfWords(sentence);
        for (int i = 0; i < numberWords; i++){
            word = splitIntoWords(sentence);
            if (checkPalindrome(word) == true){
                counter++;
            }
        }
        System.out.println("Your sentence has this number of palindrome words in it: " + counter);
    }
    public static boolean checkPalindrome(String word){
        String reverse = "";
        
        for (int i = word.length() - 1; i >= 0; i--){
            reverse += word.charAt(i);
        }
       // System.out.println("Reverse: " + reverse);
        if (reverse.equals(word)){
            //System.out.println("yes");
            return true;
            
        } else {
            return false;
        }
        
    }
    
    public static int numberOfWords(String phrase){
        int number = 0;
        for (int i = 0; i < phrase.length(); i ++){
            if (phrase.charAt(i) == ' '){
                number++;
            }
        }
        //System.out.println("number of words: " + number);
    return number;    
    }
    public static String getPhrase(){
        Scanner input = new Scanner (System.in);
        String str1;
        System.out.print("Please enter a sentence to count number of Palindromes: ");
        str1 = input.nextLine();
        return str1;
    }
    
    public static String splitIntoWords(String phrase){ 
        //System.out.println("start.." + startIndex);
        int endWordIndex = phrase.indexOf(" ", startIndex ) ;
        int wordLength = endWordIndex - startIndex;
        //System.out.println("length .." + wordLength);
        String word = phrase.substring(startIndex, endWordIndex);
        //System.out.println(word);
        startIndex = endWordIndex + 1 ;
        
        return word;

    }
}
