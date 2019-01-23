package geeksforgeeks;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/chocolate-distribution-problem/
 */
public class ChocolateDistribution {
    public static void main(String[] args) {
        System.out.println(findMinDiff(new int[]{7, 3, 2, 4, 9, 12, 56}, 3));
        System.out.println(findMinDiff(new int[]{3, 4, 1, 9, 56, 7, 9, 12}, 5));
        System.out.println(findMinDiff(new int[]{12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50}, 7));
    }

    private static int findMinDiff(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (m > arr.length) {
            return -1;
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < arr.length; i++) {
            int diff = arr[i + m - 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

}
