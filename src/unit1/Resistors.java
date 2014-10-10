package unit1;

import static unit1.Palindrome2v2.startIndex;
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
    
    ArrayList <String> colours = new ArrayList<String>();
    String[] individualColours = new String [3];
    String chosenColours = "";
    colours.add("Black");
    colours.add("Brown");
    colours.add("Red");
    colours.add("Orange");
    colours.add("Yellow");
    colours.add("Green");
    colours.add("Blue");
    colours.add("Violet");
    colours.add("Grey");
    colours.add("White");
    printOptions(colours);
    
    chosenColours = getColours();
    if (chosenColours.indexOf(chosenColours.length() - 1) != '-'){
        chosenColours += "-";
    }
    individualColours[0] = separateColours(chosenColours);
    individualColours[1] = separateColours(chosenColours);
    individualColours[2] = separateColours(chosenColours);
    
    determineAnswer(individualColours, colours);
    }
    
    public static void determineAnswer(String[] indivCol, ArrayList coloursList){
    double[] numbers = new double[3];  
    double answer;
        for (int i = 0; i < coloursList.size() - 1; i++){
            if (indivCol[0].equals( coloursList.get(i))){
                numbers[0] = i;
            }
            if (indivCol[1].equals( coloursList.get(i))){
                numbers[1] = i;
            }
            if (indivCol[2].equals( coloursList.get(i))){
                numbers[2] = i;
            }
        }

    answer = ((numbers[0] * 10) + numbers[1]) * Math.pow(10, numbers[2]);
    System.out.println("Resistance in ohms: " + answer);
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
