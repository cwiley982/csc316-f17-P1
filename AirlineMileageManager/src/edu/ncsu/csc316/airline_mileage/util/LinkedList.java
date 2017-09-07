package edu.ncsu.csc316.airline_mileage.util;

public class LinkedList<E extends Comparable<E>> {
    
    private Node<E> front;
    private int size;
    
    /**
     * Constructs a linked list
     */
    public LinkedList() {
        front = null;
        size = 0;
    }
    
    /**
     * Adds an element to the list
     * 
     * @param element
     *            element to add to the list
     * @return true if element can be added
     */
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (contains(element)) {
            throw new IllegalArgumentException();
        }
        
        if (front == null || element.compareTo((E) front.value) == -1) {
            // element comes before current, add to front
            front = new Node<E>(element, front);
            size++;
            return true;
        }
        
        Node<E> current = front;
        boolean cont = true;
        while (cont) {
            if (current.next == null || element.compareTo((E) current.next.value) == -1) {
                // next value is null, element has to be next OR
                // element comes before next but after current, stop traversing
                cont = false;
            } else if (element.compareTo((E) current.next.value) == 1) {
                // element comes after next node, keep traversing list
                current = current.next;
            }
        }
        current.next = new Node<E>(element, current.next);
        size++;
        return true;
    }
    
    public boolean contains(E element) {
        Node<E> current = front;
        for (int i = 0; i < size; i++) { // checks entire list for a duplicate
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (E) current.value;
    }
    
    public int indexOf(E element) {
        Node<E> current = front;
        for (int i = 0; i < size; i++) {
            if (current.value == element) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> removedNode = null;
        if (index == 0) {
            removedNode = front;
            front = front.next;
        } else {
            Node<E> current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = current.next.next;
        }
        size--;
        return (E) removedNode.value;
    }
    
    public int size() {
        return size;
    }
    
    /**
     * Creates Nodes to be held by LinkedList
     * 
     * @author Caitlyn
     *
     */
    @SuppressWarnings("hiding")
    public class Node<E> {
        /** Value of the node */
        E value;
        private Node<E> next;
        
        /**
         * Constructs a node with an element and a reference to the next node in
         * the list
         * 
         * @param element
         *            the element for the node to hold
         * @param node
         *            the next node after the one being created
         */
        public Node(E element, Node<E> node) {
            if (element == null) {
                throw new NullPointerException();
            }
            value = element;
            next = node;
        }
    }
}
