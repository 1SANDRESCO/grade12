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
public class MasterULock {
    public static final int MAX_VALUE = 9;

public MasterULock(){
    
this( 
                (int) ( Math.random() * (MAX_VALUE + 1)), 
                (int) ( Math.random() * (MAX_VALUE + 1 )), 
                (int) ( Math.random() * (MAX_VALUE + 1 )) ,
                (int) ( Math.random() * (MAX_VALUE + 1 )) 
        );    
}

public MasterULock(int digit01, int digit02,int digit03,int digit04){
}   
}
