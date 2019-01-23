package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lisa-workbook
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
            int t1 = 1;
            int t2 = Math.min(p[i], k);
            while (t2 <= p[i]) {
                page++;
                if (page >= t1 && page <= t2) {
                    special++;
                }
                t1 = t2 + 1;
                t2 = t2 + Math.min(p[i] - t2 == 0 ? k : p[i] - t2, k);
            }
        }
        System.out.println(special);
    }
}
