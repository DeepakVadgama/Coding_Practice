package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 */
public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        // sum of primary diagonal
        int sum1 = 0;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            sum1 += m[i][j];
        }

        // sum of primary diagonal
        int sum2 = 0;
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            sum2 += m[i][j];
        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}
