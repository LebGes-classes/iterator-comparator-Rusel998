package HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomHashmap<K, V> implements Iterator<K, V>, Comparable<CustomHashmap<K, V>>{
    private final List<Node<K, V>> buckets;
    private Node<K, V> currentNode;
    private int currentBucketIndex;

    CustomHashmap(){
        int CAPACITY = 16;
        buckets = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(null);
        }
        currentBucketIndex = 0;
        currentNode = buckets.get(currentBucketIndex);
    }
    @SuppressWarnings("all")
    public V put(K key, V value){
        int hash = key.hashCode();
        int index = Math.abs(hash % buckets.size());
        Node<K, V> current = buckets.get(index);
        while (current != null){
            if (current.key.equals(key)){
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        Node<K, V> newNode = new Node<>(hash, key, value, buckets.get(index));
        buckets.set(index, newNode);
        return null;
    }
    public V get(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % buckets.size());

        Node<K, V> current = buckets.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public boolean containsKey(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % buckets.size());
        Node<K, V> current = buckets.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean containsValue(V value){
        for (Node<K, V> node : buckets){
            Node<K, V> current = node;
            while (current != null){
                if (current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    public int size() {
        int size = 0;
        for (Node<K, V> node : buckets) {
            Node<K, V> current = node;
            while (current != null) {
                size++;
                current = current.next;
            }
        }
        return size;
    }

    @Override
    public boolean hasNext() {
        while (currentNode == null && currentBucketIndex < buckets.size() - 1) {
            currentBucketIndex++;
            currentNode = buckets.get(currentBucketIndex);
        }
        return currentNode != null;
    }

    @Override
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        V value = currentNode.value;
        currentNode = currentNode.next;
        return value;

    }

    @Override
    public void remove(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash % buckets.size());
        Node<K, V> current = buckets.get(index);
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets.set(index, current.next);
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    @Override
    public int compareTo(CustomHashmap<K, V> otherMap) {
        return this.size() - otherMap.size();
    }
}
