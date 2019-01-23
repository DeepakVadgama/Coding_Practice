package google.codejam.y2016.round1a;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/4304486/dashboard#s=p0
 */
public class TheLastWord {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String s1 = in.next();
            String s2 = String.valueOf(s1.charAt(0));
            for (int j = 1; j < s1.length(); j++) {
                char c = s1.charAt(j);
                if (c >= s2.charAt(0)) {
                    s2 = c + s2;
                } else {
                    s2 = s2 + c;
                }
            }
            System.out.printf("Case #%d: %s\n", i + 1, s2);
        }
    }
}
