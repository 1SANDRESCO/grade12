/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class x2010Senior2 {

    public static int k;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        k = Integer.parseInt(input.nextLine());
        String s = "";
        String[] letters = new String[k];
        String[] numbers = new String[k];
        int space2 = 0;
        for (int i = 0; i < k; i++) {
            s = input.nextLine();
            s = s + " ";
            letters[i] = s.charAt(0) + "";
            space2 = s.lastIndexOf(" ");
            numbers[i] = (s.substring(2, space2));
        }
        //max length is 10 of each letter's binary sequence
        String z = input.nextLine();
        int length = z.length();
        boolean end = false;
        int sIndex = 0;
        // int eIndex = 0;
        String ss;
        String aa;
        //int sum = 0;
        //int letterLength = 0;
     
        while (end == false) {

            for (int binLength = 2; binLength <= 10; binLength++) {
                ss = z.substring(sIndex, sIndex + binLength);
               
                aa = existsInArray(ss, numbers, letters);
                if (aa != null) {
                    System.out.print(aa);

                    sIndex = sIndex + binLength;
                    if (sIndex == length) {
                       
                        end = true;
                    }
                    binLength = 100;//exit loop after this loop completes

                }
            }
          

        }

    }
    
    public static void displayArray(String[] data){
        System.out.println("------");
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + ",  ");
        }
        System.out.println("------");
    }

    public static String existsInArray(String s, String[] numbers, String[] letters) {
        for (int i = 0; i < k; i++) {
            if (s.equalsIgnoreCase(numbers[i])) {
                return letters[i];
            }
        }
        return null;
    }

}
