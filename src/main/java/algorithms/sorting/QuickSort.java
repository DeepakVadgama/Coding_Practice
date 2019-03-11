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

    private static void sort(int[] n, int start, int end) {
        if (start < end) {
            int mid = partition(n, start, end);
            sort(n, start, mid - 1);
            sort(n, mid + 1, end);
        }
    }

    private static int partition(int[] n, int start, int end) {
        int x = n[end];
        int j = start, i = start - 1;
        while (j < end) {
            if (n[j] < x) {
                i++;
                swap(n, i, j);
            }
            j++;
        }
        swap(n, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}
