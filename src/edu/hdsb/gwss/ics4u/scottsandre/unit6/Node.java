/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;



public class Node  {
    
    private String data;
    private Node next;

    public Node( String newData ) {
        this.data = newData;
        this.next = null;
    }


    public Node getNext() {
         return next;   
    }

    
    public void setNext( Node newNode ) {
        this.next = newNode;
    }

    public String getData() {
        return data;
     }       

   
   
   

}