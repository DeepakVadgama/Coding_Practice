package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum
 */
public class AVeryBigSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }
        System.out.println(sum);
    }
}
