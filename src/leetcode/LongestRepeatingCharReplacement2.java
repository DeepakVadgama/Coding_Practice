package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * <p>
 * Eg: ZDDDDKKPMPKKKPAXKKKKK
 * <p>
 * k = 3
 * <p>
 * Answer: 11
 * <p>
 * Using Sliding Window.
 */
public class LongestRepeatingCharReplacement2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int k = in.nextInt();
        System.out.println(characterReplacement(str, k));
    }

    public static int characterReplacement(String str, int k) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int[] charCounts = new int[26];
        Arrays.fill(charCounts, 0);
        int maxRepChars = 0;
        int maxLength = 0;

        for (; end < str.length(); end++) {
            int ch = str.charAt(end) - 'A';
            charCounts[ch]++;
            maxRepChars = Math.max(maxRepChars, charCounts[ch]);
            if (end - start + 1 - maxRepChars > k) {
                charCounts[str.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

}
