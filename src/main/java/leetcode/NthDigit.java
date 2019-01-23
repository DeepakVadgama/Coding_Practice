package leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/nth-digit/
 */
public class NthDigit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(findNthDigit(n));
    }

    public static int findNthDigit(int m) {

        if (m < 10) {
            return m;
        }

        long n = m;
        long i = 1;
        long mul = 9;
        long start = 1;
        while (n > i * mul) {
            n = n - i * mul;
            mul = mul * 10;
            start = start * 10;
            i++;
        }

        start = start + (n - 1) / i;
        return Long.toString(start).charAt((int) ((n - 1) % i)) - '0';
    }
}
