/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit3;

/**
 *
 * @author 1SANDRESCO
 */
public class MasterLock extends Lock{
    
    public static final int MAX_VALUE = 39;
    public static final int NUMBER_VALUES = 3;

public MasterLock(){
//super();  
    
this( 
                (int) ( Math.random() * MAX_VALUE + 1 ), 
                (int) ( Math.random() * MAX_VALUE + 1 ), 
                (int) ( Math.random() * MAX_VALUE + 1 ) 
                 
        );    
}

public MasterLock(int digit01, int digit02,int digit03){
 this.setCreated(true);
 this.setCombo(digit01, digit02, digit03);
}

@Override
    public String toString() {
        return "MasterLock{ combo = " + this.getCombo(NUMBER_VALUES) + '}';
}




}
