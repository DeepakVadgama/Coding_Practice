package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int n[] = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = in.nextInt();
        }

        for (int i = 0; i < (t / 2 - 1); i++) {
            heapify(n, i, n.length);
        }
        System.out.println(Arrays.toString(n));

        int heapsize = n.length;
        for (int i = n.length - 1; i > 0; i--) {
            swap(n, 0, i);
            heapsize--;
            heapify(n, 0, heapsize);
            System.out.println(Arrays.toString(n));
        }
        System.out.println(Arrays.toString(n));
    }

    private static void heapify(int[] n, int i, int size) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size && n[l] > n[i]) {
            largest = l;
        }
        if (r < size && n[r] > n[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(n, largest, i);
            heapify(n, largest, size);
        }
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
