package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://leetcode.com/problems/frog-jump/
 * <p>
 * Wrong solution.. See this for correct one
 * https://discuss.leetcode.com/topic/61561/simple-and-easy-understand-java-solution
 */
public class FrogJumps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int k = 1;
        System.out.println(solve(arr, k));
    }

    private static boolean solve(int[] arr, int k) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return jump(arr, 0, k, visited);
    }

    /**
     * Using recursion and memoization.
     */
    private static boolean jump(int[] arr, int i, int k, Set<Integer> visited) {
        if (i == arr[arr.length - 1]) {
            return true;
        } else if (k <= 0 || i > arr[arr.length - 1]) {
            return false;
        } else {
            return jump(arr, i + k, k, visited)
                    || jump(arr, i + k - 1, k - 1, visited)
                    || jump(arr, i + k + 1, k + 1, visited);
        }
    }
}
