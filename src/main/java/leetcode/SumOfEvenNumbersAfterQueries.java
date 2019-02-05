package leetcode;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {

    public static void main(String[] args) {
        System.out.println(-4 % 2);
        int[] results = new SumOfEvenNumbersAfterQueries().executeQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});
        System.out.println(Arrays.toString(results));
    }

    public int[] executeQueries(int[] numbers, int[][] queries) {

        if (!isValid(numbers, queries)) {
            return null;
        }

        int[] results = new int[queries.length];
        int sum = addAllEven(numbers);

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int delta = queries[i][0];

            int num = numbers[index];
            if (isEven(num) && isEven(delta)) {
                num += delta;
                sum += delta;
            } else if (isEven(num) && isOdd(delta)) {
                sum = sum - num;
                num += delta;
            } else if (isOdd(num) && isOdd(delta)) {
                num += delta;
                sum = sum + num;
            } else if (isOdd(num) && isEven(delta)) {
                num += delta;
            }
            numbers[index] = num;
            results[i] = sum;
        }

        return results;
    }

    private int addAllEven(int[] numbers) {
        return Arrays.stream(numbers).filter(i -> i % 2 == 0).sum();
    }

    private boolean isOdd(int i) {
        return Math.abs(i) % 2 == 1;
    }

    private boolean isEven(int i) {
        return Math.abs(i) % 2 == 0;
    }

    private boolean isValid(int[] numbers, int[][] queries) {
        return numbers != null && queries != null;
    }
}
