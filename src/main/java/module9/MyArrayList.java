package module9;

import java.util.Objects;

public class MyArrayList<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elements;

    public MyArrayList(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        elements = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // Adds an element to the end
    public void add(Object value) {
        increaseSize();
        elements[size] = value;
        size++;
    }

    // Removes an element by the index
    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(elements, index + 1, elements, index,size - index - 1);
        size--;
    }
    // Clears the collection
    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Returns the collection size
    public int size() {
        return size;
    }

    // Returns an element by the index
    @SuppressWarnings("unchecked")
    public AnyType get(int index) {
        Objects.checkIndex(index, size);
        return (AnyType) elements[index];
    }

    private void increaseSize(){
        if(elements.length == size){
            Object[] newArray = new Object[elements.length + DEFAULT_CAPACITY];
            System.arraycopy(elements,0,newArray,0,size);
            elements = newArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            output.append(elements[i].toString());
            if (size - 1 > i) {
                output.append(", ");
            }
        }
        return output.append("]").toString();
    }
}