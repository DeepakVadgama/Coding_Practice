package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/service-lane
 */
public class ServiceLane {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int w[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int en = in.nextInt();
            int ex = in.nextInt();

            int min = Integer.MAX_VALUE;
            for (int k = en; k <= ex; k++) {
                if (w[k] < min) {
                    min = w[k];
                }
            }
            System.out.println(min);
        }

    }
}
