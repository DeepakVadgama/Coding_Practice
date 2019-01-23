package leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/ -- without 2's complement
 */
public class DigitToHex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(convertToHex(n));
    }

    private static String convertToHex(int n) {

        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        if (n < 0) {
            return "";
        }

        String output = "";
        while (n > 0) {
            output = hex[n % 16] + output;
            n = n / 16;
        }
        return output;
    }
}
