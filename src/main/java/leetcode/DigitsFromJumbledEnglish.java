package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 * <p>
 * Same as Google CodeJam 2016 Round 1B Getting The Digits
 */
public class DigitsFromJumbledEnglish {
    private static HashMap<String, Integer> words = new HashMap<>();
    private static HashMap<String, String> unique = new LinkedHashMap<>();

    static {
        setup();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(originalDigits(s));
    }

    public static String originalDigits(String s) {

        List<Integer> ss = new ArrayList<>();

        for (String a : unique.keySet()) {
            while (s.contains(a)) {
                s = removeAll(s, unique.get(a));
                ss.add(words.get(unique.get(a)));
            }
        }
        Collections.sort(ss);
        return ss.stream().map(Object::toString).collect(Collectors.joining());
    }

    private static String removeAll(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            s1 = s1.replaceFirst(s2.substring(i, i + 1), "");
        }
        return s1;
    }

    private static void setup() {
        words.put("zero", 0);
        words.put("one", 1);
        words.put("two", 2);
        words.put("three", 3);
        words.put("four", 4);
        words.put("five", 5);
        words.put("six", 6);
        words.put("seven", 7);
        words.put("eight", 8);
        words.put("nine", 9);

        unique.put("z", "zero");
        unique.put("g", "eight");
        unique.put("w", "two");
        unique.put("u", "four");
        unique.put("x", "six");
        unique.put("r", "three");
        unique.put("o", "one");
        unique.put("f", "five");
        unique.put("i", "nine");
        unique.put("v", "seven");
    }


}
