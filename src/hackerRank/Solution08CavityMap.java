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
public class Solution08CavityMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());//dimension of square map
        String[] map = new String[n];
        //String[] map2 = new String[n];
        int[][] data = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = input.nextLine();//put into string array
            for (int i2 = 0; i2 < n; i2++) {
                data[i][i2] = Integer.parseInt(map[i].charAt(i2) + "");//put into data array
            }
        }
        map = null;
        for (int r = 1; r < n - 1; r++) {//find cavities, set them to negative 1
            for (int c = 1; c < n - 1; c++) {
                if (data[r][c] > data[r - 1][c] && data[r][c] > data[r + 1][c] && data[r][c] > data[r][c + 1] && data[r][c] > data[r][c - 1]) {
                    data[r][c] = -1;
                }        
            }

        }
        
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                if (data[r][c] != -1) {
                    System.out.print(data[r][c]);
                    
                } else {
                    System.out.print("X");
                   
                }
            }
            System.out.println();
        }
        

    }

 

}
