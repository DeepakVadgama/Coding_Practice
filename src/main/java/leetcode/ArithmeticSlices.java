package leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/arithmetic-slices/
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        System.out.println(numberOfArithmeticSlices(A));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for (int i = 0; i + 2 < A.length; i++) {
            int diff = A[i + 1] - A[i];
            int j = i + 2;
            while (j < A.length && A[j] - A[j - 1] == diff) {
                count++;
                j++;
            }
        }
        return count;
    }
}
