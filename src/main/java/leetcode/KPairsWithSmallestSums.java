package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class KPairsWithSmallestSums {

    public static void main(String[] args) {
        kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2).forEach(k -> System.out.println(Arrays.toString(k) + ", "));
    }

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        Queue<int[]> sums = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0] + o2[1], o1[0] + o1[1]));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                sums.add(new int[]{nums1[i], nums2[j]});
                if (sums.size() > k) {
                    sums.remove();
                }
            }
        }
        return sums.stream().collect(Collectors.toList());
    }

}
