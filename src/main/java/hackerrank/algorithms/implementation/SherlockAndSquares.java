package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-squares
 */
public class SherlockAndSquares {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n1 = in.nextLong();
            long n2 = in.nextLong();

            int ctr = 0;

            // Instead of finding roots or all numbers, find root of first
            // increment, find square, check if in range... repeat
            long c = (long) Math.sqrt(n1);
            long sq = c * c;
            while (sq <= n2) {
                if (sq >= n1 && sq <= n2) {
                    ctr++;
                }
                c++;
                sq = c * c;
            }
            System.out.println(ctr);
        }

    }
}
