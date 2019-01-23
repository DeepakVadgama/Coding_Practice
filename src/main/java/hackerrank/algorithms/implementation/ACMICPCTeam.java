package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/acm-icpc-team
 */
public class ACMICPCTeam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        List<String> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(in.next());
        }

        int max = 0;
        int tsize = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = or(v.get(i), v.get(j));
                if (count == max) {
                    tsize++;
                } else if (count > max) {
                    max = count;
                    tsize = 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(tsize);
    }

    private static int or(String s1, String s2) {
        int c = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1' || s2.charAt(i) == '1') {
                c++;
            }
        }
        return c;
    }
}
