package hackerrank.algorithms.warmup;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * https://www.hackerrank.com/challenges/plus-minus
 */
public class PlusMinus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int positive = 0, negative = 0, zeroes = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                zeroes++;
            } else if (num > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        final BigDecimal count = new BigDecimal(n);
        BigDecimal pf = new BigDecimal(positive).divide(count, 6, ROUND_HALF_UP);
        BigDecimal nf = new BigDecimal(negative).divide(count, 6, ROUND_HALF_UP);
        BigDecimal zf = new BigDecimal(zeroes).divide(count, 6, ROUND_HALF_UP);
        System.out.println(pf);
        System.out.println(nf);
        System.out.println(zf);
    }
}
