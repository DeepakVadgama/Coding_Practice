package hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/manasa-and-stones
 */
public class ManasaAndStones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int s = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            Set<Integer> sol = new TreeSet<>();

//            solve(sol, 0, s - 1, a, b);
            for (int j = 0; j < s; j++) {
                sol.add(j * a + (s - j - 1) * b);
            }
            System.out.println(sol.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }

    // Correct but times out
    private static void solve(Set<Integer> sol, int c, int s, int a, int b) {
        if (s == 0) {
            sol.add(c);
        } else {
            solve(sol, c + a, s - 1, a, b);
            solve(sol, c + b, s - 1, a, b);
        }
    }
}
