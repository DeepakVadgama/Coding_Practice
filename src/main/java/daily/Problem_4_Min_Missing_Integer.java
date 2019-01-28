package daily;

import java.util.Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * <p>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 */
public class Problem_4_Min_Missing_Integer {
    public static void main(String[] args) {

        int[] input = {3, -4, 5, -1, 1};
//        int[] input = {3, 0, 1};
//        int[] input = {23, 20, 1};
        int missing = solve(input);
    }

    private static int solve(int[] input) {

        int endIdx = segregateNegative(input);
        markPresent(input, endIdx);
        int missing = findMissing(input, endIdx);
        System.out.println(Arrays.toString(input));
        System.out.println(missing);

        return missing;
    }

    private static int findMissing(int[] input, int endIdx) {
        for (int i = 1; i <= endIdx; i++) {
            if (input[i] > 0) {
                return i;
            }
        }
        return endIdx + 1;
    }

    private static void markPresent(int[] input, int endIdx) {

        for (int i = 0; i <= endIdx; i++) {
            if (input[i] <= endIdx) {
                input[i] = -input[Math.abs(input[i])];
            }
        }
    }

    private static int segregateNegative(int[] input) {

        int endIdx = input.length - 1;
        int startIdx = 0;

        while (startIdx < endIdx) {
            if (input[startIdx] > 0) startIdx++;
            else if (input[endIdx] < 0) endIdx--;
            else swap(input, startIdx, endIdx);
        }

        return startIdx - 1;
    }

    private static void swap(int[] input, int start, int end) {
        int temp = input[start];
        input[start] = input[end];
        input[end] = temp;
    }
}
