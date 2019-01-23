package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-time-in-words
 */
public class TheTimeInWords {

    private static Map<Integer, String> words = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();

        if (m == 0) {
            System.out.println(words.get(h) + " o' clock");
        } else if (m == 30) {
            System.out.println("half past " + words.get(h));
        } else if (m < 30) {
            if (m == 15) {
                System.out.println("quarter past " + words.get(h));
            } else {
                System.out.println(words.get(m) + " " + minutes(m) + " past " + words.get(h));
            }
        } else if (m > 30) {
            h = h == 12 ? 1 : h + 1;
            if (m == 45) {
                System.out.println("quarter to " + words.get(h));
            } else {
                System.out.println(words.get(60 - m) + " " + minutes(m) + " to " + words.get(h));
            }
        }
    }

    private static String minutes(int m) {
        if (m == 1) {
            return "minute";
        } else {
            return "minutes";
        }
    }

    static {
        words.put(1, "one");
        words.put(2, "two");
        words.put(3, "three");
        words.put(4, "four");
        words.put(5, "five");
        words.put(6, "six");
        words.put(7, "seven");
        words.put(8, "eight");
        words.put(9, "nine");
        words.put(10, "ten");
        words.put(11, "eleven");
        words.put(12, "twelve");
        words.put(13, "thirteen");
        words.put(14, "fourteen");
        words.put(15, "fifteen");
        words.put(16, "sixteen");
        words.put(17, "seventeen");
        words.put(18, "eighteen");
        words.put(19, "nineteen");
        words.put(20, "twenty");
        words.put(21, "twenty one");
        words.put(22, "twenty two");
        words.put(23, "twenty three");
        words.put(24, "twenty four");
        words.put(25, "twenty five");
        words.put(26, "twenty six");
        words.put(27, "twenty seven");
        words.put(28, "twenty eight");
        words.put(29, "twenty nine");
    }
}
