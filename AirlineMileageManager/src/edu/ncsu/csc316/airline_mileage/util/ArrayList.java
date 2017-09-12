package edu.ncsu.csc316.airline_mileage.util;

/**
 * Creates a list by linking nodes together
 * 
 * @author Caitlyn Wiley
 *
 * @param <E>
 *            generic parameter
 */
public class ArrayList<E extends Comparable<E>> {
    
    private E[] data;
    private int size;
    
    private static final int INIT_SIZE = 16;
    private static final int RESIZE = 2;
    
    /**
     * Constructs an array list
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (E[]) (new Comparable[INIT_SIZE]);
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
        if (size == data.length) {
            growArray();
        }
        data[size] = element;
        size++;
        return true;
    }
    
    @SuppressWarnings("unchecked")
    private void growArray() {
        E[] temp = (E[]) new Comparable[data.length * RESIZE];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
    
    /**
     * Sorts the list by calling mergeSort
     */
    @SuppressWarnings("unchecked")
    public void sort() {
        E[] temp = (E[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = mergeSort(temp);
    }
    
    /**
     * Breaks the list into left and right recursively until each side only has
     * one node, then combines left and right and sorts as it goes
     * 
     * @param list
     *            the list to split in half recursively then sort
     * @return the sorted array
     */
    @SuppressWarnings("unchecked")
    public E[] mergeSort(E[] list) {
        if (list.length == 1) {
            return list;
        }
        int high = list.length - 1;
        int middle = high / 2;
        int index = 0;
        E[] left = (E[]) new Comparable[middle + 1];
        while (index <= middle) {
            left[index] = list[index];
            index++;
        }
        E[] right = (E[]) new Comparable[high - middle];
        while (index < list.length) {
            right[index - (middle + 1)] = list[index];
            index++;
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return mergeParts(left, right);
    }
    
    /**
     * Merges the two sides together then returns a sorted array
     * 
     * @param left
     *            the left array to merge with right
     * @param right
     *            the right array to merge with left
     * @return the merged array
     */
    @SuppressWarnings("unchecked")
    public E[] mergeParts(E[] left, E[] right) {
        E[] tempArray = (E[]) new Comparable[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int indexToAddTo = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                tempArray[indexToAddTo] = left[leftIndex];
                leftIndex++;
            } else if (left[leftIndex].compareTo(right[rightIndex]) > 0) {
                tempArray[indexToAddTo] = right[rightIndex];
                rightIndex++;
            }
            indexToAddTo++;
        }
        
        if (leftIndex == left.length) {
            while (rightIndex < right.length) {
                tempArray[indexToAddTo] = right[rightIndex];
                rightIndex++;
                indexToAddTo++;
            }
        } else if (rightIndex == right.length) {
            while (leftIndex < left.length) {
                tempArray[indexToAddTo] = left[leftIndex];
                leftIndex++;
                indexToAddTo++;
            }
        }
        
        return tempArray;
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
        E middle = data[mid];
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
        
        return data[index];
    }
    
    /**
     * Gets size of list
     * 
     * @return size of list
     */
    public int size() {
        return size;
    }
}
