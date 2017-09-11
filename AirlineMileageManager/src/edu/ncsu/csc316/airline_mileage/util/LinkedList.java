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
        if (front == null) {
            front = new Node<E>(element, null);
            size++;
            return true;
        } else {
            Node<E> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<E>(element, null);
            size++;
            return true;
        }
        
        /*
         * if (front == null || element.compareTo((E) front.value) < 0) { //
         * element comes before current, add to front front = new
         * Node<E>(element, front); size++; return true; }
         * 
         * Node<E> current = front; boolean cont = true; while (cont) { if
         * (current.next == null || element.compareTo((E) current.next.value) <
         * 0) { // next value is null, element has to be next OR // element
         * comes before next but after current, stop traversing cont = false; }
         * else if (element.compareTo((E) current.next.value) > 0) { // element
         * comes after next node, keep traversing list current = current.next; }
         * }
         */
    }
    
    public void sort() {
        front = mergeSort(this).front;
    }
    
    public LinkedList<E> mergeSort(LinkedList<E> list) {
        if (list.size() == 1) {
            return list;
        } else {
            // split into left and right, maybe use an iterator
            LinkedList<E> left = new LinkedList<E>();
            LinkedList<E> right = new LinkedList<E>();
            Node<E> current = list.front;
            
            int middle = (list.size() / 2) - 1;
            int index = 0;
            while (index <= middle) {
                left.add(current.value);
                current = current.next;
                index++;
            }
            while (index < list.size()) {
                right.add(current.value);
                current = current.next;
                index++;
            }
            
            left = mergeSort(left);
            right = mergeSort(right);
            return mergeParts(left, right);
        }
    }
    
    public LinkedList<E> mergeParts(LinkedList<E> left, LinkedList<E> right) {
        // merge parts similarly to in Miles
        LinkedList<E> merged = new LinkedList<E>();
        Node<E> leftCurrent = left.front;
        Node<E> rightCurrent = right.front;
        while (leftCurrent != null & rightCurrent != null) {
            if (leftCurrent.value.compareTo(rightCurrent.value) < 0) {
                // left comes before right, add node to end of merged list
                merged.add(leftCurrent.value);
                leftCurrent = leftCurrent.next;
            } else {
                // right comes before left, add node to end of merged list
                merged.add(rightCurrent.value);
                rightCurrent = rightCurrent.next;
            }
        }
        
        if (leftCurrent == null) {
            // add the rest of right to merged
            while (rightCurrent != null) {
                merged.add(rightCurrent.value);
                rightCurrent = rightCurrent.next;
            }
        } else if (rightCurrent == null) {
            // add rest of left to merged
            while (leftCurrent != null) {
                merged.add(leftCurrent.value);
                leftCurrent = leftCurrent.next;
            }
        }
        
        return merged;
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
