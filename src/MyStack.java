public class MyStack<T> extends MyArrayList<T>{
    MyArrayList<T> arrayList;

    public MyStack(){
        arrayList = new MyArrayList<T>();
    }

    // add the element to top of the stack
    public void push(T item){
        arrayList.addFirst(item);
    }

    // get the element at top of the stack
    public T peek(){
        return arrayList.getFirst();
    }

    // delete the element at top of the stack
    public T pop(){
        T removingItem = peek();
        arrayList.removeFirst();
        return removingItem;
    }

    // return the size of array
    public int size(){
        return arrayList.size();
    }

    // checks whether stack is empty or not
    public boolean isEmpty(){
        return size() == 0;
    }
}
