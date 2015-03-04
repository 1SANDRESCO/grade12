/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class x2011Senior3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String s = "";
        int[] data = new int[3];
        String answer = "";
        int m, x, y;
        for (int i = 0; i < n; i++) {
            answer = "crystal";
            s = input.nextLine();
            s = s + " ";
            data = fromStringToArray(s, data);//m, x, y
            m = data[0];
            x = data[1];
            y = data[2];
            if (x < Math.pow(5, m) / 5 || x > 4 * Math.pow(5, m) / 5) answer = "empty";
            else if (y > 3*Math.pow(5, m)/5) answer = "emtpy";
            else if (y > 2*Math.pow(5,m)/5 && x < 2*Math.pow(5,m)/5    ||     y > 2*Math.pow(5,m)/5 && x > 4*Math.pow(5,m)/5) answer = "empty";
                
            
        }
    }

    public static int[] fromStringToArray(String s, int[] data) {
        int space1 = s.indexOf(" ", 0);
        int m = Integer.parseInt(s.substring(0, space1));
        space1++;
        int space2 = s.indexOf(" ", space1);
        int x = Integer.parseInt(s.substring(space1, space2));
        space1++;
        space2 = s.indexOf(" ", space1);
        int y = Integer.parseInt(s.substring(space1, space2));
        data[0] = m;
        data[1] = x;
        data[2] = y;
        return data;
    }

}
