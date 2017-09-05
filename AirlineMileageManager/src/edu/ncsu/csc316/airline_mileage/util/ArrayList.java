package edu.ncsu.csc316.airline_mileage.util;

public class ArrayList<E> {
    
    private int size;
    private E[] data;
    
    public ArrayList() {
        
    }
    
    public void add(E element) {
        
    }
    
    public void remove(E element) {
        
    }
    
    // might not need this method
    public E remove(int index) {
        E removed = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size] = null;
        size--;
        return removed;
    }
    
    public int indexOf(E element) {
        return -1;
    }
    
    public int size() {
        return size;
    }
    
    public E get(int index) {
        return data[index];
    }
}

