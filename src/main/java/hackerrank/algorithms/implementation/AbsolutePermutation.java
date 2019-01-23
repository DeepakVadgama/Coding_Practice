package hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/absolute-permutation
 */
public class AbsolutePermutation {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            solve(n, k);
        }
    }

    private static void solve(int n, int k) {

        // Either have entire sorted array filled with possible values and keep deleting
        // This will be faster due to binary search but extra memory allocation
        // Or check in result array until now (no extra memory but slow since r is not sorted)

        TreeSet<Integer> a = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            a.add(i + 1);
        }

        int[] r = new int[n + 1];
        r[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int v = i - k;
            if (a.contains(v)) {
                r[i] = v;
                a.remove(v);
            } else {
                v = i + k;
                if (a.contains(v)) {
                    r[i] = v;
                    a.remove(v);
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.print(r[i] + " ");
        }
        System.out.print(r[n]);
        System.out.println();
    }
}
