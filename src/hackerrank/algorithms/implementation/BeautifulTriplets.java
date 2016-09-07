package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-triplets
 */
public class BeautifulTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }

        int tc = 0;
        for (int i = 0; i < n; i++) {

            int v = a.get(i);
            if (a.contains(v + d) && a.contains(v + d + d)) {
                tc++;
            }
        }
        System.out.println(tc);

    }
}
