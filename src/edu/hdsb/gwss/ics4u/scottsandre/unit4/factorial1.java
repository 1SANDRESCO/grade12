/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4;

import java.util.Scanner;

/**
 *
 * @author 1SANDRESCO
 */
public class factorial1 {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        //System.out.println(factorial(10));
//        int[] data = {0, 2, 4, 7, 11, 14,34, 57, 89, 120, 140};
//        System.out.println(binarySearch(data, 34));
//    }
//    public static int binarySearch (int[] data, int value){
//       return binarySearch(data, value, 0, data.length - 1); 
//    }
    
//    public static int binarySearch (int[] data, int value, int left, int right){
//    if (left > right){
//        return -1;
//    }  
//    int mid = (left + right) / 2;
//    }

    
    
    
    

    public static long factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        
        return n * factorial (n-1);
    }
}
