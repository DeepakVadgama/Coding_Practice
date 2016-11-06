package leetcode;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {
    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("10[leetcode]"));
    }

    public static String decodeString(String str) {
        while (str.contains("]")) {
            int end = str.indexOf(']');
            int start = getStart(str, end);
            Integer count = getDigit(str, start);
            String pattern = str.substring(start + 1, end);
            String original = count.toString() + "[" + pattern + "]";
            String result = repeat(pattern, count);
            str = str.replaceAll(Pattern.quote(original), result);
        }
        return str;
    }

    private static int getDigit(String str, int end) {
        int start = end;
        while (start > 0 && Character.isDigit(str.charAt(start - 1))) {
            start--;
        }
        return Integer.parseInt(str.substring(start, end));
    }

    private static String repeat(String string, int count) {
        StringBuilder result = new StringBuilder();
        IntStream.rangeClosed(1, count).forEach(k -> result.append(string));
        return result.toString();
    }

    private static int getStart(String str, int end) {
        while (end > 0 && str.charAt(end) != '[') end--;
        return end;
    }
}
