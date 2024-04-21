import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private T[] arr; // Array to store elements
    private int size; // Current size of the list

    // Constructor to initialize the array with a default size of 5
    public MyArrayList(){
        arr = (T[]) new Object[5];
        size = 0;
    }

    // Method to increase the size of the array
    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];  // Copy each element from old to new
        }
        arr = newArr; // Change reference of arr from old memory location to new
    }

    // Method to check if the index is within bounds
    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index not correct");
        }
    }

    // Method to check index of array when adding an element at position
    private void addCheckIndex(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index not correct");
        }
    }

    // Method to add an element to the end of the list
    @Override
    public void add(T item) {
        if(size >= arr.length)
            increaseBuffer();
        arr[size++] = item;
    }

    // Method to set an element at a specified index
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    // Method to add an element at a specified index
    @Override
    public void add(int index, T item) {
        if(size >= arr.length)
            increaseBuffer();
        addCheckIndex(index);
        for (int i = size; i > index ; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = item;
        size++;
    }

    // Method to add an element at the beginning of the list
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Method to add an element at the end of the list
    @Override
    public void addLast(T item) {
        add(size, item);
    }

    // Method to get an element at a specified index
    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    // Method to get the first element of the list
    @Override
    public T getFirst() {
        if (size == 0)
            throw new IllegalStateException("List is empty");
        return arr[0];
    }

    // Method to get the last element of the list
    @Override
    public T getLast() {
        if (size == 0)
            throw new IllegalStateException("List is empty");
        return arr[size - 1];
    }

    // Method to remove an element at a specified index
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            arr[i-1] = arr[i];
        }
        size--;
    }

    // Method to remove the first element of the list
    @Override
    public void removeFirst() {
        if (size == 0)
            throw new IllegalStateException("List is empty");
        remove(0);
    }

    // Method to remove the last element of the list
    @Override
    public void removeLast() {
        if (size == 0)
            throw new IllegalStateException("List is empty");
        remove(size - 1);
    }

    // Method to sort the list
    @Override
    public void sort() {
        // Not implemented
    }

    // Method to get the index of the first occurrence of an element
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if(object.equals(arr[i]))
                return i;
        }
        return -1;
    }

    // Method to get the index of the last occurrence of an element
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size-1; i >= 0 ; i--) {
            if (object.equals(arr[i]))
                return i;
        }
        return -1;
    }

    // Method to check if an element exists in the list
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Method to convert the list to an array
    @Override
    public T[] toArray() {
        T[] newArr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // Method to clear the list
    @Override
    public void clear() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    // Method to get the size of the list
    @Override
    public int size() {
        return size;
    }

    // Method to print the list
    public void printArr(){
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    // Method to create and return an iterator for the list
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No Such Element");
                }
                return arr[currentIndex++];
            }
        };
    }
}
