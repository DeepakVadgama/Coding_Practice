package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor
 */
public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int pre = 0;
            for (int j = 0; j < n; j++) {
                if (in.nextInt() <= 0) {
                    pre++;
                }
            }
            if (pre >= k) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }
}
