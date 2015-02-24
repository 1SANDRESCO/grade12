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
public class Problem1CCCv2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        int k = Integer.parseInt(input.nextLine());//first
        int[] data = new int[k];
        // int[] data2 = data;
        for (int i = 1; i <= k; i++){
            data[i - 1] = i;
        }
        
        int m = Integer.parseInt(input.nextLine());
        
        
        for (int i = 0; i < m; i++){//get next round number
            int z = Integer.parseInt(input.nextLine());//input
                for (int a = z - 1; a < k; a = a + z ){
                    data[a] = 0;
                }
                compressLeft(data);
                
                
            
            
        }
        displayArray(data);
    }
    
    public static void compressLeft(int[] data){
        for (int i = 0; i < data.length; i++){
            for (int a = 2; a <data.length; a++){
            if (data[a-1] == 0 && data[a] != 0){
                data[a-1] = data [a];
                data[a] = 0;
            }    
            }
            
        }
    }
    
    public static void displayArray(int[] data){

        for (int i = 0; i < data.length; i++){
            if (data[i] != 0)System.out.println(data[i]);
        }
        
    }
    
}
