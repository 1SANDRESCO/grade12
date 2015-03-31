/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECOO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Scott
 */
public class Question1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("DATA11.txt");
        ArrayList<String> stringData = new ArrayList();
        Scanner input = new Scanner(file);
        int[] answers = new int[10];
        while (input.hasNext()) {

            stringData.add(input.nextLine());

        }

        int[] data = new int[stringData.size()];

        for (int i = 0; i < data.length; i++) {
            switch (stringData.get(i)) {
                case "orange":
                    data[i] = 1;
                    break;
                case "blue":
                    data[i] = 2;
                    break;
                case "green":
                    data[i] = 3;
                    break;
                case "yellow":
                    data[i] = 4;
                    break;
                case "pink":
                    data[i] = 5;
                    break;
                case "violet":
                    data[i] = 6;
                    break;
                case "brown":
                    data[i] = 7;
                    break;
                case "red":
                    data[i] = 8;
                    break;
                case "end of box":
                    data[i] = 9;//END OF BOX
                    break;
            }
        }
        
        int thisNine = 0;
        int nextNine = search(data, 0);

        for (int testCase = 0; testCase < 10; testCase++) {
            int time = 0;
            int numOfColour;
            
            
            for (int i = 1; i < 8; i++) {
                numOfColour = countNumbers(data, i, thisNine, nextNine);
                time = time + (int) (Math.ceil(numOfColour / 7.0) * 13);
            }

            time = time + (countNumbers(data, 8, thisNine, nextNine) * 16);
            
            thisNine = nextNine;
            nextNine = search(data, thisNine + 1);
            System.out.println(time);
        }
        //now we have a sorted data

    }
    
    public static int search(int[] data, int start){
        int loc = -1;
        for (int i = start; i < data.length; i++){
            if (data[i] == 9){
                loc = i;
                i = data.length;
            }
        }
        return loc;
    }

    public static int countNumbers(int[] data, int x, int startIndex, int endIndex) {
        int count = 0;
        for (int i = startIndex; i < endIndex; i++) {
            if (data[i] == x) {
                count++;
            }
        }
        return count;
    }

//    public static void bubbleSort(int[] data) {
//        for (int pass = 0; pass < data.length - 1; pass++) {
//            for (int i = 0; i < data.length - 1 - pass; i++) {
//                if (data[i] > data[i + 1]) {
//                    swap(data, i, i + 1);
//                }
//            }
//        }
//    }
//
//    public static void swap(int[] data, int i, int j) {
//        int holder = data[i];
//        data[i] = data[j];
//        data[j] = holder;
//    }
}
