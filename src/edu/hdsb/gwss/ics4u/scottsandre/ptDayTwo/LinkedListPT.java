package edu.hdsb.gwss.ics4u.scottsandre.ptDayTwo;

/**
 * Linked List of Students
 *
 * @version v2014.S1
 */
public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        int size = 0;
        NodePT n = this.head;
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

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    private void addAtFront(CSStudent student) {
        NodePT newNode = new NodePT(student);
        if (size() == 0) {
            this.tail = newNode;
        }

        newNode.setNext(this.head);

        this.head = newNode;

    }

    public void addAtEnd(CSStudent student) {
        if (size() == 0) {
            addAtFront(student);
        } else {
        NodePT newNode = new NodePT(student);
        this.tail.setNext(newNode);
        this.tail = newNode;
        }
    }

    /**
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get(int key) {
        NodePT n = head;
        //CSStudent s;
        if (!isEmpty()) {
            
            int x = 1;
            boolean found = false;
            //Node previousN = new Node(null);
            if (head.getData().getStudentNumber() == key) {
                
                return head.getData();
            } else if (size() > 1) {
                while (found == false) {
                    if (n.getNext().getData().getStudentNumber() == key) {//next one is it
                        n = n.getNext();
                        return n.getData();
                  
                    } else {//next one is not it
                        x++;
                        if (x == size()) {
                            found = true;//exit, NOT found, end 
                            return null;
                        } else {
                            n = n.getNext();
                        }
                    }

                }

            }
        }
        return null;
    }

    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not
     * found
     */
    public CSStudent remove(int key) {
        NodePT n = head;
        if (!isEmpty()) {
            int x = 1;
            boolean found = false;
            //Node previousN = new Node(null);
            if (head.getData().getStudentNumber() == key) {
                head = head.getNext();
                return head.getData();
            } else if (size() > 1) {
                while (found == false) {
                    if (n.getNext().getData().getStudentNumber() == key) {//next one is it
                        CSStudent s = n.getNext().getData();
                        n.setNext(n.getNext().getNext());
                        if (x == size()) {//because size is now one less and node was at end
                            this.tail = n;
                        }
                        n = null;
                        return s;

                        
                    } else {//next one is not it
                        x++;
                        if (x == size()) {
                            found = true;//exit, NOT found
                        } else {
                            n = n.getNext();
                        }
                    }

                }

            }
        }
        return n.getData();
    }

    /**
     * DONE FOR YOU
     */
    @Override
    public String toString() {
        return "HEAD: " + toString(this.head);
    }

    /**
     * DONE FOR YOU
     */
    private String toString(NodePT n) {
        String s = "";
        if (n != null) {
            s = n.getData() + " --> " + this.toString(n.getNext());
        }
        return s;
    }

}
