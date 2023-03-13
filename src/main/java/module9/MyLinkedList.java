package module9;

import java.util.Objects;

public class MyLinkedList<AnyType> {
    private int size;
    private Node first;
    private Node last;

    public void add(AnyType element){
        Node newNode = new Node(null, element, null);
        if(first == null) {
            first = last = newNode;
        } else {
            newNode = new Node(last, element, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void remove(int index){
        Objects.checkIndex(index, size);
        if(index == 0){
            first = first.next;
            if(first == null) {
                last = null;
            }
        } else {
            Node prevNode = getNodeByIndex(index).prev;
            prevNode.next = getNodeByIndex(index).next;
            if(index == size - 1) {
                last = prevNode;
            }
        }
        size--;
    }

    public void clear(){
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public AnyType get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).data;
    }

    private Node getNodeByIndex(int index){
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

     private class Node {
         AnyType data;
         Node next;
         Node prev;

        public Node(Node prev, AnyType element, Node next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        if(first != null) {
        Node current = first;
        for (int i = 0; i < size; i++) {
            output.append(current.data.toString());
            if (size - 1 > i) {
                output.append(", ");
            }
            if(current.next != null) {
                current = current.next;
            }
        }}
        return output.append("]").toString();
    }
}