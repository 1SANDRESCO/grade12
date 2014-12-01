/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

public interface NodeInterface {
    
    /**
     * The node pointed to by 'next' is returned
     */
    public Node getNext();
    
    /**
     * The node pointed to by 'next' is changed to newNode
     */
    public void setNext( Node newNode );
    
    /**
     * The node pointed to by 'next' is returned.
     */
    public String getData(  );
}