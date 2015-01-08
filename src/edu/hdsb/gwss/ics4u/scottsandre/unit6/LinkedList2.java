/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

public class LinkedList2 {

    private Chair head, tail;

    public LinkedList2() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        int size = 0;
        Chair n = this.head;
        if (n != null) {
            do {
                size++;
                n = n.getNext();
            } while (n != null);
        }
        return size;
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;

    }

    public void addAtFront(Chair c) {
        Chair newNode = c;
        if (size() == 0) {
            this.tail = newNode;
        }
        
        newNode.setNext(this.head);

        this.head = newNode;

    }

    public void addAtEnd(Chair c) {

        if (size() == 0) {
            addAtFront(c);
        } else {
            Chair newNode = c;
            this.tail.setNext(newNode);
            newNode.setPrevious(this.tail);
            this.tail = newNode;
        }
    }

    public void remove(int key) {//fix so it works even if list is empty
        if (!isEmpty()) {
            Chair n = head;
            int x = 1;
            boolean found = false;
            //Node previousN = new Node(null);
            if (head.getSerialNumber() == key) {
                head = head.getNext();
            } else if (size() > 1) {
                while (!found){
                    if ( n.getNext().getSerialNumber() == key) {//next one is it
                        n.setNext(n.getNext().getNext());
                        n.getNext().getNext().setPrevious(n);
                        //tail what to do with it
                    } else {//next one is not it
                       x++;
                       if (x == size()){
                           found = true;//exit, NOT found
                       } else {
                           n = n.getNext();
                       }
                    }
                    
                }
                while (found == false) {
                    if (n.getNext().getSerialNumber() == key) {//next one is string
                        n.setNext(n.getNext().getNext());
                        if (x == size()) {
                            this.tail = n;
                        }

                        n = n.getNext();
                        n = null;

                        found = true; //what if it is at the end. must set tail
                    } else {
                        x++;

                        if (x == size()) {
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

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        String s = "";
        if (this.head != null) {
            Chair n = this.head;
            do {
                if(n == head){
                    s = s + "HEAD --";
                } 
                if (n == tail){
                    s = s + "TAIL --";
                }
                s = s + n.toString() + "\n";

                n = n.getNext();
            } while (n != null);

        }
        return s;
    }
    
    public static void main(String[] args) {
        LinkedList2 l = new LinkedList2();
        System.out.println(l.size() + "  " +  l.isEmpty());
        Chair c1 = new Chair(15, 22.2, "Maple");
        Chair c2 = new Chair(15, 22.2, "Maple");
        Chair c3 = new Chair(44, 33.676, "Oak");
        Chair c4 = new Chair(1, 1.2, "A");
        Chair c5 = new Chair(33, 234423.2, "Red");
        Chair c6 = new Chair (123, 321, "asdf");
        Chair c7 = new Chair (99, 99, "99");
        Chair c8 = new Chair (55, 15.2, "Yellow Submarine");
        l.addAtFront(c1);
        l.addAtFront(c2);
        l.addAtEnd(c3);
        System.out.println(l.toString());
        System.out.println(l.size() + "  " +  l.isEmpty());
    
    }   

}



