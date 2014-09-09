/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Unit01;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class RoundingError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        double number, root, square, roundError;
        System.out.print("Enter number: ");
        number = input.nextDouble();
        root = Math.sqrt(number);
        square = Math.pow(root, 2);
        roundError = number - square;
        System.out.println("The square of the square root of " + number + " is " + square);
        System.out.println("And the round off error is " + roundError);
        
    }
    
}
