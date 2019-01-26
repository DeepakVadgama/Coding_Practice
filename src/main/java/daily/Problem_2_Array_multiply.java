package daily;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index i of
 * the new array is the product of all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output
 * would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class Problem_2_Array_multiply {

    public static void main(String[] args) {

//        int[] numbers = {1, 2, 3, 4, 5};
//        int[] numbers = {1, 2, 3, 0, 5};
        int[] numbers = {1, 2, 3, 0, 0};
        long[] output = new long[numbers.length];

        // if bigger, then use BigInteger
        long grandMultiplication = multiplyAll(numbers);

        // numbers contains atleast one 0
        if (grandMultiplication == 0) {

            Arrays.fill(output, 0);
            int index = containsSingleZero(numbers);
            if (index > -1) {
                output[index] = multiplyExceptZeros(numbers);
            }
        } else {

            for (int i = 0; i < numbers.length; i++) {
                output[i] = grandMultiplication / (long) numbers[i];
            }
        }

        System.out.println(Arrays.toString(output));
    }

    private static long multiplyExceptZeros(int[] numbers) {
        long output = 1;
        for (int number : numbers) {
            if (number != 0) {
                output = output * number;
            }
        }
        return output;
    }

    private static int containsSingleZero(int[] numbers) {

        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0 && index > -1) {
                return -1;
            } else if (numbers[i] == 0) {
                index = i;
            }
        }
        return index;
    }

    private static long multiplyAll(int[] numbers) {
        long output = 1;
        for (int number : numbers) {
            output = output * number;
        }
        return output;
    }
}
