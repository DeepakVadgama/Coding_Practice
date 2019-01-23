package leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/sentence-screen-fitting
 * <p>
 * Unoptimized
 */
public class SentenceScreenFitting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        int rows = in.nextInt();
        int cols = in.nextInt();
        System.out.println(fitOnScreen(sentence, rows, cols));
    }

    private static int fitOnScreen(String sentence, int rows, int cols) {
        String[] words = sentence.split(" ");
        int i = 0, j = 0, wi = 0, count = 0;
        while (i < rows) {
            if (j == cols - 1 || j + words[wi].length() - 1 >= cols) {
                i++;
                j = 0;
            } else {
                j += words[wi].length();
                j++; // for space

                if (wi == words.length - 1) {
                    count++;
                    wi = 0;
                } else {
                    wi++;
                }
            }
        }
        return count;
    }
}
