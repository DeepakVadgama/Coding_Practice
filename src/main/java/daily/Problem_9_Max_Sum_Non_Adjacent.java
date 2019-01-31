package daily;


import java.util.Arrays;

public class Problem_9_Max_Sum_Non_Adjacent {

    public static void main(String[] args) {
//        int[] numbers = {1, 0, 3, 9, 2};
//        int[] numbers = {2, 4, 6, 2, 5};
        int[] numbers = {5, 1, 1, 5};
        maxNonAdjacentSum(numbers);
    }

    private static void maxNonAdjacentSum(int[] numbers) {

        int[] memo = new int[numbers.length];
        Arrays.fill(memo, Integer.MIN_VALUE);

        int max = maxSumAt(numbers, memo, 0);
        System.out.println(max);
    }

    private static int maxSumAt(int[] numbers, int[] memo, int index) {

        if (index >= numbers.length) {
            return 0;
        }

        if (memo[index] >= 0) {
            return memo[index];
        }

        int maxWithCurrent = numbers[index] + maxSumAt(numbers, memo, index + 2);
        int maxWithNext = maxSumAt(numbers, memo, index + 1);
        int max = Math.max(maxWithCurrent, maxWithNext);
        memo[index] = max;
        return max;
    }
}
