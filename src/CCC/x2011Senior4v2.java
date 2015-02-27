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
public class x2011Senior4v2 {

    public static Scanner input = new Scanner(System.in);
    public static int sum = 0;

    public static void main(String[] args) {
        int[] aUnits = new int[8];
        int[] patients = new int[8];
        aUnits = stringToArray(aUnits);
        patients = stringToArray(patients);

        //O negative first
        checkThatIndex(patients, aUnits, 0, -1, -1, -1);
        //O positive
        checkThatIndex(patients, aUnits, 1, -1, -1, -1);
        //A negative
        checkThatIndex(patients, aUnits, 2, 1, -1, -1);
        //A positive
        checkThatIndex(patients, aUnits, 3, -1, -1, -1);
        //B negative
        checkThatIndex(patients, aUnits, 4, 2, 3, -1);
        //B positive
        checkThatIndex(patients, aUnits, 5, 2, 3, -1);
        //AB negative
        checkThatIndex(patients, aUnits, 6, 1, 3, 4);
        checkThatIndex(patients, aUnits, 7, -1, -1, -1);

        System.out.println(sum);
    }

    public static void checkThatIndex(int[] patients, int[] units, int m, int not1, int not2, int not3) {
        if (m != not1 && m != not2 && m != not3 && m != -1) {
            for (int i = 0; i < patients[m]; i++) {
                if (units[m] > 0) {
                    units[m]--;
                    sum++;
                } else if (units[m] == 0) {
                    i = patients[m] + 1;//exit loop
                    if (m > 0) {
                        checkThatIndex(patients, units, m - 1, not1, not2, not3);
                    }
                }
            }
//            if (m > 0) {
//                checkThatIndex(patients, units, m - 1, not1, not2, not3);
//            }
        } else {
            if (m > 0) {
                checkThatIndex(patients, units, m - 1, not1, not2, not3);
            }
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
