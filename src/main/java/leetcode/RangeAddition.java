package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/range-addition
 */
public class RangeAddition {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getModifiedArray(5, new int[][]{
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2},
        })));
    }

    public static int[] getModifiedArray(int length, int[][] updates) {

        if (length <= 0) {
            return null;
        }

        int res[] = new int[length];
        for (int i = 0; i < updates.length; i++) {
            res[updates[i][0]] += updates[i][2];
            if (updates[i][1] + 1 < length) {
                res[updates[i][1] + 1] -= updates[i][2];
            }
        }

        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}
