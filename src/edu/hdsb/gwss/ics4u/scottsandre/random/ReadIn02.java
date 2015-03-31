/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Scott
 */
public class ReadIn02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File ("input01.txt");
        int[] data = new int[10];
        Scanner input = new Scanner (file);
        
        int count = 0;
        while (input.hasNext()){
            data[count] = input.nextInt();
            count++;
        }
        
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i] + ", ");
        }
    }
    
}
