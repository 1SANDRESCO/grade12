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

    public static Node head ;
    public static Node tail ;

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
        Node newNode = new Node(str);
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    @Override
    public void remove(String str) {
        Node n = head;
        //Node previousN = new Node(null);
        if (head.getData().equalsIgnoreCase(str)) {
            head = head.getNext();
        } else {
            
           // while (n.get)
            
            do   {//does not equal string
                if (n.getNext().getData().equalsIgnoreCase(str)){   
                    n.setNext(n.getNext().getNext());
                    n.getNext().setNext(null);
                    System.out.println(str + " removed.");
                    n = n.getNext();
                } else {
                   n = n.getNext(); 
                   System.out.println("x");
                }
            } while (!n.getNext().getData().equalsIgnoreCase(str));

            
        }
    }
//    n = n.getNext();
//            do   {//does not equal string
//                if (n.getData().equalsIgnoreCase(str)) {
//                    previousN.setNext(n.getNext().getNext());
//                    n.setNext(null);
//                } else {
//                    previousN = n;
//                    n = n.getNext();
//                }
//            } while (!n.getData().equalsIgnoreCase(str));

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
        System.out.println("Linked Lists: ");

        System.out.println();
        System.out.println("Test Case 1: create new LinkedList");
        LinkedList l = new LinkedList();
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 2: add node 'Scott' at FRONT");
        l.addAtFront("Scott");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 3: add 3 other names to front");
        l.addAtFront("Thomas");
        l.addAtFront("Alex");
        l.addAtFront("Tyler");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 4: add 'Nick' to back");
        l.addAtEnd("Nick");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 5: add 'Ricky' to back");
        l.addAtEnd("Ricky");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 6: remove 'Tyler' (front)");
        l.remove("Tyler");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 7: make empty ");
        LinkedList l2 = new LinkedList();
        l2.addAtFront("One");
        l2.addAtFront("Two");
        l2.addAtFront("Three");
        l2.addAtFront("Four");
        l2.addAtFront("Five");
        System.out.println("Before: size is " + l2.size() + "\n" + l2.toString());
        l2.makeEmpty();
        System.out.println("After: size is " + l2.size() + "\n" + l2.toString());
        
        
//        System.out.println();
//        System.out.println("Test Case 7: remove 'Scott' (middle)");
//        l.remove("Scott");
//        System.out.println(l.toString());
//        System.out.println("List size: " + l.size());
        
        
        
    }

}
