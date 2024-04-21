import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Object> myList = new MyArrayList<>();

        // Adding elements to the list
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);
        myList.add(99);

        // Displaying the list
        System.out.println("Original List:");
        myList.printArr();

        // Testing other methods
        System.out.println("Testing other methods:");

        // Testing add
        System.out.println("\nAdding 25 at index 2:");
        myList.add(2, 25);
        myList.printArr();

        // Testing addFirst
        System.out.println("Adding 5 at the beginning:");
        myList.addFirst(5);
        myList.printArr();

        // Testing addLast
        System.out.println("Adding 60 at the end:");
        myList.addLast(60);
        myList.printArr();

        // Testing set
        System.out.println("Setting element at index 3 to 35:");
        myList.set(3, 35);
        myList.printArr();

        // Testing get
        System.out.println("Getting element at index 4: " + myList.get(4));

        // Testing getFirst()
        System.out.println("\nGetting the first element: " + myList.getFirst());

        // Testing getLast()
        System.out.println("\nGetting the last element: " + myList.getLast());

        // Testing remove
        System.out.println("\nRemoving element at index 1:");
        myList.remove(1);
        myList.printArr();

        // Testing removeFirst()
        System.out.println("Removing first element:");
        myList.removeFirst();
        myList.printArr();

        // Testing removeLast()
        System.out.println("Removing last element:");
        myList.removeLast();
        myList.printArr();

        // Testing lastIndexOf
        System.out.println("Index of 40: " + myList.lastIndexOf(40));

        // Testing exists
        System.out.println("\nDoes 50 exist in the list? " + myList.exists(50));

        // Testing toArray()
        System.out.println("\nConverting list to array:");
        Object[] array = myList.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Testing clear()
        System.out.println("\nClearing the list:");
        myList.clear();
        myList.printArr();

        // Adding elements again to the list
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);

        // Displaying the list
        System.out.println("List after adding elements again:");
        myList.printArr();

        // Testing iterator
        System.out.println("Testing iterator:");
        System.out.println("Iterating over the list:");
        Iterator<Object> iter = myList.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
    }
}
