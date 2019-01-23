package geeksforgeeks;

/**
 * http://www.geeksforgeeks.org/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 0, 2}));
        System.out.println(solve(new int[]{3, 0, 0, 2, 0, 4}));
        System.out.println(solve(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private static int solve(int[] heights) {

        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = heights[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], heights[i]);
        }

        right[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], heights[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - heights[i];
        }

        return water;
    }
}
