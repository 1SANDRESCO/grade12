/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit1;

import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    final int TOTAL_NUMBERS= 1000;   
    final boolean PRIME = true;
    final boolean NOT_PRIME = false;
    boolean[] prime = new boolean[1000];
    int[] numbers = new int[1000];
    
    for (int i = 2; i < TOTAL_NUMBERS; i++){
        prime[i - 2] = PRIME;
        numbers [i - 2] = i;
    }
   

    for (int i = 2; i <= 7; i++){
        for (int x = 2; x < TOTAL_NUMBERS; x++){
            if (x % i == 0 && x != i){
                prime[x - 2] = NOT_PRIME;
            }
        }
    }
    displayFinalArray(prime, numbers);
    
        
    }
    
    public static void displayFinalArray(boolean[] primes, int[] numbers){
    int tab = 0;
    for (int i = 2; i < 1000; i ++){
        tab++;
        if (primes[i-2] == true){
            System.out.print(numbers[i-2] + ", ");
            if (tab % 20 == 0){
                System.out.print("\n");
            }
        }
    }    
    }
    
}
