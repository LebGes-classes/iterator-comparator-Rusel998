package HashMap;

public class Node<K, V> {
    int hashmap;
    K key;
    V value;
    Node<K, V> next;

    Node(int hash, K key, V value, Node<K, V> next){
        this.hashmap = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
