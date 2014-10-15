/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit1;

import java.text.DecimalFormat;
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
        boolean goodOptionNumber = false;//if user submits a number that is not an option
        boolean exit = false;
        boolean arrayHasBeenMade = false;//if user selects option without having selected number 1 first, and therefore no matrix has been made

        while (exit == false) {//loop to continues to run progam until user wishes to exit
            optionNumber = displayOptions(optionNumber);//displays menu
            if (optionNumber > 0 && optionNumber < 6) {//ensures good user input
                goodOptionNumber = true;
            } else {
                System.out.println("Opps! Choice entered is not possible. Try again!");
                //displayOptions(optionNumber);
            }
            if (optionNumber == 5) {//exits
                exit = true;
            }

            if (goodOptionNumber == true) {
                switch (optionNumber) {
                    case 1://first task of creating matrix
                        arrayHasBeenMade = true;
                        theMatrix = generateMatrix();
                        displayArray(theMatrix);
                        matrixHolder = theMatrix;
                        break;
                    case 2://2nd task of transposing matrix
                        if (arrayHasBeenMade == true) {
                            generateTranspose(matrixHolder);
                        } else {
                            theMatrix = generateMatrix();//in case user has not selected step 1 first
                            matrixHolder = theMatrix;
                            generateTranspose(theMatrix);
                        }
                        break;
                    case 3://3rd task of multiplying matrix by constant
                        if (arrayHasBeenMade == true) {
                            multiplyMatrixByConstant(matrixHolder);
                        } else {
                            theMatrix = generateMatrix();//in case user has not selected step 1 first
                            matrixHolder = theMatrix;
                            multiplyMatrixByConstant(theMatrix);
                        }
                        break;
                    case 4://4th task of mutliplying a matrix by another matrix
                        multiplyMatrix(matrixHolder);

                }
            }
        }
    }

    public static void multiplyMatrix(double[][] array) {
        boolean defined = false;
        final boolean NO_WORDS = true;//will run the transposeMatrix method that does not print 

        System.out.println();
        System.out.println("For Matrix #1...");//generates first matrix
        double[][] array1 = generateMatrix();

        System.out.println();
        System.out.println("For Matrix #2...");//generates second matrix
        double[][] array2 = generateMatrix();

        if (array1[0].length == array2.length) {
            System.out.println("Therefore, we are multiplying: ");
            displayArray(array1);
            System.out.println("by :");
            displayArray(array2);

            double sum = 0;
            defined = true;
            System.out.println("Product is defined: number of array#1 rows = number of array#2 columns ");
            double[][] array3 = new double[array1.length][array2[0].length];
            array2 = generateTranspose(array2, NO_WORDS); //transposes 2nd matrix so that they each have same number of rows

            for (int matrix1Row = 0; matrix1Row < array1.length; matrix1Row++) {//rows of first matrix
                for (int matrix2Row = 0; matrix2Row < array2.length; matrix2Row++) {//rows of second matrix
                    sum = 0;
                    for (int col = 0; col < array1[matrix1Row].length; col++) {//goes through columns one by one
                        sum += array1[matrix1Row][col] * array2[matrix2Row][col];
                    }
                    array3[matrix1Row][matrix2Row] = sum;
                }
            }
            System.out.println("And the answer is:");
            displayArray(array3);

        } else {//if dimensions of matricies are not correct
            System.out.println("Array is NOT defined! Incorrect matching of rows and columns! Try again!");

        }

    }

    public static void multiplyMatrixByConstant(double[][] array) {
        double constant;
        System.out.println("------------Multiplying Matrix by Constant------------");
        System.out.print("Enter a constant (int or double) to multiply by Matrix: ");
        constant = input.nextDouble();//gets value of constant from user
        System.out.println("The original array was: ");
        displayArray(array);
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for (int colIndex = 0; colIndex < array[rowIndex].length; colIndex++) {
                array[rowIndex][colIndex] *= constant;
            }
        }

        System.out.println("The NEW array multiplied by " + constant + " is: ");
        displayArray(array);//displays answer, formatted and organized
    }

    public static int displayOptions(int choice) {//shows user options and get user input for desired task
        System.out.println();
        System.out.println("Please select one of the following options: ");
        System.out.println("1: The Random Matrix");
        System.out.println("2: The Transpose Matrix");
        System.out.println("3: Multiplying a Matrix by a Constant");
        System.out.println("4: Multiplying Two Matrices");
        System.out.println("5: EXIT");
        System.out.print("Your choice is: ");
        choice = input.nextInt();//gets user input
        return choice;
    }

    public static double[][] generateMatrix() {//makes an array of computer doubles but mathematical integers (x.0), 
        // for less complicated viewing
        double[][] matrix;
        System.out.println("------------Generating Matrix------------");//message to user describing method
        int rows;
        int cols;
        System.out.print("Enter number of ROWS: ");//gets user input of number of rows
        rows = input.nextInt();// assumes valid input from user
        System.out.print("Enter number of COLUMNS: ");//gets user input of number of rows
        cols = input.nextInt();
        cols = Math.abs(cols);//ensures valid user input 
        rows = Math.abs(rows);
        matrix = new double[rows][cols];

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int colIndex = 0; colIndex < cols; colIndex++) {
                matrix[rowIndex][colIndex] = (int) (Math.random() * (MAX_MATRIX_VALUE + 1));//creates matrix (array) using cols and rows
            }
        }
        return matrix;
    }

    public static double[][] generateTranspose(double[][] array, boolean noWords) {//transposes without printing words on screen
        double[][] transposed = new double[array[0].length][array.length];
        for (int colIndex = 0; colIndex < array.length; colIndex++) {
            for (int rowIndex = 0; rowIndex < array[colIndex].length; rowIndex++) {//transposes/flips array's columns with rows
                transposed[rowIndex][colIndex] = array[colIndex][rowIndex];
            }
        }
        return transposed;
    }

    public static void generateTranspose(double[][] array) {
        System.out.println("------------Transposing Matrix------------");//tells user about method
        System.out.println();
        double[][] transposed = new double[array[0].length][array.length];
        for (int colIndex = 0; colIndex < array.length; colIndex++) {
            for (int rowIndex = 0; rowIndex < array[colIndex].length; rowIndex++) {
                transposed[rowIndex][colIndex] = array[colIndex][rowIndex];
            }
        }
        System.out.println("The original array was: ");//compares old array with new, transposed array 
        displayArray(array);
        System.out.println("\nThe NEW, transposed array is: ");
        displayArray(transposed);

    }

    public static void displayArray(double[][] data) {
        DecimalFormat df = new DecimalFormat("#.#####");
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] % 1 == 0) {
                    System.out.format("%9s", (data[row][col]));   // formats for integers (doubles with decimals of .0)
                } else {
                    System.out.format("%9.5g", (data[row][col])); // for for doubles with decimals that are not 0 (.2342)
                }

            }
            System.out.println();
        }
    }

}
