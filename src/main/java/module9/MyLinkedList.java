package module9;

import java.util.Objects;

public class MyLinkedList<AnyType> {
    private int size;
    private Node<AnyType> first;
    private Node<AnyType> last;

    public void add(AnyType element){
        Node<AnyType> newNode = new Node<>(null, element, null);
        if(first == null) {
            first = last = newNode;
        } else {
            newNode = new Node<>(last, element, null);
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
            Node<AnyType> prevNode = getNodeByIndex(index).prev;
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

    private Node<AnyType> getNodeByIndex(int index){
        Node<AnyType> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

     private static class Node<AnyType> {
         AnyType data;
         Node<AnyType> next;
         Node<AnyType> prev;

        public Node(Node<AnyType> prev, AnyType element, Node<AnyType> next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node<AnyType> current = first;
        output.append("[");
        for (int i = 0; i < size; i++) {
            output.append(current.data.toString());
            if (size - 1 != i) {
                output.append(", ");
            }
            current = current.next;
        }
        output.append("]");
        return output.toString();
    }
}
