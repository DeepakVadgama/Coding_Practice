package leetcode;

/**
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class WiggleSequence {
    public static void main(String[] args) {
//        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));
//        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
//        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(wiggleMaxLength(new int[]{0, 0}));
    }

    public static int wiggleMaxLength(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            return n;
        }

        int k = 0;
        while (k + 1 < n && arr[k] == arr[k + 1]) k++;
        if (k + 1 == n) return 1;

        boolean findSmall = arr[k] < arr[k + 1];
        k++;
        int count = 2;
        while (k + 1 < n) {
            if (findSmall && arr[k + 1] < arr[k]) {
                findSmall = false;
                count++;
            } else if (!findSmall && arr[k + 1] > arr[k]) {
                findSmall = true;
                count++;
            }
            k++;
        }

        return count;
    }
}
