package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kangaroo
 */
public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        // Rates and Starting point both
        if (x2 > x1 && v2 > v1) {
            System.out.println("NO");
            return;
        }

        boolean gapDecreasing = true;
        while (gapDecreasing) {
            if (x2 == x1) {
                System.out.println("YES");
                return;
            }
            int gap = x2 - x1;
            x1 = x1 + v1;
            x2 = x2 + v2;
            int newGap = x2 - x1;
            gapDecreasing = newGap < gap;
        }
        System.out.println("NO");
    }
}
