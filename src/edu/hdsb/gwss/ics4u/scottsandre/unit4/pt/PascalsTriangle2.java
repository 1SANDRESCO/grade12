/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4.pt;

/**
 *
 * @author 1SANDRESCO
 */
public class PascalsTriangle2 {

    public static int startRow;
    public static boolean doOnce = true;
    public static void main(String[] args) {
        //System.out.println(term(6,3));
 
        row(10);
       
    }
    
    public static int term (int r, int c){
        if (c == 0 || c == r){
            return 1;
        }
        return term (r - 1, c - 1) + term (r - 1, c);
        
    }
    public static String row (int r){ 
        if (doOnce){
            startRow = r;
            doOnce = false;
        }
        String s = "";
        if (r < 0){ 
            return "";
        }
        for (int c = 0; c < r; c++){
            s += term(r - 1 , c) + "      ";
        } 
        
        System.out.println( row(r-1) + s);
       // System.out.format("%-7s", s + row(r-1) + "\n");
        
        
        for (int tab = startRow - r; tab > 0; tab--){
            System.out.print("    ");
        }
        return "";
        
    }
    

    
}
