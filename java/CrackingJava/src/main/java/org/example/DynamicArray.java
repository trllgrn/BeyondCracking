package org.example;

public class DynamicArray<T> {
    private T[] backingArray;
    private final int INITIAL_CAPACITY = 10;
    private int size;
    private int capacity;
    public DynamicArray() {
        this.backingArray = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }
    public void append(T item) {
        if (size == capacity) {
            grow();
        }
        backingArray[size] = item;
        size++;
    }
    //get //returns the element at index i
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            return backingArray[index];
        }
    }
    //set(i,x) //updates the element at index i to x
    public void set(int index, T newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            backingArray[index] = newValue;
        }
    }
    //size //returns the number of elements in the array
    public int size() {
        return size;
    }
    //popBack //remove last element
    public void popBack() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty, cannot pop back.");
        }
        size--;
        backingArray[size] = null;
    }
    private void grow() {
        T[] newBackingArray = (T[]) new Object[capacity * 2];
        //copy old elements to new array
        for (int i = 0; i < backingArray.length; i++) {
            newBackingArray[i] = backingArray[i];
        }
        this.backingArray = newBackingArray;
    }
}
