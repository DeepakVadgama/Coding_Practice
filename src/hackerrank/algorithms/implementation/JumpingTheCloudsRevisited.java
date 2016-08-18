package hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
 */
public class JumpingTheCloudsRevisited {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = in.nextInt();

        int units = t / k;
        int n[] = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = in.nextInt();
        }

        for (int i = 0; i < t; i++) {
            final int v = n[i];
            if (v == 1 && i % k == 0) {
                units += 2;
            }
        }
        System.out.println(100 - units);
    }
}
