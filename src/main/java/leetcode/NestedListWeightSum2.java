package leetcode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/nested-list-weight-sum-ii
 * <p>
 * Alternate beautiful solution
 * https://discuss.leetcode.com/topic/49041/no-depth-variable-no-multiplication
 * <p>
 * It just keeps adding cumulative sum of below levels, to current level,
 * effectively multiplying by adding repeatedly
 */
public class NestedListWeightSum2 {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        TreeMap<Integer, Integer> valuesByLevel = new TreeMap<>();
        populate(nestedList, valuesByLevel, 1);
        return addUpLevels(valuesByLevel);
    }

    private int addUpLevels(TreeMap<Integer, Integer> valuesByLevel) {

        int sum = 0;
        int level = 1;
        Map.Entry<Integer, Integer> entry;
        while (!valuesByLevel.isEmpty()) {
            entry = valuesByLevel.lastEntry();
            sum += entry.getValue() * level;
            valuesByLevel.remove(entry.getKey());
            level++;
        }
        return sum;
    }

    private void populate(List<NestedInteger> nestedList,
                          TreeMap<Integer, Integer> map,
                          int level) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                map.putIfAbsent(level, 0);
                map.put(level, map.get(level) + 1);
            } else {
                populate(ni.getList(), map, level + 1);
            }
        }
    }


    private class NestedInteger {

        private int data;
        private List<NestedInteger> list;
        private boolean isInteger;

        public boolean isInteger() {
            return isInteger;
        }

        public int getData() {
            return data;
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }
}
