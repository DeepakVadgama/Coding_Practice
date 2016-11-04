package leetcode;

/**
 * https://leetcode.com/problems/rotate-function/
 */
public class RotateFunction {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public static int maxRotateFunction(int[] A) {

        int n = A.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int currMax = 0;
            for (int j = 0; j < n; j++) {
                currMax += A[(j + i) % n] * j;
            }
            max = Math.max(max, currMax);
        }
        return max;
    }
}
