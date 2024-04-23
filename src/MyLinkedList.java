import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>{
    private class MyNode{
        E element;
        MyNode next;
        MyNode prev;

        public MyNode(E element, MyNode next, MyNode prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList(){
        clear();
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index is incorrect");
        }
    }

    private MyNode getNode(int index){
        MyNode currentNode;
        if(index < size/2){
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        }else{
            currentNode = tail;
            for (int i = size - 1; i > index ; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    @Override
    public void add(E item) {
        MyNode newNode = new MyNode(item, null, tail);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void set(int index, E item) {
        checkIndex(index);
        getNode(index).element = item;
    }

    @Override
    public void add(int index, E item) {
        if(index == size)
            addLast(item);
        else{
            checkIndex(index);
            MyNode nextNode = getNode(index);
            MyNode prevNode = nextNode.prev;
            MyNode newNode = new MyNode(item, nextNode, prevNode);
            nextNode.prev = newNode;
            if(prevNode != null){
                prevNode.next = newNode;
            } else{
                head = newNode;
            }
            size++;
        }
    }

    @Override
    public void addFirst(E item) {
        if (size == 0) {
            addLast(item);
        } else {
            MyNode newNode = new MyNode(item, head, null);
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    @Override
    public void addLast(E item) {
        add(item);
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).element;
    }

    @Override
    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return head.element;
    }

    @Override
    public E getLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode nodeToRemove = getNode(index);
        MyNode prevNode = nodeToRemove.prev;
        MyNode nextNode = nodeToRemove.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
    }

    @Override
    public void sort() {
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if (((Comparable<E>) i.element).compareTo(j.element) > 0) {
                    E temp = i.element;
                    i.element = j.element;
                    j.element = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode currentNode = head;
        for (int i = 0; i < size; i++) {
            if (object.equals(currentNode.element)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode currentNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(currentNode.element)) {
                return i;
            }
            currentNode = currentNode.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        MyNode currentNode = head;
        for (int i = 0; i < size; i++) {
            array[i] = currentNode.element;
            currentNode = currentNode.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyNode currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = currentNode.element;
                currentNode = currentNode.next;
                return element;
            }
        };
    }

    public void printArr(){
       MyNode currentNode = head;
       while(currentNode != null){
           System.out.print(currentNode.element + " ");
           currentNode = currentNode.next;
       }
        System.out.println("\n");
    }

}
