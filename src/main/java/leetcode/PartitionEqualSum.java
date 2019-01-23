package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * <p>
 * Works but time exceeds in LeetCode env.
 */
public class PartitionEqualSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = sumOf(nums);
        if (sum % 2 != 0) {
            return false;
        }

        int[] used = new int[nums.length];
        return findset(nums, 0, used, 0, sum / 2);
    }


    private static boolean findset(int[] nums, int index, int[] used, int currSum, int sum) {

        if (currSum == sum) {
            return true;
        }

        if (currSum > sum) {
            return false;
        }

        if (index == nums.length) {
            return false;
        }

        used[index] = 1;
        currSum = currSum + nums[index];
        boolean with = findset(nums, index + 1, used, currSum, sum);

        used[index] = 0;
        currSum = currSum - nums[index];
        boolean without = findset(nums, index + 1, used, currSum, sum);

        return with || without;
    }

    private static int sumOf(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}
