package google.codejam.y2016.qualification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/6254486/dashboard#s=p1
 */
public class FlipPanCakes {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            List<Character> pc = list(in.next().toCharArray());

            if (happy(pc)) {
                System.out.printf("Case #%d: 0\n", i + 1);
            } else if (negative(pc)) {
                System.out.printf("Case #%d: 1\n", i + 1);
            } else {
                int steps = 0;
                while (!happy(pc)) {

                    // Flip first + to -
                    if (pc.get(0).equals('+')) {
                        steps++;
                        flip(pc, 0, pc.indexOf('-') - 1);
                    }

                    // Flip until last -
                    flip(pc, 0, pc.lastIndexOf('-'));
                    steps++;
                }

                System.out.printf("Case #%d: %d\n", i + 1, steps);
            }
        }
    }

    private static void flip(List<Character> pc, int i, int j) {
        Collections.reverse(pc.subList(i, j + 1));
        for (int k = i; k <= j; k++) {
            pc.set(k, flip(pc.get(k)));
        }
    }

    private static Character flip(Character c) {
        return c.equals('+') ? '-' : '+';
    }

    private static List<Character> list(char[] chars) {
        List<Character> l = new ArrayList<>();
        for (Character c : chars) {
            l.add(c);
        }
        return l;
    }

    private static boolean negative(List<Character> pc) {
        for (Character c : pc) {
            if (c.equals('+')) {
                return false;
            }
        }
        return true;
    }

    private static boolean happy(List<Character> pc) {
        for (Character c : pc) {
            if (c.equals('-')) {
                return false;
            }
        }
        return true;
    }
}
