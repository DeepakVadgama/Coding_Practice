package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class JumpingOnTheClouds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }

        int jumps = 0;
        int i = 0;
        while (i < n - 1) {
            if (i + 2 < n && (c[i + 2] == 1 || c[i + 2] > n)) {
                i++;
            } else {
                i += 2;
            }
            jumps++;
        }

        System.out.println(jumps);
    }
}
