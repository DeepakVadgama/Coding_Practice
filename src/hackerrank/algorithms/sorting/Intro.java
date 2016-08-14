package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/tutorial-intro
 */
public class Intro {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int val = in.nextInt();
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            if (in.nextInt() == val) {
                System.out.println(i);
            }
        }
    }
}
