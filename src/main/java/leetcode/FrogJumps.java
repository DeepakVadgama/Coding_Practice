package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/frog-jump/
 * <p>
 * cheated -- found solution here
 * https://discuss.leetcode.com/topic/61561/simple-and-easy-understand-java-solution
 * <p>
 * eg:
 * 0 1 2 3 6 8 12 17  // true
 * 0 1 2 3 4 8 9 11  // false
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

        if (!startsWith(arr, 0, 1)) {
            return false;
        }

        Map<Integer, Set<Integer>> jumps = new HashMap<>();
        jumps.computeIfAbsent(1, key -> new HashSet<>()).add(1);

        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                int dist = arr[i] - arr[j];
                Set<Integer> jumpSet = jumps.get(arr[j]);
                if (jumpSet != null
                        && (jumpSet.contains(dist)
                        || jumpSet.contains(dist + 1)
                        || jumpSet.contains(dist - 1))) {
                    jumps.computeIfAbsent(arr[i], key -> new HashSet<>()).add(dist);
                }
            }
        }
        return jumps.get(arr[arr.length - 1]) != null;
    }

    private static boolean startsWith(int[] arr, int i, int j) {
        return arr.length >= 2 && arr[0] == i && arr[1] == j;
    }
}
