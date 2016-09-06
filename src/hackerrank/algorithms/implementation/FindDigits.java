package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-digits
 */
public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long v = in.nextLong();

            long n = v;
            int c = 0;
            while (n > 0) {
                long d = n % 10;
                if (d != 0 && v % d == 0) {
                    c++;
                }
                n = n / 10;
            }
            System.out.println(c);
        }
    }
}
