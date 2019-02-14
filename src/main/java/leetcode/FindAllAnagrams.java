package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

    public static void main(String[] args) {
        FindAllAnagrams obj = new FindAllAnagrams();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String t) {

        Map<Character, Integer> freq = frequencyCounts(t);
        int count = freq.size();
        int start = 0;
        int end = 0;
        List<Integer> anagramIndices = new LinkedList<>();

        while (end < s.length()) {

            char endChar = s.charAt(end);

            if (freq.containsKey(endChar)) {
                freq.put(endChar, freq.get(endChar) - 1);
                if (freq.get(endChar) == 0) {
                    count--;
                }
            }


            while (count == 0) {
                if ((end - start + 1) == t.length()) {
                    anagramIndices.add(start);
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

        return anagramIndices;
    }


    private Map<Character, Integer> frequencyCounts(String t) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : t.toCharArray()) {
            counts.putIfAbsent(c, 0);
            counts.put(c, counts.get(c) + 1);
        }
        return counts;
    }

}
