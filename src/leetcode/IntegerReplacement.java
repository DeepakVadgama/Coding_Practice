package leetcode;

/**
 * https://leetcode.com/problems/integer-replacement/
 * <p>
 * Cheated - https://discuss.leetcode.com/topic/58334/a-couple-of-java-solutions-with-explanations
 */
public class IntegerReplacement {

    public static void main(String[] args) {
//        System.out.println(integerReplacement(8));
//        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(24));
    }

    public static int integerReplacement(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n == 3) {
                n--;
            } else if (Integer.bitCount(n - 1) < Integer.bitCount(n + 1)) {
                n--;
            } else {
                n++;
            }
            count++;
        }
        return count;
    }
}
