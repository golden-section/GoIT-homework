package module9;

public class MyHashMap<K, V> {
    private int size;
    private HashNode first;
    private HashNode last;

    public void put(K key, V value){

        HashNode newNode = new HashNode(key,value,null);

        if(first == null){
            first = last = newNode;
            size++;
            return;
        }

        if(size > 0) {
            HashNode current = first;
            int i = 0;
            while (i < size) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next != null) {
                    current = current.next;
                }
                i++;
            }
        }

        last.next = newNode;
        last = newNode;
        size++;
    }

    public V get(K key) {
        HashNode current = first;
        int i = 0;
        while (i < size) {
            if (current.key.equals(key)) {
                return current.value;
            }
            if (current.next != null) {
                current = current.next;
            }
            i++;
        }
        return null;
    }

    public void remove(K key){
        if(first.key.equals(key)){
            first = first.next;
            size--;
            return;
        }

        HashNode current = first.next;
        HashNode previous = first;
        int i = 0;
        while (i < size) {
            if (current.key.equals(key)) {
                previous.next = current.next;
                size--;
                return;
            }
            if (current.next != null) {
                current = current.next;
                previous = previous.next;
            }
            i++;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    private class HashNode {
        private final K key;
        private V value;
        HashNode next;

        public HashNode(K key, V value, HashNode next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        if(first != null) {
        HashNode current = first;
        for (int i = 0; i < size; i++) {
            output.append(current.key.toString()).append(":").append(current.value.toString());
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