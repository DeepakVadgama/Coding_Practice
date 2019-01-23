package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int n[] = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = in.nextInt();
        }
        sort(n);
        System.out.println(Arrays.toString(n));
    }

    private static void sort(int[] n) {
        for (int i = 1; i < n.length; i++) {
            int k = n[i];
            int j = i - 1;
            while (j >= 0 && n[j] > k) {
                n[j + 1] = n[j];
                j--;
            }
            n[j + 1] = k;
        }
    }
}
