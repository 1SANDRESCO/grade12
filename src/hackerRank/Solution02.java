/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class Solution02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberIn = input.nextInt();
        int[] d = new int[numberIn];
        int x;
        for (int i = 0; i < numberIn; i++) {
            x = input.nextInt();
            d[i] = calculateHeight(x);
        }
        for (int i = 0; i < numberIn; i++) {
            System.out.println(d[i]);
        }

    }

    public static int calculateHeight(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n % 2 == 0) {// even
            return calculateHeight(n - 1) + 1; //one more
        }
        if (n % 2 == 1) {//odd
            return 2 * calculateHeight(n - 1);
        }
        return -1;
    }

}
