/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

import edu.hdsb.gwss.muir.ics4u.u6.LinkListInterface;

/**
 *
 * @author Owner
 */
public class LinkedList implements LinkListInterface {

    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() {
        int size = 0;
        Node n = this.head;
        if (n != null) {
            do {
                size++;
                n = n.getNext();
            } while (n != null);
        }
        return size;
    }

    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        
    }

    @Override
    public void addAtFront(String str) {
        Node newNode = new Node(str);
        if (size() == 0) {
            this.tail = newNode;
        }

        newNode.setNext(this.head);

        this.head = newNode;

    }

    @Override
    public void addAtEnd(String str) {

        if (size() == 0) {
            addAtFront(str);
        } else {
            Node newNode = new Node(str);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    @Override
    public void remove(String str) {//fix so it works even if list is empty
        if (!isEmpty()){
        Node n = head;
        int x = 1;
        boolean found = false;
        //Node previousN = new Node(null);
        if (head.getData().equalsIgnoreCase(str)) {
            head = head.getNext();
        } else if (size() > 1) {
            //try {
            while (found == false) {
                if (n.getNext().getData().equalsIgnoreCase(str)) {//next one is string
                    n.setNext(n.getNext().getNext());
                    if (x == size() ) {//because size is now one less
                        System.out.println("test");
                        this.tail = n;
                    }
                    
                 
                    n = null;
                    
                    found = true; //what if it is at the end. must set tail
                } else {
                    x++;
                    
                    if (x == size()){
                        System.out.println("that string does not exist");
                        found = true;//exit, not found tho as it does not exist
                        
                    } else {
                    n = n.getNext();
                    }
                }
            }
           
        }
        }
    }
    
    @Override
    public boolean isEmpty() {
    if (size() == 0){
        return true;
    } else {
        return false;
    }
   
    }

    @Override
    public String toString() {
        String s = "";
        if (this.head != null) {
            Node n = this.head;
            do {
                s = s + n.getData() + "\n";
                //System.out.println(n.getData());
                n = n.getNext();
            } while (n != null);

        }
        return s;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();     
        ll.addAtFront("Scott");
        ll.addAtFront("jared");
        ll.addAtFront("Thomas");
        System.out.println(ll.size());
        ll.remove("Scott");
        System.out.println("t  " + ll.tail.getData());
        System.out.println(ll.toString());

//        // EMPTY
//        assert ( ll.size() == 0 );
//        assert ( ll.isEmpty() );
//
//        // REMOVE: EMPTY
//        System.out.println( "CASE 1: REMOVE NON EXISTING" );
//        ll.remove( "ABC" );
//
//        // ADD @ FRONT; SIZE 1
//        System.out.println( "CASE 2: ADD AT FRONT / REMOVE ONLY ELEMENT" );
//        ll.addAtFront( "ABC" );
//        System.out.println( "DATA: " + ll.toString() );
//        ll.remove( "ABC" );
//        assert ( ll.size() == 0 );
//        assert ( ll.isEmpty() );
//
//        // ADD @ END; SIZE 1
//        System.out.println( "CASE 3: ADD AT END / REMOVE ONLY ELEMENT" );
//        ll.addAtEnd( "ABC" );
//        System.out.println( "DATA: " + ll.toString() );
//        ll.remove( "ABC" );
//        assert ( ll.size() == 0 );
//        assert ( ll.isEmpty() );
//
//        // ADD @ FRONT; SIZE 2
//        System.out.println( "CASE 4: ADD AT FRONT / REMOVE 2 ELEMENT" );
//        ll.addAtFront( "ABC" );
//        ll.addAtFront( "XYZ" );
//        System.out.println( "DATA: " + ll.toString() );
//        assert ( ll.size() == 2 );
//        ll.remove( "XYZ" );
//        System.out.println( "DATA: " + ll.toString() );
//        assert ( ll.size() == 1 );
//        ll.remove( "ABC" );
//        System.out.println( "DATA: " + ll.toString() );
//
//        // ADD @ BACK; SIZE 2
//        System.out.println( "CASE 5: ADD AT END / REMOVE 2 ELEMENT" );
//        ll.addAtEnd( "ABC" );
//        ll.addAtEnd( "XYZ" );
//        System.out.println( "DATA: " + ll.toString() );
//        assert ( ll.size() == 2 );
//        ll.remove( "XYZ" );
//        System.out.println( "DATA: " + ll.toString() );
//        assert ( ll.size() == 1 );
//        ll.remove( "ABC" );
//        System.out.println( "DATA: " + ll.toString() );
//
//        // REMOVE; MIDDLE
//        System.out.println( "CASE 6: REMOVE TWO ELEMENTS" );
//        ll.addAtFront( "ABC" );
//        ll.addAtFront( "123" );
//        ll.addAtFront( "XYZ" );
//        System.out.println( "DATA: " + ll.toString() );
//        assert ( ll.size() == 3 );
//        ll.remove( "123" );
//        System.out.println( "DATA: " + ll.toString() );
//        assert ( ll.size() == 2 );
//        ll.remove( "XYZ" );
//        System.out.println( "DATA: " + ll.toString() );
//        assert ( ll.size() == 1 );
//        ll.remove( "ABC" );
//        System.out.println( "DATA: " + ll.toString() );

    }

    

}
