/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Unit01;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class Encryption {
public static Scanner input = new Scanner (System.in);
public static final int ALPHABET_LENGTH = 26;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str1 = getPhrase().toLowerCase();
        String str2;
        int rotation = getRotation();
        str2 = shiftSentence(str1, rotation);
        System.out.println("Simple Encrypted sentence: " + str2);
        System.out.println("Original sentence: " + str1);
        str1 = input.nextLine();
        System.out.print("Enter a phrase to decrpyt: ");
        str1 = input.nextLine();
        System.out.print("Enter rotation key: ");
        rotation = input.nextInt();
        str2 = shiftSentence(str1, rotation);
        System.out.println("Decrpyed message is: " + str2);
        
        
    }
    public static String getPhrase(){ 
        String str1;
        System.out.print("Please enter a sentence to encrypt: ");
        str1 = input.nextLine();
        return str1;
    }
    public static int getRotation(){
    int rotation;
    System.out.print("Enter rotation amount: ");
    rotation = input.nextInt();
    return rotation;
    }    
    
    public static String shiftSentence(String str, int rotate){
        String str2 = "";
        for (int i = 0; i < str.length(); i ++){
            if ((int)str.charAt(i) + rotate > 122 ){
                str2 += (char) (str.charAt(i) + rotate - ALPHABET_LENGTH);
            } else if ((int)str.charAt(i) + rotate < 97 ){
                str2 += (char)(str.charAt(i) + rotate + ALPHABET_LENGTH);
            } else {
              str2 += (char)(str.charAt(i) + rotate);   
            }
            
        }
        return str2;
    }
    
}
