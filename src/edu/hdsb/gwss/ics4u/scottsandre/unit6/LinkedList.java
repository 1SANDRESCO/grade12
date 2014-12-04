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
    public void remove(String str) {
        Node n = head;
        int x = 1;
        boolean found = false;
        //Node previousN = new Node(null);
        if (head.getData().equalsIgnoreCase(str)) {
            head = head.getNext();
        } else {
            //try {
            while (found == false) {
                if (n.getNext().getData().equalsIgnoreCase(str)) {//next one is string
                    n.setNext(n.getNext().getNext());
                    if (x == size()) {
                        this.tail = n;
                    }
                    
                    n = n.getNext();
                    n = null;
                    
                    found = true; //what if it is at the end. must set tail
                } else {
                    x++;
                    System.out.println(x);
                    if (x == size()){
                        System.out.println("that string does not exist");
                        found = true;//exit, not found tho as it does not exist
                    } else {
                    n = n.getNext();
                    }
                }
            }
            //}
            // catch (NullPointerException e){

            //}
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
        System.out.println("Test Case 6: remove 'Tyler' (front) exists");
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
        
        System.out.println();
        System.out.println("Test Case 8: remove 'Scott' (middle) exists");
        l.remove("Scott");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 9: remove 'Ricky' (last) exists");
        l.remove("Ricky");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 10: add 'Jared' at end after end has been removed");
        l.addAtEnd("Swagboi Jared");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 11: add another name at end after end was removed");
        l.addAtEnd("T Law");
        l.addAtFront("Brad");
        System.out.println(l.toString());
        System.out.println("List size: " + l.size());
        
        System.out.println();
        System.out.println("Test Case 12: remove name, does not exist");
        l.remove("asdf");
        System.out.println("List size: " + l.size());

        LinkedList l3 = new LinkedList();
        System.out.println("Linked list 3: ");
        l3.addAtEnd("Batman");
        l3.addAtFront("Joker");
        l3.addAtEnd("Superman");
        System.out.println(l3.toString());
        
        LinkedList l4 = new LinkedList();
        System.out.println("Linked list 4: ");
        l4.addAtEnd("Happy");
        l4.addAtFront("Mad");
        l4.addAtEnd("Sad");
        System.out.println(l4.toString());
        
        System.out.println("Make linked list 3 empty: ");
        l3.makeEmpty();
        System.out.println("Linked list 3 should be empty: ");
        System.out.println(l3.toString());
        System.out.println("Linked list 4 should be fine: ");
        System.out.println(l4.toString());
        System.out.println(l4.size());
        
        
        
        

    }

}
