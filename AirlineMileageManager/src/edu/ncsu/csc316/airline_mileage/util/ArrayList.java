package edu.ncsu.csc316.airline_mileage.util;

public class ArrayList<E> {
    
    private int size;
    private E[] data;
    private static final int RESIZE = 2;
    private static final int INIT_SIZE = 10;
    
    
    /**
     * Constructs an empty array data and initializes its state
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (E[]) new Object[INIT_SIZE];
        size = 0;
    }
    
    /**
     * Adds object to back of data
     * 
     * @param obj
     *            object to add
     * @return true if object can be added, false otherwise
     */
    public boolean add(E obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        if (contains(obj)) {
            throw new IllegalArgumentException();
        }
        if (data.length == size) {
            growArray();
        }
        for (int i = 0; i < size; i++) {
            // search through list, add customer, but need to shift array
            // switch to linked list
            // TODO
        }
        // nope, need to sort it
        // data[size] = obj;
        size++;
        return true;
    }
    
    public void add(int idx, E element) {
        if (size == data.length) {
            growArray();
        }
        
        if (element == null) {
            throw new NullPointerException();
        }
        
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException();
        }
        
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                throw new IllegalArgumentException();
            }
        }
        
        if (idx == size) {
            data[size] = element;
        } else {
            for (int i = size; i > idx; i--) {
                data[i] = data[i - 1];
            }
            data[idx] = element;
        }
        size++;
    }
    
    @SuppressWarnings("unchecked")
    private void growArray() {
        E[] tempList = (E[]) new Object[data.length * RESIZE];
        for (int i = 0; i < data.length; i++) {
            tempList[i] = data[i];
        }
        data = tempList;
    }
    
    public boolean contains(E obj) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }
    
    public E get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return data[idx];
        }
    }
    
    public int indexOf(E obj) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(obj))
                return i;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return size <= 0;
    }
    
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        E removed = data[index];
        
        if (index == size - 1) {
            data[index] = null;
        }
        
        // data[index] = null;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        
        return removed;
    }
    
    public int size() {
        return size;
    }
}


