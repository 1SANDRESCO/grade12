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
public class Solution07AMCICPCTeam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] data;
        String s = input.nextLine();//3 characters long
        int n = Integer.parseInt(s.charAt(0) + "");
        int m = Integer.parseInt(s.charAt(2) + "");
        int maxTopics = 0;
        int maxTeams = 0;
        int z = 0;
        String ss;
        data = new int[n][m];

        for (int i = 0; i < n; i++) {//put into the integer array
            ss = input.nextLine();
            for (int i2 = 0; i2 < m; i2++) {
                data[i][i2] = Integer.parseInt(ss.charAt(i2) + "");
            }
        }
        
        for (int ft = 0; ft < n - 1; ft++){
            for (int st = ft + 1; st < n; st++){
                z = maxNumTopics(data, ft, st, m);
                if (z > maxTopics) maxTopics = z;
               
            }
        }
        
        for (int ft = 0; ft < n - 1; ft++){
            for (int st = ft + 1; st < n; st++){
                z = maxNumTopics(data, ft, st, m);
                if (z == maxTopics) maxTeams ++;
               
            }
        }
        
        System.out.println(maxTopics);
        System.out.println(maxTeams);
        
        


    }

    public static int maxNumTopics(int[][] data, int t1, int t2, int length) {
        int x = 0;
        for (int i = 0; i < length; i++){
            if (data[t1][i] == 1 || data[t2][i] == 1){
                x++;
            }
        }
        return x;
    }


}
