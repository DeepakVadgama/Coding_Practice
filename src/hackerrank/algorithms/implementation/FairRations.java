package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fair-rations
 */
public class FairRations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b[] = new int[t];
        for (int i = 0; i < t; i++) {
            b[i] = in.nextInt();
        }

        int l = 0;
        for (int i = 0; i < t - 1; i++) {
            if (b[i] % 2 == 1) {
                b[i] = b[i] + 1;
                b[i + 1] = b[i + 1] + 1;
                l += 2;
            }
        }

        if (b[t - 1] % 2 == 1) {
            System.out.println("NO");
        } else {
            System.out.println(l);
        }
    }
}
