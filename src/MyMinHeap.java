public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Return whether the heap is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Return the size of the heap
    public int size() {
        return heap.size();
    }

    // Return the root element of the heap
    public T getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Remove and return the root element of the heap
    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return min;
    }

    // Add an element to the heap
    public void insert(T item) {
        heap.add(item);
        traverseUp(heap.size() - 1);
    }

    // Perform heapify actions starting from position 'index'
    private void heapify(int index) {
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int smallest = index;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    // Perform traverseUp actions starting from position 'index'
    private void traverseUp(int index) {
        while (index > 0 && heap.get(parentOf(index)).compareTo(heap.get(index)) > 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    // Return the index of the left child of the given index
    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    // Return the index of the right child of the given index
    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    // Return the index of the parent of the given index
    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    // Swap two elements in the heap
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void printArr(){
        heap.printArr();
    }
}

