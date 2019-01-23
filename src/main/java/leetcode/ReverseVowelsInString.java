package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsInString {
    public static void main(String[] args) {
//        System.out.println(reverseVowels("hello"));
//        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("Unglad, I tar a tidal gnu."));
    }

    public static final List<Character> VOWELS
            = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    // In place
    public static String reverseVowels(String str) {

        char[] chars = str.toCharArray();
        int i = 0, j = chars.length - 1;
        while (true) {
            while (i < chars.length && !isVowel(chars[i])) i++;
            while (j >= 0 && !isVowel(chars[j])) j--;

            if (j < 0 || i >= chars.length || i >= j) {
                break;
            } else {
                swap(chars, i++, j--);
            }
        }
        return new String(chars);
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    private static boolean isVowel(char c) {
        return VOWELS.contains(c);
    }
}
