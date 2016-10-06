package google.codejam.y2016.qualification;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://code.google.com/codejam/contest/6254486/dashboard#s=p0
 */
public class CountingSheep {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            if (n == 0) {
                System.out.printf("case #%d: INSOMNIA\n", i + 1);
            } else {
                Set<Integer> d = digits();
                int v = 0;
                for (int j = 1; !d.isEmpty(); j++) {
                    v = n * j;
                    removeDigits(d, v);
                }
                System.out.printf("case #%d: %d\n", i + 1, v);
            }
        }
    }

    private static void removeDigits(Set<Integer> d, int n) {
        while (n > 0) {
            d.remove(n % 10);
            n = n / 10;
        }
    }

    private static Set<Integer> digits() {
        Set<Integer> digits = new HashSet<>(10);
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }
        return digits;
    }
}
