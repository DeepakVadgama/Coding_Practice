package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {

    private Map<Integer, Node> values = new HashMap<>();
    private Map<Integer, Integer> counts = new HashMap<>();
    private TreeMap<Integer, DoubleLinkedList> frequencies = new TreeMap<>();
    private final int MAX_CAPACITY;

    public LFUCache(int capacity) {
        MAX_CAPACITY = capacity;
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }

        Node node = values.get(key);

        // Move item from one frequency list to next. O(1) this time.
        int frequency = counts.get(key);
        frequencies.get(frequency).remove(node);
        removeIfListEmpty(frequency);
        frequencies.computeIfAbsent(frequency + 1, k -> new DoubleLinkedList()).add(node);

        counts.put(key, frequency + 1);
        return values.get(key).value;
    }

    public void set(int key, int value) {
        if (!values.containsKey(key)) {

            Node node = new Node(key, value);

            if (values.size() == MAX_CAPACITY) {

                int lowestCount = frequencies.firstKey();   // smallest frequency
                Node nodeTodelete = frequencies.get(lowestCount).head(); // first item (LRU)
                frequencies.get(lowestCount).remove(nodeTodelete);

                int keyToDelete = nodeTodelete.key();
                removeIfListEmpty(lowestCount);
                values.remove(keyToDelete);
                counts.remove(keyToDelete);
            }

            values.put(key, node);
            counts.put(key, 1);
            frequencies.computeIfAbsent(1, k -> new DoubleLinkedList()).add(node); // starting frequency = 1
        }
    }

    private void removeIfListEmpty(int frequency) {
        if (frequencies.get(frequency).size() == 0) {
            frequencies.remove(frequency);  // remove from map if list is empty
        }
    }

    private class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int key() {
            return key;
        }

        public int value() {
            return value;
        }
    }

    private class DoubleLinkedList {
        private int n;
        private Node head;
        private Node tail;

        public void add(Node node) {
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            n++;
        }

        public void remove(Node node) {

            if (node.next == null) tail = node.prev;
            else node.next.prev = node.prev;

            if (head.key == node.key) head = node.next;
            else node.prev.next = node.next;

            n--;
        }

        public Node head() {
            return head;
        }

        public int size() {
            return n;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));
        cache.set(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.set(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
