package leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(longestPalindrome(str));
    }

    public static int longestPalindrome(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a']++;
            } else {
                upper[ch - 'A']++;
            }
        }

        int count = 0;
        boolean extraChar = false;
        for (int i = 0; i < 26; i++) {
            count += upper[i];
            if (upper[i] % 2 != 0) {
                count--;
                extraChar = true;
            }

            count += lower[i];
            if (lower[i] % 2 != 0) {
                count--;
                extraChar = true;
            }
        }
        if (extraChar) count++;
        return count;
    }
}
