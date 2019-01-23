package leetcode;

import java.util.Scanner;

/**
 * Unoptimized solution
 */
public class ValidWordSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }
        System.out.println(isValidWordSquare(words));
    }

    private static boolean isValidWordSquare(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
