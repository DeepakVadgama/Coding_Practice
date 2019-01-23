package hackerrank.algorithms.warmup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/time-conversion
 */
public class TimeConversion {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String dateStr = sc.next();

        SimpleDateFormat twelve = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat twentyFour = new SimpleDateFormat("HH:mm:ss");

        final Date dateTime = twelve.parse(dateStr);
        System.out.println(twentyFour.format(dateTime));
    }
}
