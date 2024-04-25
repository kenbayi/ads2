public class MyQueue<E> extends MyLinkedList<E> {
    MyLinkedList<E> myLinkedList;

    public MyQueue(){
        myLinkedList = new MyLinkedList<>();
    }

    // add element to the end of the queue
    public void enqueue(E item){
        myLinkedList.addLast(item);
    }

    // get the element at the front of the queue
    public E peek(){
        return myLinkedList.getFirst();
    }

    // remove and return the element at the front of the queue
    public E dequeue(){
        E removingItem = peek();
        myLinkedList.removeFirst();
        return removingItem;
    }

    // return the size of queue
    public int size(){
        return myLinkedList.size();
    }

    // check if the queue is empty
    public boolean isEmpty(){
        return size() == 0;
    }
}
