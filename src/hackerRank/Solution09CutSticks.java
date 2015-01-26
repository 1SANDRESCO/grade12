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
public class Solution09CutSticks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[] data = new int[n];
        int space1 = 0;
        int space2 = 0;
        //int index = 0;
        String s = input.nextLine();
        s = s + " ";
        for (int i = 0; i < n; i++) {//put them into array
            space2 = s.indexOf(" ", space1 );
            
            data[i] = Integer.parseInt( s.substring(space1, space2));
            space1 = space2 + 1;
            
        }
        //displayArray(data);
        
        
        
        int z = 1000;
        int cuts = 0;

        while (isNotEmpty(data)) {
            z = 1000;
            cuts = 0;
            for (int i = 0; i < n; i++) {//smallest number
                if (data[i] < z && data[i] != 0) {
                    z = data[i];
                }
            }

            for (int i = 0; i < n; i++) {//subtract 2
                if (data[i] != 0) {
                    data[i] = data[i] - z;
                    cuts++;
                }
                
            }
            System.out.println(cuts);
           
        }

       
    }

    public static boolean isNotEmpty(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public static void displayArray(int[] data) {
        for (int col = 0; col < data.length; col++) {
            System.out.print(data[col] + ",");
        }
    }

}
