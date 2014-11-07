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

        row(10
        );

    }

    public static int term(int r, int c) {
        if (c == 0 || c == r) {//left side or right side is 1
            return 1;
        }
        return term(r - 1, c - 1) + term(r - 1, c);//a not 1 term is sum of above two terms

    }

    public static String row(int r) {
        if (doOnce) {//save the initial row value first passed to triangle
            startRow = r;
            doOnce = false;
        }
        String s = "";
        if (r < 0) { //stop when less than 0
            return "";
        }
        for (int c = 0; c < r; c++) {
            s += term(r - 1, c) + "      ";//string is term above, same column
        }
        System.out.println(row(r - 1) + s);
        for (int tab = startRow - r; tab > 0; tab--) {
            System.out.print("    ");//print out tab to format it and make it look nice
        }
        return "";

    }

}
