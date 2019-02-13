package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        MinWindowSubstring obj = new MinWindowSubstring();
//        System.out.println(obj.minWindow("ACDBNA", "AB"));
//        System.out.println(obj.minWindow("ADBECEBANC", "ABC"));
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> freq = charFrequencies(t);
        int uniqueCount = freq.size();
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        String output = "";

        while (end < s.length()) {

            char endChar = s.charAt(end);
            if (freq.containsKey(endChar)) {

                freq.put(endChar, freq.get(endChar) - 1);
                if (freq.get(endChar) == 0) {
                    uniqueCount--;
                }

                while (uniqueCount == 0) {

                    if ((end - start + 1) < minLength) {
                        minLength = end - start + 1;
                        output = s.substring(start, end + 1);
                    }

                    char startChar = s.charAt(start);
                    if (freq.containsKey(startChar)) {
                        freq.put(startChar, freq.get(startChar) + 1);
                        if (freq.get(startChar) > 0) {
                            uniqueCount++;
                        }
                    }
                    start++;
                }
            }
            end++;
        }

        return output;
    }

    private Map<Character, Integer> charFrequencies(String input) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (Character c : input.toCharArray()) {
            frequencies.putIfAbsent(c, 0);
            frequencies.put(c, frequencies.get(c) + 1);
        }
        return frequencies;
    }

}
