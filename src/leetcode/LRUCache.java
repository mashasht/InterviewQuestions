package leetcode;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by mashashtutman on 2019-07-15.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node previous;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }
    private final int capacity;
    private Map<Integer, Node> locationStore;
    private Node head;
    private Node tail;
    private int numberOfNodes;

    public LRUCache(int capacity) {
        Preconditions.checkArgument(capacity > 0);
        this.capacity = capacity;
        locationStore = new HashMap<>();
    }

    public int get(int key) {
        if (locationStore.containsKey(key)) {
            Node foundNode = locationStore.get(key);
            removeNode(foundNode);
            offerNode(foundNode);
            return foundNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (numberOfNodes == capacity) {
            removeNode(tail);
        }
        if (locationStore.containsKey(key)) {
            removeNode(locationStore.get(key));
        }
        Node newNode = new Node(key, value);
        offerNode(newNode);
    }

    private void removeNode(Node n) {
        if (n.next != null) {
            n.next.previous = n.previous;
        }
        else {
            tail = n.previous;
        }
        if (n.previous != null) {
            n.previous.next = n.next;
        }
        else {
            head = n.next;
        }
        numberOfNodes--;
        locationStore.remove(n);

    }

    private void offerNode(Node n) {
        locationStore.put(n.key, n);
        numberOfNodes++;
        if (head == null) {
            head = n;
            tail = n;
            return;
        }
        n.next = head;
        head.previous = n;
        head = n;
    }

    public String toString(){
        Node current = head;
        StringBuilder result = new StringBuilder();
        String delimiter = ",";
        while (current != null) {
            result.append(current.key);
            if (current.next != null) {
                result.append(delimiter);
            }
            current = current.next;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 7);
        cache.put(33, 6);
        cache.get(1);
        cache.put(25, 3);
        System.out.println(cache);
    }
}
