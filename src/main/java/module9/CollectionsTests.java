package module9;

public class CollectionsTests {
    public static void main(String[] args) {

        //Test MyArrayList
        MyArrayList<String> customArrayList = new MyArrayList<>();

        //Add 10 elements to customArrayList using the add() method
        for (int i = 1; i <= 10 ; i++) {
            customArrayList.add("Value-" + i);
        }
        System.out.println("customArrayList = " + customArrayList);

        //Check the customArrayList size
        System.out.println("customArrayList size is " + customArrayList.size());

        //Add the 11-th element
        customArrayList.add("Value-11");
        System.out.println("customArrayList with added 11-th element = " + customArrayList);
        System.out.println("customArrayList size is " + customArrayList.size());

        //Get the element by index 5 using the get() method
        System.out.println("The element by index 5 is " + customArrayList.get(5));

        //Remove the element by index 3 using the remove() method
        customArrayList.remove(3);
        System.out.println("customArrayList with removed element " + customArrayList);
        System.out.println("customArrayList size is " + customArrayList.size());

        //Clear customArrayList using the clear() method
        customArrayList.clear();
        System.out.println("customArrayList after clearing " + customArrayList + "\n");


        //Test MyLinkedList
        MyLinkedList<String> customLinkedList = new MyLinkedList<>();

        //Add 12 elements to customLinkedList using the add() method
        for (int i = 1; i <= 12 ; i++) {
            customLinkedList.add("Value-" + i);
        }
        System.out.println("customLinkedList = " + customLinkedList);

        //Check the customArrayList size
        System.out.println("customLinkedList size is " + customLinkedList.size());

        //Add new element
        customLinkedList.add("Value-13");
        System.out.println("customLinkedList = " + customLinkedList);
        System.out.println("customLinkedList size is " + customLinkedList.size());

        //Get the element by index 7 using the get() method
        System.out.println("The element by index 7 is " + customLinkedList.get(7));

        //Remove the last element
        customLinkedList.remove(12);
        System.out.println("customLinkedList with the last element removed " + customLinkedList);

        //Remove the first element
        customLinkedList.remove(0);
        System.out.println("customLinkedList with the first element removed " + customLinkedList);

        //Remove the element by index 3
        customLinkedList.remove(3);
        System.out.println("customLinkedList with removed element by index 3 " + customLinkedList);

        //Clear customArrayList using the clear() method
        customLinkedList.clear();
        System.out.println("customArrayList after clearing " + customLinkedList + "\n");
    }
}