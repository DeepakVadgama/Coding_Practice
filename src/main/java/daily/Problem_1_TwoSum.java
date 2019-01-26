package daily;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class Problem_1_TwoSum {

    public static void main(String[] args) {

        int[] numbers = {10, 15, 3, 7};
        int k = 17;

        naive(numbers, k);
        singlePass(numbers, k);
        singlePass2(numbers, k);
    }

    // O(nlog n) time, O(1) space
    // if using radix sort O(n.k) but space O(n + k)
    private static void singlePass2(int[] numbers, int k) {
        Arrays.sort(numbers);
        for (int num1 : numbers) {
            if (Arrays.binarySearch(numbers, k - num1) > 0) {
                System.out.println(num1 + " " + (k - num1));
                return;
            }
        }
    }

    // O(n) time, O(n) space
    private static void singlePass(int[] numbers, int k) {
        HashSet<Integer> previous = new HashSet<>();
        for (int num1 : numbers) {
            if (previous.contains(k - num1)) {
                System.out.println(num1 + " " + (k - num1));
            } else {
                previous.add(num1);
            }
        }
    }

    // O(n^2) time O(1) space
    private static void naive(int[] numbers, int k) {
        for (int i = 0; i < numbers.length; i++) {
            int num1 = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int num2 = numbers[j];
                if (num1 + num2 == k) {
                    System.out.println(num1 + " " + num2);
                    return;
                }
            }
        }
    }
}
