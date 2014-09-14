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
    public static final int MAX_MATRIX_VALUE = 9;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("----------Welcome to the Matrix Program----------");
        double[][] theMatrix;
        int optionNumber = 0;
        boolean goodOptionNumber = false;
        boolean exit = false;
        boolean arrayHasBeenMade = false;

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
                        arrayHasBeenMade = true;
                        theMatrix = generateMatrix();
                        displayArray(theMatrix);
                        matrixHolder = theMatrix;
                        break;
                    case 2:
                        if (arrayHasBeenMade == true) {
                            generateTranspose(matrixHolder);
                        } else {
                            theMatrix = generateMatrix();//in case user has not selected step 1 first
                            matrixHolder = theMatrix;
                            generateTranspose(theMatrix);
                        }
                        break;
                    case 3:
                        if (arrayHasBeenMade == true) {
                            multiplyMatrixByConstant(matrixHolder);
                        } else {
                            theMatrix = generateMatrix();//in case user has not selected step 1 first
                            matrixHolder = theMatrix;
                            multiplyMatrixByConstant(theMatrix);
                        }
                        break;
                    case 4:
                        multiplyMatrix(matrixHolder);

                }
            }
        }
    }

    public static void multiplyMatrix(double[][] array) {
        boolean defined = false;
        final boolean NO_WORDS = true;
        System.out.println();
        System.out.println("For Matrix #1...");
        double[][] array1 = generateMatrix();
         System.out.println("ARRAY 1 TEST");
        displayArray(array1);
        System.out.println();
        System.out.println("For Matrix #2...");
        double[][] array2 = generateMatrix();
        System.out.println("ARRAY 2 TEST");
        displayArray(array2);
        double sum1, sum2, sum3;
        if (array1.length == array2[0].length){
            defined = true;
            System.out.println("Product is defined: number of array#1 rows = number of array#2 columns ");
            double[][]array3 = new double[array1.length][array2[0].length];
            array2 = generateTranspose(array2, NO_WORDS); 
            System.out.println("ARRAY 2 TEST 2");
            displayArray(array2);
            
//            for (int rowIndex = 0; rowIndex < array1.length; rowIndex++){
//                for (int colIndex = 0; colIndex < array2[rowIndex].length; colIndex++){
//                array3[rowIndex]    
//                }
//            }
            
            
        } else {
            System.out.println("Array is not defined! Incorrect matching of rows and columns! Try again!");
            
        }
        
    }

    public static void multiplyMatrixByConstant(double[][] array) {
        double constant;
        System.out.println("------------Multiplying Matrix by Constant------------");
        System.out.print("Enter a constant (int or double) to multiply by Matrix: ");
        constant = input.nextDouble();
        System.out.println("The original array was: ");
        displayArray(array);
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for (int colIndex = 0; colIndex < array[rowIndex].length; colIndex++) {
                array[rowIndex][colIndex] *= constant;
            }
        }

        System.out.println("The NEW array multiplied by " + constant + " is: ");
        displayArray(array);
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

        double[][] matrix;
        System.out.println("------------Generating Matrix------------");
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


    public static double[][] generateTranspose(double[][]array, boolean noWords){
     double[][] transposed = new double[array[0].length][array.length];   
      for (int colIndex = 0; colIndex < array.length; colIndex++) {
            for (int rowIndex = 0; rowIndex < array[colIndex].length; rowIndex++) {
                transposed[rowIndex][colIndex] = array[colIndex][rowIndex];
            }
        }
    return transposed;  
    }
    public static void generateTranspose(double[][] array) {
        System.out.println("------------Transposing Matrix------------");
        System.out.println();
        double[][] transposed = new double[array[0].length][array.length];
        for (int colIndex = 0; colIndex < array.length; colIndex++) {
            for (int rowIndex = 0; rowIndex < array[colIndex].length; rowIndex++) {
                transposed[rowIndex][colIndex] = array[colIndex][rowIndex];
            }
        }
        System.out.println("The original array was: ");
        displayArray(array);
        System.out.println("The NEW, transposed array is: ");
        displayArray(transposed);

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
