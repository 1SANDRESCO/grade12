/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC;

import java.util.Scanner;

/**
 *
 * @author Scott
 */
public class x2011Senior4 {

    public static Scanner input = new Scanner(System.in);
    public static int sum = 0;
    public static void main(String[] args) {

        int[] aUnits = new int[8];
        int[] patients = new int[8];
        aUnits = stringToArray(aUnits);
        patients = stringToArray(patients);
       
        boolean finished = false;
        
        //do positives first, then again for negatives

        for (int i = 0; i < 8; i = i + 2) {//negatives can only get negatives
            for (int n = 0; n < patients[i]; n++) {
                if (aUnits[i] != 0) {//that blood type is not empty
                    sum++;
                    aUnits[i]--;
                } else if (aUnits[i] == 0) {//that blood type is empty
                    for (int z = i; z >= 0; z = z - 2) {
                        for (int a = 0; a < patients[z]; a++) {
                            if (aUnits[z] != 0) {
                                sum++;
                                aUnits[z]--;
                            }
                        }
                    }

                }
            }
        }
        
        
        for (int i = 1; i < 8; i = i + 2) {//positives can get + or -
            for (int n = 0; n < patients[i]; n++) {
                if (aUnits[i] != 0) {//that blood type is not empty
                    sum++;
                    aUnits[i]--;
                } else if (aUnits[i] == 0) {//that blood type is empty
                    //case for AB positive (check all of them)
                    if (i == 7){
                        
                    }
                    //case for B positive (check B-, O+ and O-)
                    //case for A +(check all to left)
                    

                }
            }
        }
        System.out.println(sum);

    }
    
    public static void checkThatIndex(int[] patients, int[] units, int m){
        for (int i = 0; i < patients[m]; i++){
            if (units[m] != 0){
                units[m]--;
                sum++;
            }
        }
    }

    public static void displayArray(int[] data) {
        System.out.println("----");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
    }

    public static int[] stringToArray(int[] data) {
        String s = input.nextLine();
        s = s + " ";
        int space1 = 0;
        for (int i = 0; i < 8; i++) {
            int space2 = s.indexOf(" ", space1);
            data[i] = Integer.parseInt(s.substring(space1, space2));
            space1 = space2 + 1;
        }
        return data;
    }

}
