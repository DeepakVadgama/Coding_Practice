package google.codejam.y2016.round1b;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://code.google.com/codejam/contest/11254486/dashboard
 */
public class GettingTheDigits {

    private static HashMap<String, Integer> words = new HashMap<>();
    private static HashMap<String, String> unique = new LinkedHashMap<>();


    public static void main(String[] args) {

        setup();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            String s = in.next();
            List<Integer> ss = new ArrayList<>();

            for (String a : unique.keySet()) {
                while (s.contains(a)) {
                    s = removeAll(s, unique.get(a));
                    ss.add(words.get(unique.get(a)));
                }
            }
            Collections.sort(ss);
            System.out.printf("Case #%d: %s\n", k + 1, ss.stream().map(Object::toString).collect(Collectors.joining()));
        }


    }

    private static String removeAll(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            s1 = s1.replaceFirst(s2.substring(i, i + 1), "");
        }
        return s1;
    }

    private static void setup() {
        words.put("ZERO", 0);
        words.put("ONE", 1);
        words.put("TWO", 2);
        words.put("THREE", 3);
        words.put("FOUR", 4);
        words.put("FIVE", 5);
        words.put("SIX", 6);
        words.put("SEVEN", 7);
        words.put("EIGHT", 8);
        words.put("NINE", 9);

        unique.put("Z", "ZERO");
        unique.put("G", "EIGHT");
        unique.put("W", "TWO");
        unique.put("U", "FOUR");
        unique.put("X", "SIX");
        unique.put("R", "THREE");
        unique.put("O", "ONE");
        unique.put("F", "FIVE");
        unique.put("I", "NINE");
        unique.put("V", "SEVEN");
    }

}
