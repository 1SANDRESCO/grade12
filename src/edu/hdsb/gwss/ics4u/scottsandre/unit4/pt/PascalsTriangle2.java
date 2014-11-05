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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(term(6,3));
        row(7);
    }
    
    public static int term (int r, int c){
        if (c == 0 || c == r){
            return 1;
        }
        return term (r - 1, c - 1) + term (r - 1, c);
        
    }
    
    public static int row (int r){
     return 0;   
    }
    
}
