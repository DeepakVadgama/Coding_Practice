package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/rearrange-string-k-distance-apart
 * <p>
 * In Java there is no map DS which can sort based on keys.
 * Then our solution would be easy - Add to say, TreeMap (freq, char),
 * Iterate over map with highest freq first, and place in empty str k distance apart
 */
public class RearrangeStringKDistanceApart {
    public static void main(String[] args) {
        System.out.println(rearrangeString("abb", 2));
        System.out.println(rearrangeString("aacbbc", 3));
        System.out.println(rearrangeString("aaa", 3));
    }

    public static String rearrangeString(String str, int k) {
        PriorityQueue<CharWithFreq> queue = new PriorityQueue<>(Comparator.reverseOrder());

        // Calculate frequency
        int count[] = new int[26]; // assuming all lower-case
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        // Sort based on frequency
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                queue.offer(new CharWithFreq((char) (i + 'a'), count[i]));
            }
        }

        // Place each char (starting with highest freq), in empty string
        char[] result = new char[str.length()];
        Arrays.fill(result, ' ');
        int pos = 0;
        while (!queue.isEmpty()) {
            int index = pos;
            CharWithFreq cwf = queue.poll();
            for (int i = 0; i < cwf.frequency; i++) {
                if (index >= str.length()) {
                    return "";
                }
                result[index] = cwf.alphabet;
                index += k;
            }
            pos++;
        }
        return String.valueOf(result);
    }

    public static class CharWithFreq implements Comparable<CharWithFreq> {
        public char alphabet;
        public int frequency;

        public CharWithFreq(char alphabet, int frequency) {
            this.alphabet = alphabet;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(CharWithFreq o) {
            return frequency - o.frequency;
        }
    }

}
