package edu.ncsu.csc316.airline_mileage.util;

/**
 * Creates a list by linking nodes together
 * 
 * @author Caitlyn Wiley
 *
 * @param <E>
 *            generic parameter
 */
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
        if (isInList(element)) {
            throw new IllegalArgumentException();
        }
        front = new Node<E>(element, front);
        size++;
        return true;
    }
    
    /**
     * Sorts the list by calling mergeSort
     */
    public void sort() {
        front = mergeSort(this);
    }
    
    /**
     * Breaks the list into left and right recursively until each side only has
     * one node, then combines left and right and sorts as it goes
     * 
     * @param list
     *            the list to split in half recursively then sort
     * @return a reference to the front node of the sorted list
     */
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
    
    /**
     * Merges the two sides together then returns a reference to the front of
     * the merged list
     * 
     * @param left
     *            reference to the front node of the left list
     * @param right
     *            reference to the front node of the right list
     * @return reference to front node of sorted list
     */
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
    
    /*
     * public LinkedList<E> mergeParts(LinkedList<E> left, LinkedList<E> right)
     * { // merge parts similarly to in Miles LinkedList<E> merged = new
     * LinkedList<E>(); // Node<E> mergedCurrent = merged.front; Node<E>
     * leftCurrent = left.front; Node<E> rightCurrent = right.front;
     * 
     * while (leftCurrent != null & rightCurrent != null) { if
     * (leftCurrent.value.compareTo(rightCurrent.value) < 0) { // left comes
     * before right, add node to end of merged list
     * merged.addToBack(leftCurrent.value, merged); leftCurrent =
     * leftCurrent.next; // mergedCurrent = mergedCurrent.next; } else { //
     * right comes before left, add node to end of merged list
     * merged.addToBack(rightCurrent.value, merged); rightCurrent =
     * rightCurrent.next; // mergedCurrent = mergedCurrent.next; } }
     * 
     * if (leftCurrent == null) { // add the rest of right to merged while
     * (rightCurrent != null) { merged.addToBack(rightCurrent.value, merged);
     * rightCurrent = rightCurrent.next; // mergedCurrent = mergedCurrent.next;
     * } } else if (rightCurrent == null) { // add rest of left to merged while
     * (leftCurrent != null) { merged.addToBack(leftCurrent.value, merged);
     * leftCurrent = leftCurrent.next; // mergedCurrent = mergedCurrent.next; }
     * }
     * 
     * return merged; }
     * 
     * private void addToBack(E element, LinkedList<E> merged) { if
     * (merged.front == null) { front = new Node<E>(element, null); } else {
     * Node<E> current = merged.front; while (current.next != null) { current =
     * current.next; } current.next = new Node<E>(element, null); } }
     */
    
    // public boolean contains(E element) {
    // Node<E> current = front;
    // for (int i = 0; i < size; i++) {
    // if (current.value.equals(element)) {
    // return true;
    // }
    // current = current.next;
    // }
    // return false;
    // }
    
    /**
     * Finds if the element is already in the list
     * 
     * @param element
     *            element to check for in list
     * @return true if element is in the list already, false otherwise
     */
    public boolean isInList(E element) { // do a binary search
        int index = binarySearch(0, size - 1, element);
        return index != -1;
    }
    
    /**
     * Searches recursively to find the element by narrowing down the list to
     * half of the previous list each time
     * 
     * @param min
     *            minimum index value
     * @param max
     *            maximum index value
     * @param element
     *            element to search for
     * @return index where element was found, -1 if it wasn't found
     */
    public int binarySearch(int min, int max, E element) {
        if (min > max) {
            return -1;
        }
        int mid = ((max - min) / 2) + min;
        E middle = get(mid);
        if (element.compareTo(middle) == 0) {
            return mid;
        } else if (element.compareTo(middle) < 0) {
            return binarySearch(0, mid - 1, element);
        } else {
            return binarySearch(mid + 1, max, element);
        }
    }
    
    /**
     * Gets the element at the index given
     * 
     * @param index
     *            index to get element for
     * @return the element found at the index
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
    
    /**
     * Gets size of list
     * 
     * @return size of list
     */
    public int size() {
        return size;
    }
    
    /**
     * Creates Nodes to be held by LinkedList
     * 
     * @author Caitlyn
     * 
     * @param <E>
     *            generic parameter
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
        
        /**
         * Creates a new node setting value and next node to null
         */
        public Node() {
            value = null;
            next = null;
        }
    }
}
