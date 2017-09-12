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
        front = new Node<E>(element, front);
        size++;
        return true;
    }
    
    public void sort() {
        front = mergeSort(this);
    }
    
    public Node<E> mergeSort(LinkedList<E> list) {
        if (list.size() == 1) {
            return list.front;
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
            
            left.front = mergeSort(left);
            right.front = mergeSort(right);
            // return mergeParts(left, right);
            return mergeParts(left.front, right.front);
        }
    }
    
    public Node<E> mergeParts(Node<E> left, Node<E> right) {
        Node<E> temp = new Node<E>();
        Node<E> head = temp;
        Node<E> x = head;
        while ((left != null) && (right != null)) { // both aren't "empty"
            if (left.value.compareTo(right.value) < 0) {
                x.next = left;
                x = left;
                left = left.next;
            } else {
                x.next = right;
                x = right;
                right = right.next;
            }
        }
        x.next = (left == null) ? right : left;
        return head.next;
    }
    
    public LinkedList<E> mergeParts(LinkedList<E> left, LinkedList<E> right) {
        // merge parts similarly to in Miles
        LinkedList<E> merged = new LinkedList<E>();
        // Node<E> mergedCurrent = merged.front;
        Node<E> leftCurrent = left.front;
        Node<E> rightCurrent = right.front;
        
        while (leftCurrent != null & rightCurrent != null) {
            if (leftCurrent.value.compareTo(rightCurrent.value) < 0) {
                // left comes before right, add node to end of merged list
                merged.addToBack(leftCurrent.value, merged);
                leftCurrent = leftCurrent.next;
                // mergedCurrent = mergedCurrent.next;
            } else {
                // right comes before left, add node to end of merged list
                merged.addToBack(rightCurrent.value, merged);
                rightCurrent = rightCurrent.next;
                // mergedCurrent = mergedCurrent.next;
            }
        }
        
        if (leftCurrent == null) {
            // add the rest of right to merged
            while (rightCurrent != null) {
                merged.addToBack(rightCurrent.value, merged);
                rightCurrent = rightCurrent.next;
                // mergedCurrent = mergedCurrent.next;
            }
        } else if (rightCurrent == null) {
            // add rest of left to merged
            while (leftCurrent != null) {
                merged.addToBack(leftCurrent.value, merged);
                leftCurrent = leftCurrent.next;
                // mergedCurrent = mergedCurrent.next;
            }
        }

        return merged;
    }
    
    private void addToBack(E element, LinkedList<E> merged) {
        if (merged.front == null) {
            front = new Node<E>(element, null);
        } else {
            Node<E> current = merged.front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<E>(element, null);
        }
    }
    
    public boolean contains(E element) {
        Node<E> current = front;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /*
     * public boolean isInList(E element) { // do a binary search int index =
     * binarySearch(0, size - 1, element); return index != -1; }
     * 
     * private int binarySearch(int min, int max, E element) { if (min > max) {
     * return -1; } int mid = (max - min) / 2 + min; if
     * (element.compareTo(get(mid)) == 0) { return mid; } else if
     * (element.compareTo(get(mid)) < 0) { return binarySearch(0, mid - 1,
     * element); } else { return binarySearch(mid + 1, max, element); } }
     */
    
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
        
        public Node() {
            value = null;
            next = null;
        }
    }
}
