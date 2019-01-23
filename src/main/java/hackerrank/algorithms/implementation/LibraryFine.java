package hackerrank.algorithms.implementation;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/library-fine
 */
public class LibraryFine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LocalDate act = getDate(in);
        LocalDate exp = getDate(in);

        if (act.isBefore(exp) || act.isEqual(exp)) {
            System.out.println(0);
        } else if (act.getYear() != exp.getYear()) {
            System.out.println("10000");
        } else if (act.getMonthValue() != exp.getMonthValue()) {
            System.out.println((act.getMonthValue() - exp.getMonthValue()) * 500);
        } else {
            System.out.println((act.getDayOfMonth() - exp.getDayOfMonth()) * 15);
        }
    }

    public static LocalDate getDate(Scanner in) {
        int d = in.nextInt();
        int m = in.nextInt();
        int y = in.nextInt();
        return LocalDate.of(y, m, d);
    }
}
