/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

/**
 *
 * @author Owner
 */
public class LinkedList implements LinkedListInterface {

    public static Node head = new Node(null);
    public static Node tail = new Node(null);

    public LinkedList() {

    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void addAtFront(String str) {
        Node newNode = new Node(str);
        newNode.setNext(head);
        head = newNode;
    }

    @Override
    public void addAtEnd(String str) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(String str) {
        Node n = head;
        Node previousN = new Node(null);
        if (head.getData().equalsIgnoreCase(str)) {
            head = head.getNext();
        } else {
            while (!n.getData().equalsIgnoreCase(str)) {//does not equal string
                if (n.getData().equalsIgnoreCase(str)) {
                    previousN.setNext(n.getNext().getNext());
                    n.setNext(null);
                } else {
                    previousN = n;
                    n = n.getNext();
                }

            }
        }
    }

    @Override
    public String toString() {
        if (head != null) {
            Node n = head;
            do {
                System.out.println(n.getData());
                n = n.getNext();
            } while (n != null);
        }
        return null;
    }

}
