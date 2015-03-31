/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import java.text.NumberFormat;


public class ScottArrayUtil {

    public static int comps;
    public static int swps;
    

    public static void bubbleSortArray(String[] strData, int[][] intData) {
        for (int pass = 0; pass < strData.length - 1; pass++) {
            for (int i = 1; i < strData.length - pass; i++) {
                if (strData[i].compareToIgnoreCase(strData[i - 1]) < 0) {
                    ScottArrayUtil.swap(strData, intData, i, i - 1);
                }
            }
        }
    }

    public static void bubbleSortArray(String[] strData, int[][] intData, int col) {
        NumberFormat nf = NumberFormat.getInstance();
        final boolean MIN = false;
        final boolean MAX = true;
        col = col - 2;
        double sum;
        int max;
        int min;
        double average;
        String maxS;
        String minS;
        String avgS;
        if (col != -101) {
            sum = determineSum(intData, col);
            average = sum / intData.length;
            min = calculateMaxOrMinInt(intData, col, MIN);
            max = calculateMaxOrMinInt(intData, col, MAX);
            avgS = nf.format(average);
            minS = nf.format(min);
            maxS = nf.format(max);
             
             System.out.println("xx  Max is: " + maxS + "  xx  Min is: " + minS + "  xx  Avg is: " + avgS+ "  xx");
        }
        for (int pass = 0; pass < strData.length + 1; pass++) {
            for (int i = 1; i < strData.length; i++) {
                if (col != -101) {
                    if (intData[i][col] > intData[i - 1][col]) {
                        ScottArrayUtil.swap(strData, intData, i - 1, i);
                    }
                } else {
                    if (intData[i][0] < intData[i - 1][0]) {
                        ScottArrayUtil.swap(strData, intData, i - 1, i);
                    }
                }
            }
        }
       

    }

    public static double determineSum(int data[][], int col) {
        double sum = 0;
        for (int row = 0; row < data.length; row++) {
            sum = sum + data[row][col];
        }
        return sum;

    }

    public static int calculateMaxOrMinInt(int data[][], int col, boolean hOrL) {

        int wantedInt = data[0][col];
        for (int i = 1; i < data.length; i++) {
            if (hOrL == true && data[i][col] > wantedInt) {//wants MAX
                wantedInt = data[i][col];
            } else if (hOrL == false && data[i][col] < wantedInt) {//MIN
                wantedInt = data[i][col];
            }
        }
        return wantedInt;
    }

    public static void swap(String[] strData, int[][] intData, int i, int j) {
        String holderString;
        int[] holderIntArray = new int[j];

        holderString = strData[i];
        strData[i] = strData[j];
        strData[j] = holderString;

        holderIntArray = intData[i];
        intData[i] = intData[j];
        intData[j] = holderIntArray;

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int linearSearch(int[] data, int value) {
        int loc = -1;
        for (int i = 0; i < data.length; i++) {
            if (value == data[i]) {
                loc = i;
                i = data.length;
            }
        }
        return loc;
    }

    public static int binarySearch(int[] data, int value) {
        selectionSortArray(data);
        int loc = -1;
        int left = 0;
        int right = data.length - 1;
        int mid;

        while (left <= right) {
            mid = ((right - left) / 2) + left;
            if (value == data[mid]) {
                loc = mid;
                return loc;
            } else if (value > data[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return loc;
    }

    ///////////////////////////////////////////////////////////////////// 
    public static double roundTwoDecimals(double x) {
        double round = 0.0;
        round = (Math.round(x * 100)) / 100;
        return round;
    }

    /////////////////////////////////////////////////////////////////////   
    public static void flipArray(int[] data) {
        int holder;
        for (int col = 0; col < data.length / 2; col++) {
            swap(data, col, data.length - 1 - col);
        }
    }

    public static void flipArray(int[][] data) {
        int holder;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length / 2; col++) {  // integer division truncates anyways               
                holder = data[row][col];
                data[row][col] = data[row].length - 1 - col;
                data[row][data[row].length - 1 - col] = holder;
            }
        }
    }

    /////////////////////////////////////////////////////////////////////    
    public static int[] randomArray(int min, int max, int length) {
        int[] data = new int[length];
        for (int i = 0; i < data.length; i++) {
            data[i] = min + (int) (Math.random() * max);
        }
        return data;
    }

    public static int[][] randomArray(int min, int max, int rows, int cols) {
        int[][] data = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = min + (int) (Math.random() * max);
            }
        }
        return data;

    }

    /////////////////////////////////////////////////////////////////////    
    public static void swap(int[] data, int i, int j) {
        int holder;
        holder = data[i];
        data[i] = data[j];
        data[j] = holder;
    }

    /////////////////////////////////////////////////////////////////////   
    public static void bubbleSortArray(int[] data) {
        comps = 0;
        swps = 0;
        for (int pass = 0; pass < data.length - 1; pass++) {

            for (int i = 0; i < data.length - 1 - pass; i++) {
                comps++;
                if (data[i] > data[i + 1]) {
                    ScottArrayUtil.swap(data, i, i + 1);
                    swps++;
                }
            }
        }
    }

    public static void selectionSortArray(int[] data) {
        comps = 0;
        swps = 0;
        int maxIndex;
        for (int pass = 0; pass < data.length - 1; pass++) {
            maxIndex = 0;

            for (int i = 1; i < data.length - pass; i++) {
                comps++;
                if (data[i] > data[maxIndex]) {
                    maxIndex = i;

                }
            }
            ScottArrayUtil.swap(data, maxIndex, data.length - pass - 1);
            swps++;
        }
    }

    /////////////////////////////////////////////////////////////////////
    public static double calculateAverage(int data[]) {
        double average = 0;
        average = (double) calculateSum(data) / data.length;
        return average;
    }

    public static double calculateAverage(int data[][]) {
        double average = 0;
        int count = 0;//make for loop to count
        average = (double) calculateSum(data) / data.length;
        return average;
    }

    /////////////////////////////////////////////////////////////////////   
    public static int calculateSum(int data[]) { // 1D
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }

    public static int calculateSum(int data[][]) {
        int sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += calculateSum(data[i]);
        }
        return sum;
    }

    /////////////////////////////////////////////////////////////////////
    public static int determineMaxOrMinInt(int data[], boolean hOrL) {//1D MAX
        int wantedInt = data[0];
        for (int i = 1; i < data.length; i++) {
            if (hOrL == true && data[i] > wantedInt) {//wants highest int                
                wantedInt = data[i];
            } else if (hOrL == false && data[i] < wantedInt) {//wants lowest int
                wantedInt = data[i];
            }
        }
        return wantedInt;
    }

    public static int determineMaxOrMinInt(int data[][], boolean hOrL) {//2D
        int wantedInt = determineMaxOrMinInt(data[0], hOrL);
        int wantedRowInt;

        for (int i = 1; i < data.length; i++) {
            wantedRowInt = determineMaxOrMinInt(data[i], hOrL);
            if (hOrL == true && wantedInt < wantedRowInt) {
                wantedInt = wantedRowInt;
            } else if (hOrL == false && wantedInt > wantedRowInt) {
                wantedInt = wantedRowInt;
            }
        }
        return wantedInt;
    }

    /////////////////////////////////////////////////////////////////////  
    public static void displayArray(int[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                System.out.print(data[row][col] + ",");
            }
            System.out.println();
        }
    }

    public static void displayArray(int[] data) {
        for (int col = 0; col < data.length; col++) {
            System.out.print(data[col] + ",");
        }
    }
    /////////////////////////////////////////////////////////////////////

}


