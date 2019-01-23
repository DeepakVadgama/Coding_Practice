package google.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a pair of numbers (1,3), (2,6), (4,5)
 * and a array of same numbers (3,5,6,4,1,2)
 * <p>
 * Find minimum number of swaps in array so that paired numbers are adjacent
 */
public class ArrayToPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // BiMap would serve better. Will reduce verbosity a lot
        Map<Integer, Integer> pairs = getPairs(in, n);
        Map<Integer, Integer> flippedPairs = flipPairs(pairs);


        int[] numbers = getArray(in, n);
        Map<Integer, Integer> indexes = getIndexMap(numbers); // This improves complexity from O(n2) to O(n)

        int count = 0;
        for (int i = 0; i < numbers.length; i = i + 2) {
            int e1 = numbers[i];
            int e2 = pairs.containsKey(e1) ? pairs.get(e1) : flippedPairs.get(e1);
            int j = indexes.get(e2);
            if (i + 1 != j) {
                swap(numbers, i + 1, j);
                swapIndex(indexes, numbers[i + 1], numbers[j]);
                count++;
            }
        }

        System.out.println(Arrays.toString(numbers));
        System.out.println(count);
    }

    private static void swapIndex(Map<Integer, Integer> indexes, int i, int j) {
        int temp = indexes.get(i);
        indexes.put(i, indexes.get(j));
        indexes.put(j, temp);
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    private static Map<Integer, Integer> getIndexMap(int[] numbers) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            indexes.put(numbers[i], i);
        }
        return indexes;
    }

    private static int[] getArray(Scanner in, int n) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        return num;
    }

    private static Map<Integer, Integer> flipPairs(Map<Integer, Integer> pairs) {
        Map<Integer, Integer> flipped = new HashMap<>(pairs.size());
        for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
            flipped.put(entry.getValue(), entry.getKey());
        }
        return flipped;
    }

    private static Map<Integer, Integer> getPairs(Scanner in, int n) {
        Map<Integer, Integer> pairs = new HashMap<>(n);
        for (int i = 0; i < n / 2; i++) {
            pairs.put(in.nextInt(), in.nextInt());
        }
        return pairs;
    }
}
