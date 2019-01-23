package google.codejam.y2016.round1a;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://code.google.com/codejam/contest/4304486/dashboard#s=p2
 * <p>
 * First and last person in the circle need to be friend?
 */
public class BestFriend {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {

            int n = in.nextInt();
            int[] bff = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                bff[i] = in.nextInt();
            }

            int max = 0;
            for (int i = 1; i <= n; i++) {

                int f = i;
                Set<Integer> chain = new HashSet<>();
                while (!chain.contains(f)) {
                    chain.add(f);
                    f = bff[f];
                }

                // Special case where child has 2 best friends
                if (frequency(bff, i) > 1) {
                    max = Math.max(max, chain.size() + 1);
                } else {
                    max = Math.max(max, chain.size());
                }
            }

            System.out.printf("Case #%d: %d\n", k + 1, max);
        }


    }

    private static int frequency(int[] bff, int i) {
        int ctr = 0;
        for (int j = 0; j < bff.length; j++) {
            if (i == bff[j]) {
                ctr++;
            }
        }
        return ctr;
    }
}
