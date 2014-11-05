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

    public static int row;
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
        String s = "";
        if (r == 0){
            System.out.print("1");  
            return "1";
        }
        for (int c = 0; c < r; c++){
            s += System.out.format("%-6d", term(r - 1 , c));
        }
        return s;
        
    }
    
//    public static String row (int r){
//        
//        if (r == 0){
//            System.out.print("1");
//            return "1";
//        }
//        for (int c = 0; c < r; c++){
//            System.out.format("%-6d", term(r - 1 , c));
//        }
//        System.out.print("\n");
//        row (r - 1 );
//     return null;   
//    }
    
}
