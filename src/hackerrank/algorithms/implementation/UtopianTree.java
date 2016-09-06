package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/utopian-tree
 * <p>
 * No fancy memoization, or tricks since constraints are so small
 */
public class UtopianTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int h = 1;
            for (int j = 1; j <= n; j++) {
                if (j % 2 == 0) {
                    h += 1;
                } else {
                    h = h * 2;
                }
            }
            System.out.println(h);
        }
    }
}
