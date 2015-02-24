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
public class Problem3CCC {

    public static Scanner input = new Scanner (System.in);
    
    public static void main(String[] args) {
        String answer = "";
        int n = Integer.parseInt(input.nextLine());//number cases
        int[] data = new int[1];
        int next = 0;
        for (int i = 0; i < n; i++){
            next = 1;
            answer = "Y";
            int x = Integer.parseInt(input.nextLine() );//length of cases
            data = new int[x];
            for (int a = x - 1; a >=0 ; a--){//get each integer in case
                data[a] = Integer.parseInt(input.nextLine() );
            }
            
            //solve
            
            for (int a = 0; a < x - 1; a++){
                if (data[a] == next){
                    //data[a] = -1;
                    next++;
                } else 
                
                if (data[a + 1] > data [a]){
                    answer = "N";
                }
            }
            
        }
        displayArray(data);
        
    }
    
    public static void displayArray(int[] data){
        System.out.println("------");
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + ",  ");
        }
        System.out.println("------");
    }
    
}
