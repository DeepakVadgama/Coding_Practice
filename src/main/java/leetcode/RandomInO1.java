package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomInO1 {

    public class RandomizedSet {

        private Map<Integer, Integer> indexMap;
        private ArrayList<Integer> values;
        private Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            indexMap = new HashMap<>();
            values = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!indexMap.containsKey(val)) {
                values.add(val);
                indexMap.put(val, values.size() - 1);
                return true;
            }
            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (indexMap.containsKey(val)) {

                int index = indexMap.get(val);  // get location

                if (index != values.size() - 1) {
                    values.set(index, values.get(values.size() - 1)); // replace indexed position with last element
                    indexMap.put(values.get(index), index);  // update position of element in index map
                }

                values.remove(values.size() - 1); // remove last element
                indexMap.remove(val);  // remove from index map

                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return values.get(random.nextInt(values.size()));
        }
    }
}
