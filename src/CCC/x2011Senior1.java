/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC;

import java.util.Scanner;

/**
 *
 * @author Scott
 */
public class x2011Senior1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        String answer = "English";
        int n = Integer.parseInt(input.nextLine() );
        int sSum = 0;
        int tSum = 0;
        String s = "";
        for (int i = 0; i < n; i++){
            s = input.nextLine();
           
            for (int k = 0; k < s.length(); k++){
                if ( (s.charAt(k) + "").equalsIgnoreCase("t") ) tSum++;
                if ( (s.charAt(k) + "").equalsIgnoreCase("s") ) sSum++;
            }
        }
        
        if (sSum > tSum || sSum == tSum) answer = "French";
        System.out.println(answer);
        
    }
    
}
