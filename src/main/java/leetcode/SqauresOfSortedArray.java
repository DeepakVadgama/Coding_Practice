package leetcode;

import java.util.Arrays;

public class SqauresOfSortedArray {

    public static void main(String[] args) {
        int[] result = new SqauresOfSortedArray().sortedSquares(new int[]{-7, -3, 0, 3, 5});
//        int[] result = new SqauresOfSortedArray().sortedSquares(new int[]{-7, -3, -1});
        System.out.println(Arrays.toString(result));
    }

    public int[] sortedSquares(int[] A) {

        int midIdx = indexOfSmallestNegative(A);
        int[] result = new int[A.length];

        int leftIdx = midIdx;
        int rightIdx = midIdx + 1;

        int rstIdx = 0;
        while (leftIdx >= 0 || rightIdx < A.length) {
            if (leftIdx < 0) {
                result[rstIdx++] = A[rightIdx] * A[rightIdx];
                rightIdx++;
            } else if (rightIdx >= A.length) {
                result[rstIdx++] = A[leftIdx] * A[leftIdx];
                leftIdx--;
            } else {
                if (Math.abs(A[leftIdx]) > A[rightIdx]) {
                    result[rstIdx++] = A[rightIdx] * A[rightIdx];
                    rightIdx++;
                } else {
                    result[rstIdx++] = A[leftIdx] * A[leftIdx];
                    leftIdx--;
                }
            }
        }

        return result;
    }

    private int indexOfSmallestNegative(int[] sortedArray) {
        int idx = 0;
        while (idx < sortedArray.length && sortedArray[idx] < 0) {
            idx++;
        }
        return idx - 1;
    }
}
