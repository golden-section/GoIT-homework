package module9;

public class CollectionsTests {
    public static void main(String[] args) {

        //Test MyArrayList
        MyArrayList<String> customArrayList = new MyArrayList<>();

        //Add 10 elements to customArrayList using the add() method
        for (int i = 1; i <= 10 ; i++) {
            customArrayList.add("Value-" + i);
        }
        System.out.println("customArrayList: " + customArrayList);

        //Check the customArrayList size
        System.out.println("customArrayList size is " + customArrayList.size());

        //Add the 11-th element
        customArrayList.add("Value-11");
        System.out.println("customArrayList with added 11-th element: " + customArrayList);
        System.out.println("customArrayList size is " + customArrayList.size());

        //Get the element by index 5 using the get() method
        System.out.println("The element by index 5 is " + customArrayList.get(5));

        //Remove the element by index 3 using the remove() method
        customArrayList.remove(3);
        System.out.println("customArrayList with removed element: " + customArrayList);
        System.out.println("customArrayList size is " + customArrayList.size());

        //Clear customArrayList using the clear() method
        customArrayList.clear();
        System.out.println("customArrayList after clearing: " + customArrayList + "\n");


        //Test MyLinkedList
        MyLinkedList<String> customLinkedList = new MyLinkedList<>();

        //Add 12 elements to customLinkedList using the add() method
        for (int i = 1; i <= 12 ; i++) {
            customLinkedList.add("Value-" + i);
        }
        System.out.println("customLinkedList: " + customLinkedList);

        //Check the customArrayList size
        System.out.println("customLinkedList size is " + customLinkedList.size());

        //Add new element
        customLinkedList.add("Value-13");
        System.out.println("customLinkedList: " + customLinkedList);
        System.out.println("customLinkedList size is " + customLinkedList.size());

        //Get the element by index 7 using the get() method
        System.out.println("The element by index 7 is " + customLinkedList.get(7));

        //Remove the last element
        customLinkedList.remove(12);
        System.out.println("customLinkedList with the last element removed: " + customLinkedList);

        //Remove the first element
        customLinkedList.remove(0);
        System.out.println("customLinkedList with the first element removed: " + customLinkedList);

        //Remove the element by index 3
        customLinkedList.remove(3);
        System.out.println("customLinkedList with removed element by index 3: " + customLinkedList);

        //Clear customArrayList using the clear() method
        customLinkedList.clear();
        System.out.println("customLinkedList after clearing: " + customLinkedList + "\n");


        //Test MyQueue
        MyQueue<String> customQueue = new MyQueue<>();

        //Add 6 elements to customLinkedList using the add() method and check the size
        for (int i = 1; i <= 6 ; i++) {
            customQueue.add("Value-" + i);
        }
        System.out.println("customQueue: " + customQueue);
        System.out.println("customQueue size is " + customQueue.size());

        //Output the first element from the queue using the peek() method
        System.out.println("customQueue 1-st element is " + customQueue.peek());
        System.out.println("customQueue size is " + customQueue.size());

        //Output the first element and remove it from the queue using the poll() method
        System.out.println("customQueue 1-st and removed element is " + customQueue.poll());
        System.out.println("customQueue 1-st and removed element is " + customQueue.poll());
        System.out.println("customQueue: " + customQueue);
        System.out.println("customQueue size is " + customQueue.size());

        //Clear queue using the clear() method
        customQueue.clear();
        System.out.println("customQueue after clearing: " + customQueue + "\n");


        //Test MyStack
        MyStack<String> customStack = new MyStack<>();

        //Add 6 elements to customStack using the push() method and check the size
        for (int i = 1; i <= 6 ; i++) {
            customStack.push("Value-" + i);
        }
        System.out.println("customStack: " + customStack);
        System.out.println("customStack size is " + customStack.size());

        //Output the first element from the stack using the peek() method
        System.out.println("customStack 1-st element is " + customStack.peek());
        System.out.println("customStack size is " + customStack.size());

        //Remove the element by index 5
        customStack.remove(5);
        System.out.println("customStack after the element by index 5 is removed: " + customStack);

        //Output the first element and remove it from the stack using the poll() method
        System.out.println("customStack 1-st and removed element is " + customStack.pop());
        System.out.println("customStack 1-st and removed element is " + customStack.pop());
        System.out.println("customStack: " + customStack);
        System.out.println("customStack size is " + customStack.size());

        //Clear stack using the clear() method
        customStack.clear();
        System.out.println("customStack after clearing: " + customStack + "\n");


        //Test MyHashMap
        MyHashMap<Integer, String> customHashMap = new MyHashMap<>();

        //Add 5 elements to customHashMap using the put() method
        for (int i = 1; i <= 5 ; i++) {
            customHashMap.put(i, "Value-" + i);
        }
        System.out.println("customHashMap: " + customHashMap);

        //Check the customHashMap size
        System.out.println("customHashMap size is " + customHashMap.size());


        //Get the value by key 3 using the get() method
        System.out.println("The value by the key 3 is " + customHashMap.get(3));

        //Remove the element
        customHashMap.remove(3);
        System.out.println("customHashMap with the key 3 element removed: " + customHashMap);

        //Remove the first element
        customHashMap.remove(1);
        System.out.println("customHashMap with the first element removed: " + customHashMap);

        //Clear customHashMap using the clear() method
        customHashMap.clear();
        System.out.println("customHashMap after clearing: " + customHashMap + "\n");
    }
}