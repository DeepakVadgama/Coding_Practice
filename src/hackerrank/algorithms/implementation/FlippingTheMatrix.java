package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-the-matrix
 */
public class FlippingTheMatrix {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int r = 1; r <= q; r++) {
            int n = in.nextInt();
            int[][] m = new int[2 * n][2 * n];
            for (int i = 0; i < 2 * n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    m[i][j] = in.nextInt();
                }
            }
            System.out.println(findMaxSum(m, n));
        }

    }

    private static int findMaxSum(int[][] m, int n) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = m[i][j];
                int b = m[i][2 * n - j - 1];
                int c = m[2 * n - i - 1][j];
                int d = m[2 * n - i - 1][2 * n - j - 1];

                int max = Math.max(Math.max(Math.max(a, b), c), d);
                sum += max;
            }
        }
        return sum;
    }
}
