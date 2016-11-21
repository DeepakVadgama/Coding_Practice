package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomInO1 {
    public static void main(String[] args) {

    }

    public class RandomizedSet {

        private ArrayList<Integer> values;
        private HashSet<Integer> valueSet;
        private Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            values = new ArrayList<>();
            valueSet = new HashSet<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!valueSet.contains(val)) {
                valueSet.add(val);
                values.add(val);
                return true;
            }
            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (valueSet.contains(val)) {
                valueSet.remove(val);
                values.remove(Integer.valueOf(val));
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
