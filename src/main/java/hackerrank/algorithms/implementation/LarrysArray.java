package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/larrys-array
 */
public class LarrysArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int a[] = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                a[j] = in.nextInt();
            }

            solve(a);
        }
    }

    private static void solve(int[] a) {

        int n = a.length - 1;

        // Brute force
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - 2; j++) {
                for (int k = 0; k < 3 && !inOrder(a, j); k++) {
                    rotate(a, j);
                }
            }
        }

        if (isSorted(a)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean inOrder(int[] a, int j) {
        return a[j] < a[j + 1] && a[j] < a[j + 2];
    }

    private static void rotate(int[] a, int i) {
        int temp = a[i];
        a[i] = a[i + 1];
        a[i + 1] = a[i + 2];
        a[i + 2] = temp;
    }
}
