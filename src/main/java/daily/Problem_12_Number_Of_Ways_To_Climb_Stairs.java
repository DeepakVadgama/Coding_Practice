package daily;


import java.util.Arrays;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * <p>
 * What if, instead of being able to climb 1 or 2 steps at a time,
 * you could climb any number from a set of positive integers X?
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class Problem_12_Number_Of_Ways_To_Climb_Stairs {

    public static void main(String[] args) {

        int N = 4;
        int[] memo = new int[N + 1];
        Arrays.fill(memo, 0);

        int ways = countWays(N, memo, 0);
        System.out.println(ways);
    }

    private static int countWays(int steps, int[] memo, int count) {

        if (steps == 1 || steps == 2) {
            return steps;
        }

        if (memo[steps] != 0) {
            return memo[steps];
        }

        count = countWays(steps - 1, memo, count) + countWays(steps - 2, memo, count);
        memo[steps] = count;
        return count;
    }
}


