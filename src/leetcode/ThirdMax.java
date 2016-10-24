package leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] nums) {
        Integer m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE, m3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val > m1) {
                m3 = m2;
                m2 = m1;
                m1 = val;
            } else if (val > m2 && val != m1) {
                m3 = m2;
                m2 = val;
            } else if (val > m3 && val != m1 && val != m2) {
                m3 = val;
            }
        }

        if (m3 != Integer.MIN_VALUE) {
            return m3;
        }
        return m1;
    }
}
