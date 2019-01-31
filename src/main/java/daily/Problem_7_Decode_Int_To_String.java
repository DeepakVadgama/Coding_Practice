package daily;

import java.util.Arrays;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * <p>
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * <p>
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 * <p>
 * Count possible decodings of a digit sequence
 */
public class Problem_7_Decode_Int_To_String {

    public static void main(String[] args) {

//        int[] input = {1, 1, 2, 3, 1};
        int[] input = {9, 1, 8};
//        int[] input = {1, 2, 1};

        int[] memoizedCount = new int[input.length];
        Arrays.fill(memoizedCount, -1);

        int count = decodedCount(input, memoizedCount, 0);
        System.out.println(count);
    }

    private static int decodedCount(int[] input, int[] memoizedCount, int index) {

        if (index >= input.length) {
            return 0;
        }

        if (index == input.length - 1) {
            memoizedCount[index] = 1;
            return 1;
        }

        if (memoizedCount[index] >= 0) {
            return memoizedCount[index];
        }

        int count = decodedCount(input, memoizedCount, index + 1);
        if (validNumber(input, index, index + 1)) {
            count += 1 + decodedCount(input, memoizedCount, index + 2);
        }

        memoizedCount[index] = count;
        return count;
    }

    private static boolean validNumber(int[] input, int index, int index2) {
        return index < input.length
                && index2 < input.length
                && (input[index] == 1 || (input[index] == 2 && input[index2] <= 6));
    }
}
