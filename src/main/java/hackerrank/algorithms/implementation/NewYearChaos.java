package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos
 */
public class NewYearChaos {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] p = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                p[j] = in.nextInt();
            }
            solve(p);
        }
    }

    private static void solve(int[] p) {
        int c = 1;
        int bribes = 0;
        while (c < p.length - 1) {
            if (p[c] > c) {
                if (p[c] - c > 2) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    bribes += (p[c] - c);
                }
            } else if (p[c] > p[c + 1]) {
                bribes++;
            }
            c++;
        }
        System.out.println(bribes);
    }
}
