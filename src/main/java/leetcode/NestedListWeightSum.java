package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/nested-list-weight-sum
 */
public class NestedListWeightSum {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        return weightedSum(nestedList, 1);
    }

    private int weightedSum(List<NestedInteger> nestedList, int level) {
        int weightedSum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                weightedSum += ni.getData() * level;
            } else {
                weightedSum += weightedSum(ni.getList(), level + 1);
            }
        }
        return weightedSum;
    }

    private class NestedInteger {

        int data;
        List<NestedInteger> list;
        boolean isInteger;

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
