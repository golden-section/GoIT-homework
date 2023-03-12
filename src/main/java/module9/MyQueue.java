package module9;

public class MyQueue<AnyType> {
    private int size;
    private Node<AnyType> first;
    private Node<AnyType> last;

    public void add(AnyType value) {
        Node<AnyType> newNode = new Node<>(null, value, null);
        if(first == null) {
            first = last = newNode;
        } else {
            newNode = new Node<>(last, value, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    public void clear() {
        first = last = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public AnyType peek() {
        if(first == null) {
            throw new IndexOutOfBoundsException("Empty queue");
        }
        return first.data;
    }
    public AnyType poll() {
        if(first == null) {
            throw new IndexOutOfBoundsException("Empty queue");
        } else {
            first = first.next;
            size--;
        }
        return first.prev.data;
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