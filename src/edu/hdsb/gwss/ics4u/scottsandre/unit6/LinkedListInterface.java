/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit6;

/**
 * Lesson: 6.03 - Linked List
 */
public interface LinkedListInterface {

    public int size();
    
    public void makeEmpty();
    
    /**
     * Adds a node to the front of the linked list .
     *
     * @param str
     */
    public void addAtFront( String str );
    
    /**
     * Adds a node to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd( String str );
    
    /**
     * Deletes a node in the linked list.
     *
     * @param str
     */
    public void remove( String str );

    /**
     * Creates a string that lists the nodes of the linked list.
     *
     * @param str
     */
    public void toString( String str );

}