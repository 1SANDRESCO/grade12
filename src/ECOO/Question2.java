/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECOO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Scott
 */
public class Question2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("DATA21.txt");
        Scanner input = new Scanner(file);

         for (int testCase = 0; testCase < 10; testCase++) {
            //System.out.println("TEST?????");
            ArrayList<String> stringData = new ArrayList();
            int length = Integer.parseInt(input.nextLine());
            //System.out.println("LENGTH>>>>" + length);
            String s;

            s = input.nextLine();

            //System.out.println("TEST>>>> " + s);
            s = s + " ";
            String holder1;
            String holder2;
            int space1 = 0;
            int space2 = 0;
            int spacesLeft = length;
            for (int i = 0; i < countNumberSpaces(s); i++) {

                if (space1 < s.length() - 1) {
                    space2 = s.indexOf(" ", space1);
                    stringData.add((s.substring(space1, space2)));
                    //System.out.println(stringData.get(i) + "XXXXX");
                    space1 = space2 + 1;
                }

                if (spacesLeft - stringData.get(i).length() >= 0) {//CHECK THIS LATER    
                    System.out.print(stringData.get(i) + " ");
                    if (spacesLeft - stringData.get(i).length() == 0) {
                        spacesLeft = length;
                    } else {
                        spacesLeft = spacesLeft - stringData.get(i).length() - 1;//prints out word shorter than length
                    }
                } else {
                    System.out.print("\n");
                    spacesLeft = length;
                    if (stringData.get(i).length() > length) {//word is too long
                        holder1 = stringData.get(i).substring(0, length);
                        holder2 = stringData.get(i).substring(length, stringData.get(i).length());
                        System.out.print(holder1 + "\n");
                        System.out.print(holder2 + " ");
                        spacesLeft = length - holder2.length() - 1;

                    } else {
                        System.out.print(stringData.get(i) + " ");
                        spacesLeft = spacesLeft - stringData.get(i).length() - 1;
                    }

                }

            }
            System.out.println("\n======");

        }
    }

    public static int countNumberSpaces(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

}
