package leetcode;

import java.util.HashMap;
import java.util.Map;
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
 * My solution is quite different (and more verbose) than mentioned on the discussion.
 */
public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int k = in.nextInt();
        System.out.println(characterReplacement(str, k));
    }

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = -1;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, countOfLongestSubstring(chars, (char) ('A' + i), k));
        }
        return max;
    }

    private static int countOfLongestSubstring(char[] chars, char c, int k) {
        int maxCount = -1;
        Map<Integer, Integer> indexes = createIndexes(chars, c);
        for (Map.Entry<Integer, Integer> entry : indexes.entrySet()) {
            int tk = k;
            int i = entry.getKey();
            int j = entry.getValue();
            int count = j - i + 1;
            j++;
            while (tk > 0 && j < chars.length) {
                if (chars[j] != c) {
                    tk--;
                }
                count++;
                j++;
            }
            count = count + Math.min(chars.length - count, tk);
            if (indexes.containsKey(j)) {
                count = count + indexes.get(j) - j + 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private static Map<Integer, Integer> createIndexes(char[] chars, char c) {
        Map<Integer, Integer> indexes = new HashMap<>();
        int start = -1;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == c) {
                if (start == -1) {
                    start = j;
                }
                indexes.put(start, j);
            } else {
                start = -1;
            }
        }
        return indexes;
    }
}
