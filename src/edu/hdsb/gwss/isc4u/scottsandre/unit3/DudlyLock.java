/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

/**
 *
 * @author 1SANDRESCO
 */
public class DudlyLock extends Lock {
public static int MAX_VALUE = 59;
public DudlyLock(){
  this( 
                (int) ( Math.random() * (MAX_VALUE + 1) ), 
                (int) ( Math.random() * (MAX_VALUE + 1) ), 
                (int) ( Math.random() * (MAX_VALUE + 1) ) 
        );   
} 

public DudlyLock(int digit01, int digit02, int digit03){
    if (digit01 < 0){
        digit01 = digit01 * -1;
    }
    if (digit02< 0){
        digit02 = digit02 * -1;
    }
    if (digit03 < 0){
        digit03 = digit03 * -1;
    }
this.setCombo(digit01, digit02, digit03);
}
}
