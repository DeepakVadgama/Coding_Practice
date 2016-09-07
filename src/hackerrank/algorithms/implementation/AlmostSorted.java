package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-squares
 * <p>
 * Sample input -
 * <p>
 * Swap:
 * 7
 * 1 2 8 5 6 3 9
 * <p>
 * segment
 * 7
 * 1 2 8 7 6 9 12
 * <p>
 * swap
 * 2
 * 4 2
 * <p>
 * no
 * 3
 * 3 1 2
 */
public class AlmostSorted {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        int lb = leftBump(a);
        if (lb == -1) {
            System.out.println("yes");
            return;
        }

        // TODO: Test bump after rb
        int rb;
        if (isSwap(a, lb)) {
            rb = rightBump(a, lb);
            if (!validAfterRight(a, rb)) {
                System.out.println("no");
            } else if (testSwap(a, lb, rb)) {
                System.out.println("yes");
                System.out.println("swap " + lb + " " + rb);
            } else {
                System.out.println("no");
            }
        } else {
            rb = rightOfSegment(a, lb);
            if (!validAfterRight(a, rb)) {
                System.out.println("no");
            } else if (rb == lb + 1 && testSwap(a, lb, rb)) {
                System.out.println("yes");
                System.out.println("swap " + lb + " " + rb);
            } else if (testSegment(a, lb, rb)) {
                System.out.println("yes");
                System.out.println("reverse " + lb + " " + rb);
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean validAfterRight(int[] a, int rb) {
        for (int i = rb + 1; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 1, 2, 8, 7, 6, 9, 12
    private static boolean testSegment(int[] a, int lb, int rb) {
        if ((rb >= a.length - 1 || a[lb] < a[rb + 1])
                && (lb == 0 || a[rb] > a[lb - 1])) {
            return true;
        }
        return false;
    }

    // 1, 2, 8, 5, 6, 3, 9  
    private static boolean isSwap(int[] a, int lb) {
        int i = lb + 1;
        if (i < a.length - 1 && a[i] < a[i + 1]) {
            return true;
        }
        return false;
    }

    private static boolean testSwap(int[] a, int lb, int rb) {
        if (rb == -1) {
            return false;
        }

        if ((lb == 0 || a[rb] >= a[lb - 1])
                && (lb >= a.length - 1 || a[rb] <= a[lb + 1])
                && (rb == 0 || a[lb] >= a[rb - 1])
                && (rb >= a.length - 1 || a[lb] <= a[rb + 1])) {
            return true;
        }


        return false;
    }

    // 1, 2, 8, 7, 6, 9, 12
    private static int rightOfSegment(int[] a, int lb) {
        int rb = lb + 1;
        while (rb < a.length && a[rb] < a[rb - 1]) {
            rb++;
        }
        return rb - 1;  // TODO: Validate
    }

    private static int rightBump(int[] a, int lb) {
        for (int i = lb + 1; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    // 1, 2, 5, 3, 4
    private static int leftBump(int[] a) {
        for (int i = 2; i <= a.length; i++) {
            if (a[i] < a[i - 1]) {
                return i - 1;
            }
        }
        return -1;
    }
}
