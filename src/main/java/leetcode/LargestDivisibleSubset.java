package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{3}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int max = 0;
        int maxInd = -1;
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        int[] parent = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0
                        && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    parent[i] = j;
                }
            }
            if (count[i] > max) {
                max = count[i];
                maxInd = i;
            }
        }

        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            subset.add(nums[maxInd]);
            maxInd = parent[maxInd];
        }

        return subset;
    }
}
