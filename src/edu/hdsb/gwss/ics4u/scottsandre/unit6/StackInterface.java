/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit6;



/**
 * Lesson: 6.01 - Stacks
 */
public interface StackInterface {

    public int top();

    public int pop();

    public void push( int num );

    public int size();

    public boolean isEmpty();

    public void makeEmpty();
    
    public boolean isFull();

}