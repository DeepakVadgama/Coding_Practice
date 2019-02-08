package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array
 */
public class RepeatedNumInArray {

    public static void main(String[] args) {

    }

    public int repeatedNTimes(int[] A) {

        if (A == null || A.length == 0) {
            return -1;
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : A) {
            if (uniqueNumbers.contains(num)) {
                return num;
            }
            uniqueNumbers.add(num);
        }
        return -1;
    }

}
