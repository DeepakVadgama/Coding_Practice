package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/taum-and-bday
 */
public class TaumAndBdays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            long b = in.nextLong();
            long w = in.nextLong();
            long bc = in.nextLong();
            long wc = in.nextLong();
            long cc = in.nextLong();

            long total = 0;

            if ((bc + cc) < wc) {
                total = bc * b + (bc + cc) * w;
            } else if ((wc + cc) < bc) {
                total = (wc + cc) * b + wc * w;
            } else {
                total = bc * b + wc * w;
            }
            System.out.println(total);
        }
    }
}
