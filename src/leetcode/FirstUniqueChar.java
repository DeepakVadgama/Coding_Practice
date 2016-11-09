package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] counts = new int[26]; // char counts
        LinkedHashMap<Character, Integer> firstIndex = new LinkedHashMap<>(26); // first indexes

        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a']++ == 0) {
                firstIndex.put(s.charAt(i), i);
            }
        }

        for (Map.Entry<Character, Integer> entry : firstIndex.entrySet()) {
            int i = entry.getKey() - 'a';
            if (counts[i] == 1) {
                return entry.getValue();
            }
        }
        return -1;
    }
}
