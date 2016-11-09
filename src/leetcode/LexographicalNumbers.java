package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 * <p>
 * Cheated: https://discuss.leetcode.com/topic/55184/java-o-n-time-o-1-space-iterative-solution-130ms
 */
public class LexographicalNumbers {

    public static void main(String[] args) {
        System.out.println(lexicalOrder(100));
    }

    public static List<Integer> lexicalOrder(int n) {

        List<Integer> result = new ArrayList<>(n);
        int val = 1;
        for (int i = 1; i <= n; i++) {
            result.add(val);
            if (val * 10 <= n) {
                val *= 10;
            } else if (val % 10 != 9 && val + 1 <= n) {
                val++;
            } else {
                while ((val / 10) % 10 == 9) {
                    val /= 10;
                }
                val = val / 10 + 1;
            }
        }
        return result;
    }
}
