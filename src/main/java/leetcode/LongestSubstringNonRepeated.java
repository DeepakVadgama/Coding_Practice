package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstringNonRepeated {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringNonRepeated().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringNonRepeated().lengthOfLongestSubstring("abcdbefc"));
    }

    public int lengthOfLongestSubstring(String input) {

        Set<Character> window = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxCount = 0;

        while (end < input.length()) {

            Character currentChar = input.charAt(end++);
            if (window.contains(currentChar)) {
                while (input.charAt(start) != currentChar) {
                    window.remove(input.charAt(start));
                    start++;
                }
                start++;
            }
            window.add(currentChar);
            if (window.size() > maxCount) {
                maxCount = window.size();
            }
        }
        return maxCount;

    }
}

