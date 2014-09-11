package Unit01;

import static Unit01.Palindrome2v2.startIndex;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Resistors {
public static int startIndex = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int[] numbers = new int[8];
    ArrayList <String> colours = new ArrayList<String>();
    String[] individualColours = new String [3];
    String chosenColours = "";
    colours.add("Black");
    colours.add("Brown");
    colours.add("Red");
    colours.add("White");
    colours.add("Orange");
    colours.add("Green");
    colours.add("Blue");
    colours.add("Violet");
    colours.add("Grey");
    printOptions(colours);
    
    for (int i = 0; i < numbers.length;i++){
        numbers[i] = i;
    }
    chosenColours = getColours();
    if (chosenColours.indexOf(chosenColours.length() - 1) != '-'){
        chosenColours += "-";
    }
    individualColours[0] = separateColours(chosenColours);
    individualColours[1] = separateColours(chosenColours);
    individualColours[2] = separateColours(chosenColours);
    System.out.println(individualColours[0]);
    System.out.println(individualColours[1]);
    System.out.println(individualColours[2]);
    }
    
    public static String separateColours(String chosenColours){
        int endWordIndex = chosenColours.indexOf("-", startIndex ) ;
        int wordLength = endWordIndex - startIndex;
        String word = chosenColours.substring(startIndex, endWordIndex);
        //System.out.println("Word: " + word);
        startIndex = endWordIndex + 1 ;
        return word;
    }
    public static void printOptions(ArrayList colours){
    for (int i = 0; i < colours.size(); i++){
        System.out.print(colours.get(i) + ", ");
    }    
    }
    public static String getColours(){
        Scanner input = new Scanner (System.in);
        String colours = "";
        System.out.print("\nEnter three colours from the above list seperated by a dash to recieve the resistance: ");
        colours = input.nextLine();
        return colours;
    }
}
