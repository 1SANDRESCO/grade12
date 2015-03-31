/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


 import edu.hdsb.gwss.ics3u.scottsandre.unit6.ScottArrayUtil;
 import java.io.File;
 import java.io.PrintWriter;
 import java.util.Scanner;

 /**
 *
 * @author 1SANDRESCO
 */
public class ReadIn01 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        File file1 = new File("output01.txt");
        PrintWriter output = new PrintWriter(file1);
        final int numberOfInts = 1000;
        final int rangeOfInts = 100;
        final int lowestPossibleInt = 1;
        int x;

        int[] data1 = new int[numberOfInts];
        int[] data2 = new int[numberOfInts];

        for (int i = 0; i < numberOfInts; i++) {
            x = (int) (Math.random() * rangeOfInts) + lowestPossibleInt;
            output.write(x + " ");
        }
        output.close();

        Scanner input = new Scanner(file1);

        int count = 0;
        while (input.hasNext()) {
            data1[count] = input.nextInt();
            data2[count] = data1[count];
            count++;

        }
        input.close();
        System.out.println("----");
        for (int i =0; i < data1.length; i++){
            System.out.print(data1[i] + ", ");
        }

    }

}
