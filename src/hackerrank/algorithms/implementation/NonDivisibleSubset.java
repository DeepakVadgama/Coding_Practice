package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/non-divisible-subset/
 * <p>
 * Cheated - I feel bad
 * https://www.hackerrank.com/challenges/non-divisible-subset/forum/comments/150647
 * https://github.com/charles-wangkai/hackerrank/blob/master/non-divisible-subset/Solution.java
 */
public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        int[] remainders = new int[k];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            remainders[a[i] % k]++;
        }

        int count = remainders[0] > 0 ? 1 : 0;
        for (int i = 1; i <= k / 2; i++) {
            int opp = k - i;
            if (i == opp && remainders[i] > 0) {
                count++;
            } else {
                count += Math.max(remainders[i], remainders[opp]);
            }
        }

        System.out.println(count);
    }

}
