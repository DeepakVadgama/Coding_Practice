package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor
 */
public class LisaWorkbook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }

        int page = 0;
        int special = 0;
        for (int i = 0; i < n; i++) {
            page++;
            int k1 = 1;
            int k2 = Math.min(p[i], k);
            while (k2 < p[i]) {
                if (page >= k1 && page <= k2) {
                    special++;
                }
                k1 = k2 + 1;
                k2 = k2 + (page == p[i] / k ? p[i] % k : k);
                page++;
            }
        }
        System.out.println(special);
    }
}
