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
public static final int TRIANGLE_SIZE = 12;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Pascal's Triangle: ");
        int[][] data = new int[TRIANGLE_SIZE][TRIANGLE_SIZE];
        
        for (int r = 0; r < TRIANGLE_SIZE; r++) {
            for (int c = 0; c < TRIANGLE_SIZE; c++) {
                data[r][c] = inputNumbers(data, r, c);
                if (c == r){
                    c = TRIANGLE_SIZE ;
                }
            }
        }    
        displayArray(data);
    }
    
    public static int inputNumbers(int[][] data, int r, int c ){
    if (c == 0 || c == r){
        return 1;
    } 
    else if (c != 0){
        return ( inputNumbers(data, r - 1, c -1) + inputNumbers(data, r - 1, c) );
    }
    return -1;
    }

  
    
     public static void displayArray(int[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] > 0){
                System.out.format("%-6d", data[row][col] );
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }
}
