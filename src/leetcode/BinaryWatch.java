package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/binary-watch/
 */
public class BinaryWatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(readBinaryWatch(n));
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> allTimings = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<String> hours = possibleHours(i);
            List<String> minutes = possibleMinutes(num - i);
            allTimings.addAll(combinations(hours, minutes));
        }
        return allTimings;
    }

    private static List<String> combinations(List<String> hours, List<String> minutes) {
        List<String> allTimings = new ArrayList<>();
        for (String hour : hours) {
            for (String minute : minutes) {
                allTimings.add(hour + ":" + minute);
            }
        }
        return allTimings;
    }

    private static List<String> possibleHours(int num) {
        List<String> allHours = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            if (countOne(Integer.toBinaryString(i)) == num) {
                allHours.add(String.valueOf(i));
            }
        }
        return allHours;
    }

    private static int countOne(String string) {
        return string.chars().map(ch -> ch - '0').sum();
    }

    private static List<String> possibleMinutes(int num) {
        List<String> allMinutes = new ArrayList<>();
        for (int i = 0; i < 59; i++) {
            if (countOne(Integer.toBinaryString(i)) == num) {
                allMinutes.add(String.format("%02d", i));
            }
        }
        return allMinutes;
    }


}
