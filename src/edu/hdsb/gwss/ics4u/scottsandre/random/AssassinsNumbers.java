/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class AssassinsNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int n = Integer.parseInt(input.nextLine());
        int r;

        int[] targets = new int[n];
        int[] freeNumbers = new int[n];
        for (int i = 1; i <= n; i++) {
            freeNumbers[i - 1] = i;
        }

        for (int i = 1; i <= n; i++) {
            r = (int) (Math.random() * n) + 1;
            if (freeNumbers[r - 1] != -1 && freeNumbers[r - 1] != i) {
                freeNumbers[r - 1] = -1;
                System.out.println("Person " + i + " --> " + r );
            } else {
                i--;
            }

        }

    }
}
