package leetcode;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("abcdefd", "ladbcdef"));
    }

    public static char findTheDifference(String s, String t) {
        int[] counts = new int[26]; //alphabet counts
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }
}
