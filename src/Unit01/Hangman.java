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
public class Hangman {
public static int startIndex = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][]wordOptions = new String[5][3];
        wordOptions[0][0] = "Lost ";
        wordOptions[0][1] = "TV SHOWS";
        wordOptions[0][2] = "1";
        
        wordOptions[1][0] = "Ben Hur ";
        wordOptions[1][1] = "MOVIE";
        wordOptions[1][2] = "2";
        
        wordOptions[2][0] = "Children of God ";
        wordOptions[2][1] = "BOOK SERIES";
        wordOptions[2][2] = "3";
        
        wordOptions[3][0] = "Stairway to Heaven ";
        wordOptions[3][1] = "SONGS";
        wordOptions[3][2] = "3";
        
        wordOptions[4][0] = "Twin Atlantic ";
        wordOptions[4][1] = "BANDS";
        wordOptions[4][2] = "2";
        
        int choice = getUserChoice(wordOptions);
        displayPhrase(wordOptions, choice);
    }
    
    public static void displayPhrase(String[][] options, int choice){
    int length1, length2;
    int numberOfWords = 0;
    String word1, word2, word3;
    
    for (int i = 0; i < options[choice][0].length(); i++){
        if (options[choice][0].charAt(i) == ' '){
            numberOfWords++;
        }
    }
    word1 = separateWords(options[choice][0]);
    word2 = separateWords(options[choice][0]);
    System.out.println(word1);
    System.out.println(word2);
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
        Scanner input = new Scanner (System.in);
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
