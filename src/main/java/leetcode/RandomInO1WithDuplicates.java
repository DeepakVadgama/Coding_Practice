package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class RandomInO1WithDuplicates {

    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.insert(1);
        boolean param_3 = obj.remove(1);
        int param_4 = obj.getRandom();
    }

    public static class RandomizedCollection {

        private Map<Integer, List<Integer>> indexMap;
        private ArrayList<Integer> values;
        private Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            indexMap = new HashMap<>();
            values = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true
         */
        public boolean insert(int val) {
            values.add(val);
            indexMap.computeIfAbsent(val, k -> new LinkedList<Integer>())
                    .add(values.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (indexMap.containsKey(val)) {

                int index = indexMap.get(val).get(0);  // get location

                if (index != values.size() - 1) {
                    Integer lastEleVal = values.get(values.size() - 1);
                    values.set(index, lastEleVal); // replace indexed position with last element
                    List<Integer> indexList = indexMap.get(lastEleVal);
                    indexList.remove(indexList.size() - 1);  // update position of element in index map
                    indexList.add(index);  // update position of element in index map
                }

                values.remove(values.size() - 1); // remove last element
                indexMap.get(val).remove(0);  // remove from index map
                if (indexMap.get(val).size() == 0) {
                    indexMap.remove(val);
                }

                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int size = values.size();
            if (size == 0) {
                return 0;
            }
            return values.get(random.nextInt(size));
        }
    }
}
