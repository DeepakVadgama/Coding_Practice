package google.practice;

import java.util.Arrays;

/**
 * Sort array in place, which consists of only 0, 1 and 2
 */
public class SortArrayInPlaceOf012 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 2, 1, 0})));
        System.out.println(Arrays.toString(sort2(new int[]{0, 1, 2, 2, 1, 0})));
    }

    private static int[] sort2(int[] ints) {
        int repIndex = 0;
        for (int i = 0; i < 3; i++) {
            int curIndex = 0;
            while (curIndex < ints.length) {
                if (ints[curIndex] == i) {
                    swap(ints, curIndex, repIndex);
                    repIndex++;
                }
                curIndex++;
            }
        }
        return ints;
    }

    private static void swap(int[] ints, int curIndex, int repIndex) {
        int tmp = ints[curIndex];
        ints[curIndex] = ints[repIndex];
        ints[repIndex] = tmp;
    }

    public static int[] sort(int[] a) {
        int[] counts = new int[3];
        for (int val : a) {
            counts[val]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < counts[i]; j++) {
                a[index++] = i;
            }
        }
        return a;
    }
}
