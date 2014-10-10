/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit1;

import java.util.Scanner;

/**
 *
 * @author 1SANDRESCO
 */
public class Hangman {
public static int startIndex = 0;
public static int numberOfWords = 0;
public static Scanner input = new Scanner (System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][]wordOptions = new String[5][3];
        String[] answer = new String[5];
        wordOptions[0][0] = "Lost ";
        wordOptions[0][1] = "TV SHOWS";
        
        
        wordOptions[1][0] = "Ben Hur ";
        wordOptions[1][1] = "MOVIE";
       
        
        wordOptions[2][0] = "Children of God ";
        wordOptions[2][1] = "BOOK SERIES";
        
        
        wordOptions[3][0] = "Stairway to Heaven sdf s ";
        wordOptions[3][1] = "SONGS";
        
        
        wordOptions[4][0] = "Twin Atlantic ";
        wordOptions[4][1] = "BANDS";
       
        
        int choice = getUserChoice(wordOptions);
        wordOptions[choice][0] = wordOptions[choice][0].toLowerCase();
        answer = storeWords(wordOptions, choice);
        //System.out.println(numberOfWords);
        playTurn(answer, choice, wordOptions);
    }
    public static void playTurn(String[] answer, int choice, String[][]options){
        
        System.out.println();
        System.out.println("CATEGORY: " + options[choice][1]);
        System.out.println("NUMBER OF WORDS " + numberOfWords);
        String letter = "";
        
        for (int i = 0; i < numberOfWords; i ++){
            for (int letterIndex = 0; letterIndex < answer[i].length(); letterIndex++){
                System.out.print("___ ");
            }
            System.out.print("      ");
        }
        letter = input.nextLine();
        System.out.print("\n\nNow, guess a lower case letter: ");
        letter = input.nextLine();
        System.out.println();
       
        for (int i = 0; i < numberOfWords; i ++){
            for (int letterIndex = 0; letterIndex < answer[i].length(); letterIndex++){
                if (answer[i].charAt(letterIndex) == letter.charAt(0)) {
                System.out.print(" " + letter.toUpperCase() + "  " ) ;   
                    
                } else {
                System.out.print("___ ");}
             }
            System.out.print("      ");
        }
    }
    
    public static String[] storeWords(String[][] options, int choice){
    int length1, length2;
   
    String [] words = new String[5];
    
    for (int i = 0; i < options[choice][0].length(); i++){
        if (options[choice][0].charAt(i) == ' '){
            numberOfWords++;
        }
    }
    for (int i = 0; i < numberOfWords; i ++){
        words[i] = separateWords(options[choice][0]); 
        //System.out.print(words[i] + " ");
    }
    return words;
    }
    public static String separateWords(String phrase){
        int endWordIndex = phrase.indexOf(" ", startIndex ) ;
        int wordLength = endWordIndex - startIndex;
        String word = phrase.substring(startIndex, endWordIndex);
        //System.out.println("Word: " + word);
        startIndex = endWordIndex + 1 ;
        return word;
    }
    public static int getUserChoice(String[][]options){
        
        int chosenCategory;
        System.out.println("Please choose from the follow categories: ");
        for (int i = 0; i < options.length; i++){
            System.out.println(i + " for " + options[i][1]);
        }
        System.out.print("Your decision is: ");
        chosenCategory = input.nextInt();
        return chosenCategory;
    }
    
}
