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
        int x, y;
        int counter = 1;
        int[] array;
        Scanner input = new Scanner (System.in);
        
        System.out.print("Enter number of people: ");
        x = Integer.parseInt(input.nextLine());
        array = new int[x];
        
        for (int i = 1; i <+ x; i++){
            array[i] = i;
        }
        
        while (counter <= x){
            y = (int) (Math.random() * x);
            if (array[y]!= -1){
                System.out.println("Person #" + counter + " --> " + (array[y] + 1));
                array[y] = -1;
                counter++;
            }
        }
        
    }
    
}
