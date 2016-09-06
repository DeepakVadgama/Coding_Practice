package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/minimum-distances
 */
public class MinimumDistances {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> a = new HashMap<>(n);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            if (a.containsKey(v) && min > i - a.get(v)) {
                min = i - a.get(v);
            }
            a.put(v, i);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
