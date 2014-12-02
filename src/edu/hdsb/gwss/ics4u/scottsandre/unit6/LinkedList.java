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
        this.head.setNext(tail);
    }

    @Override
    public int size() {
        int size = -1;
        Node n = head;
        if (n != null) {
            do {
                size++;
                n = n.getNext();
            } while (n.getNext() != null);
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
        newNode.setNext(this.head);
        
        this.head = newNode;
        
        if (size() == 0) {
            this.head.setNext(tail);
        }
        

    }

    @Override
    public void addAtEnd(String str) {
        Node newNode = new Node(str);
        this.tail.setNext(newNode);
        this.tail = newNode;
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
        if (this.head != null) {
            
            Node n = this.head;
            do {
                System.out.println(n.getData());
                n = n.getNext();
            } while (n.getData() != null);
//            if (tail.getData() != null){
//                System.out.println(tail.getData());
//            }
        }
        return "A";
    }

    public static void main(String[] args) {
        System.out.println("Linked Lists: ");

        System.out.println();
        System.out.println("Test Case 1: create new LinkedList");
        LinkedList l = new LinkedList();
        l.toString();
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 2: add node 'Scott' at FRONT");
        l.addAtFront("Scott");
        l.toString();
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 3: add 3 other names to front");
        l.addAtFront("Thomas");
        l.addAtFront("Alex");
        l.addAtFront("Tyler");
        l.toString();
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 4: add 'Nick' to back");
        l.addAtEnd("Nick");
        l.toString();
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 4: add 'Ricky' to back");
        l.addAtEnd("Ricky");
        l.toString();
        System.out.println("List size: " + l.size());
        
        System.out.println("New test case: add 'scotty' to back or new linked list");
        LinkedList l2 = new LinkedList();
        //l2.toString();
        //l2.addAtEnd("scotty");
       // l2.toString();
    }

}
