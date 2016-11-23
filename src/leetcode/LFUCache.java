package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {

    private Map<Integer, Integer> values = new HashMap<>();
    private Map<Integer, Integer> counts = new HashMap<>();
    private TreeMap<Integer, List<Integer>> frequencies = new TreeMap<>();
    private final int MAX_CAPACITY;

    public LFUCache(int capacity) {
        MAX_CAPACITY = capacity;
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }

        // Move item from one frequency list to next. Not O(1) due to list iteration.
        int frequency = counts.get(key);
        frequencies.get(frequency).remove(new Integer(key));
        if (frequencies.get(frequency).size() == 0) {
            frequencies.remove(frequency);  // remove from map if list is empty
        }
        frequencies.computeIfAbsent(frequency + 1, k -> new LinkedList<>()).add(key);

        counts.put(key, frequency + 1);
        return values.get(key);
    }

    public void set(int key, int value) {
        if (!values.containsKey(key)) {

            if (values.size() == MAX_CAPACITY) {
                // first item from 'list of smallest frequency'
                int lowestCount = frequencies.firstKey();
                int keyToDelete = frequencies.get(lowestCount).remove(0);
                if (frequencies.get(lowestCount).size() == 0) {
                    frequencies.remove(lowestCount); // remove from map if list is empty
                }
                values.remove(keyToDelete);
                counts.remove(keyToDelete);
            }

            values.put(key, value);
            counts.put(key, 1);
            frequencies.computeIfAbsent(1, k -> new LinkedList<>()).add(key); // starting frequency = 1
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
