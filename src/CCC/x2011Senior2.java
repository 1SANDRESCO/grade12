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
public class x2011Senior2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[][] data = new String[n][2];
        String s = "";
        for (int c = 0; c < 2; c++) {
            for (int r = 0; r < n; r++) {
                s = input.nextLine();
                data[r][c] = s + "";
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++){
            if (data[i][0].equalsIgnoreCase(data[i][1])) sum++;
        }
        System.out.println(sum);

    }

}
