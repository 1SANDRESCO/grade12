/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit01;

import java.util.Scanner;

/**
 *
 * @author 1SANDRESCO
 */
public class TheMatrix {

    public static Scanner input = new Scanner(System.in);
    public static double[][] matrixHolder;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("----------Welcome to the Matrix Program----------");
        double[][] theMatrix;
        int optionNumber = 0;
        boolean goodOptionNumber = false;
        boolean exit = false;

        while (exit == false) {
            optionNumber = displayOptions(optionNumber);
            if (optionNumber > 0 && optionNumber < 6) {
                goodOptionNumber = true;
            } else {
                System.out.println("Opps! Choice entered is not possible. Try again!");
                optionNumber = displayOptions(optionNumber);
            }
            if (optionNumber == 5) {
                exit = true;
            }
            if (goodOptionNumber == true) {
                switch (optionNumber) {
                    case 1:
                        theMatrix = generateMatrix();
                        displayArray(theMatrix);
                        matrixHolder = theMatrix;
                        break;
                    case 2:
                        generateTranspose(matrixHolder);
                }
            }
        }
    }

    public static int displayOptions(int choice) {
        System.out.println();
        System.out.println("Please select one of the following options: ");
        System.out.println("1: The Random Matrix");
        System.out.println("2: The Transpose Matrix");
        System.out.println("3: Multiplying a Matrix by a Constant");
        System.out.println("4: Multiplying Two Matrices");
        System.out.println("5: EXIT");
        System.out.print("Your choice is: ");
        choice = input.nextInt();
        return choice;
    }

    public static double[][] generateMatrix() {
        final int MAX_MATRIX_VALUE = 9;
        double[][] matrix;
        System.out.println();
        System.out.println("Generating Matrix..");
        int rows;
        int cols;
        System.out.print("Enter number of ROWS: ");
        rows = input.nextInt();
        System.out.print("Enter number of COLUMNS: ");
        cols = input.nextInt();
        matrix = new double[rows][cols];

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int colIndex = 0; colIndex < cols; colIndex++) {
                matrix[rowIndex][colIndex] = (int) (Math.random() * (MAX_MATRIX_VALUE + 1));
            }
        }

        return matrix;
    }

    public static double[][] generateTranspose(double[][] array) {
        
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++){
            for (int colIndex = 0; colIndex < array[rowIndex].length; colIndex++){
                
            }
        }
        return null;
    }

    public static void displayArray(double[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                System.out.print(data[row][col] + "   ");
            }
            System.out.println();
        }
    }

}
