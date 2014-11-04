/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4.pt;

/**
 *
 * @author Owner
 */
public class PascalsTriangle {

    public static final int TRIANGLE_SIZE = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Pascal's Triangle: ");
        int[][] data = new int[TRIANGLE_SIZE][TRIANGLE_SIZE];//two d array 

        for (int r = 0; r < TRIANGLE_SIZE; r++) {//row
            for (int c = 0; c < TRIANGLE_SIZE; c++) { // column
                data[r][c] = inputNumbers(data, r, c);
                if (c == r) {
                    c = TRIANGLE_SIZE;//exit c loop
                }
            }
        }
        displayArray(data);
    }

    public static int inputNumbers(int[][] data, int r, int c) {
        if (c == 0 || c == r) {
            return 1;
        } else if (c != 0) {//add together data at row above column 1 left+ row above and same column
            return (inputNumbers(data, r - 1, c - 1) + inputNumbers(data, r - 1, c));
        }
        return -1;
    }

    public static void displayArray(int[][] data) {//display 2d array neatly
        int tab;
        for (int row = 0; row < data.length; row++) {
            for (tab = TRIANGLE_SIZE - row; tab > 0; tab--) {//makes it look nice
                System.out.print("   ");    //3 spaces, half of the 6 spaces below. therefore
                                            // can be numbers in between other numbers (in 
                                            //comparison to columns in rows above and below
            }
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] > 0) {
                    System.out.format("%-6d", data[row][col]);//format 6 apart
                }
            }
            System.out.println();
        }
    }
    
        public static void displayArray2(int[][] data) {//display 2d array neatly
        int tab;
        for (int row = 0; row < data.length; row++) {
            for (tab = TRIANGLE_SIZE - row; tab > 0; tab--) {//makes it look nice
                System.out.print("   ");    
            }
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] % 2 == 1) {
                    System.out.format("%-6s", "x");//format 6 apart
                } else {
                    System.out.format("%-6s", " ");
                }
            }
            System.out.println();
        }
    }
}



