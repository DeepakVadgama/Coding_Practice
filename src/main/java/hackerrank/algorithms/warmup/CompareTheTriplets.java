package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/compare-the-triplets
 */
public class CompareTheTriplets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int alice = 0;
        int bob = 0;

        // Test 1
        if (a0 > b0) {
            alice++;
        } else if (b0 > a0) {
            bob++;
        }

        // Test 2
        if (a1 > b1) {
            alice++;
        } else if (b1 > a1) {
            bob++;
        }

        // Test 3
        if (a2 > b2) {
            alice++;
        } else if (b2 > a2) {
            bob++;
        }

        System.out.println(alice + " " + bob);
    }
}
