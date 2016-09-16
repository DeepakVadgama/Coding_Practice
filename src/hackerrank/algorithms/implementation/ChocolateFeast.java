package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/chocolate-feast
 */
public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();

            int ctr = n / c;
            int w = n / c;
            while (w >= m) {
                int ch = w / m;
                w = ch + (w % m);
                ctr += ch;
            }
            System.out.println(ctr);
        }
    }
}
