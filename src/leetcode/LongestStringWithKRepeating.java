package leetcode;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestStringWithKRepeating {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
    }

    public static int longestSubstring(String s, int k) {
        return getMax(s, 0, s.length() - 1, k);
    }

    public static int getMax(String s, int start, int end, int k) {

        if (start > end || (end - start + 1) < k) {
            return 0;
        }

        int charCount[] = charCount(s, start, end);
        for (int i = start; i <= end; i++) {
            int cc = charCount[s.charAt(i) - 'a'];
            if (cc > 0 && cc < k) {
                return Math.max(getMax(s, start, i - 1, k), getMax(s, i + 1, end, k));
            }
        }
        return end - start + 1;
    }

    private static int[] charCount(String s, int start, int end) {
        int[] charCount = new int[26];
        for (int i = start; i <= end; i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        return charCount;
    }
}
