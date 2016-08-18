package hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/strange-code
 */
public class StrangeCode {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        long t = in.nextLong();

        long t1 = 1;
        long n = 3;

        // convert to division operation
        while (t1 < t) {
            t1 = t1 + n;
            n = n * 2;
        }
        if (t1 == t) {
            System.out.println(n);
        } else {
            n = n / 2;
            t1 = t1 - n;
            System.out.println(n - (t - t1));
        }
    }
}
