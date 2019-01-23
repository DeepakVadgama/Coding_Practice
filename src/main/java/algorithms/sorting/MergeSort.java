package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int n[] = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = in.nextInt();
        }
        sort(n, 0, n.length - 1);
        System.out.println(Arrays.toString(n));
    }

    private static void sort(int[] n, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(n, p, q);
            sort(n, q + 1, r);
            merge(n, p, q, r);
        }
    }

    private static void merge(int[] n, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int left[] = new int[n1 + 1];
        int right[] = new int[n2 + 1];
        System.arraycopy(n, p, left, 0, n1);
        System.arraycopy(n, q + 1, right, 0, n2);

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int k = p;
        int i = 0, j = 0;
        while (k <= r) {
            if (left[i] <= right[j]) {
                n[k] = left[i];
                i++;
            } else {
                n[k] = right[j];
                j++;
            }
            k++;
        }
    }
}
