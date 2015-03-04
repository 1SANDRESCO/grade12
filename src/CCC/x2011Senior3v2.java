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
public class x2011Senior3v2 {

    /**
     * @param args the command line arguments
     */
    public static int[][] window;
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
            window = new int[ (int) Math.pow(5, m)][ (int)Math.pow(5, m)];//just made window, now enter good spots
            
            x = data[1];
            y = data[2];
        }
    }
    public static void solve (){
        
    }
    public static void enterGoodSpots( int m, int pass, int startX, int startY){//pass must start at magnification 1
        
        for (int i = startX; i < startX + 3; i++){
            window[startY][i] = 1;
            
        }
        window[startX + 1][startY + 1] = 1;
        //if (pass !=)
       
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
