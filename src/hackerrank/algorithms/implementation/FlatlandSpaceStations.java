package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flatland-space-stations
 */
public class FlatlandSpaceStations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = in.nextInt();

        int[] n = new int[k];
        for (int i = 0; i < k; i++) {
            n[i] = in.nextInt();
        }
        Arrays.sort(n);

        int gap = Math.max(t - n[n.length - 1] - 1, n[0]);
        for (int i = 0; i < k - 1; i++) {
            gap = Math.max((n[i + 1] - n[i]) / 2, gap);
        }
        System.out.println(gap);
    }
}
