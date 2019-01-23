package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

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
            int q = partition(n, p, r);
            sort(n, p, q - 1);
            sort(n, q + 1, r);
        }
    }

    private static int partition(int[] n, int p, int r) {
        int x = n[r];
        int j = p, i = p - 1;
        while (j < r) {
            if (n[j] < x) {
                i++;
                swap(n, i, j);
            }
            j++;
        }
        swap(n, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }
}
