package book.crackingcodinginterview;

import java.util.Scanner;

/**
 * Given 2 strings print true if one string can be transformed into another
 * by only changing/removing/adding one character
 */
public class OneAway {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int n1 = s1.length();
        int n2 = s2.length();

        if (Math.abs(n1 - n2) > 1) {
            System.out.println(false);
        } else {
            int c = 0;
            for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    if (i + 1 < n1 && s1.charAt(i + 1) == s2.charAt(j)) {
                        i++;
                    } else if (j + 1 < n2 && s1.charAt(i) == s2.charAt(j + 1)) {
                        j++;
                    }
                    c++;
                }
            }
            if (c <= 1) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }

    }
}
