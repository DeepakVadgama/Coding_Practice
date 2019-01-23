package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 * <p>
 * Same as Google CodeJam 2016 Round 1B Getting The Digits
 * <p>
 * Here used array to store counts, and then processed that count array instead of original string.
 * Even storage wise this is efficient, and its much faster!
 * <p>
 * Also, it doesnt destroy the string as in the other program.
 */
public class DigitsFromJumbledEnglish2 {
    private static HashMap<String, Integer> words = new HashMap<>();
    private static HashMap<Character, String> unique = new LinkedHashMap<>();

    static {
        setup();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(originalDigits(s));
    }

    public static String originalDigits(String s) {

        int[] counts = getCounts(s);

        List<Integer> ss = new ArrayList<>();

        for (Character character : unique.keySet()) {
            int ch = character - 'a';
            while (counts[ch] > 0) {
                removeAll(counts, unique.get(character));
                ss.add(words.get(unique.get(character)));
            }
        }
        Collections.sort(ss);
        return ss.stream().map(Object::toString).collect(Collectors.joining());
    }

    private static int[] getCounts(String str) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        return counts;
    }

    private static void removeAll(int[] counts, String str) {
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']--;
        }
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

        unique.put('z', "zero");
        unique.put('g', "eight");
        unique.put('w', "two");
        unique.put('u', "four");
        unique.put('x', "six");
        unique.put('r', "three");
        unique.put('o', "one");
        unique.put('f', "five");
        unique.put('i', "nine");
        unique.put('v', "seven");
    }


}
