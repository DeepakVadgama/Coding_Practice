package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Temp {

    public static void main(String[] args) {
        Temp temp = new Temp();
        System.out.println(temp.minWindow("ADFBSDBANC", "ABC"));
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> freq = countFrequencies(t);
        int count = freq.size();
        int start = 0;
        int end = 0;
        int maxLength = Integer.MAX_VALUE;
        String output = s;


        while (end < s.length()) {

            char endChar = s.charAt(end);
            if (freq.containsKey(endChar)) {
                freq.put(endChar, freq.get(endChar) - 1);
                if (freq.get(endChar) == 0) {
                    count--;
                }
            }

            while (count == 0) {

                if (maxLength > (end - start + 1)) {
                    maxLength = end - start + 1;
                    output = s.substring(start, end + 1);
                }

                char startChar = s.charAt(start);
                if (freq.containsKey(startChar)) {
                    freq.put(startChar, freq.get(startChar) + 1);
                    if (freq.get(startChar) > 0) {
                        count++;
                    }
                }
                start++;
            }

            end++;
        }

        return output;
    }

    public Map<Character, Integer> countFrequencies(String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.putIfAbsent(c, 0);
            freq.put(c, freq.get(c) + 1);
        }
        return freq;
    }

}
