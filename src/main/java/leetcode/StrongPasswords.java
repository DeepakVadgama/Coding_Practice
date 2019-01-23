package leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/strong-password-checker/
 * <p>
 * LeetCode is stupid, it says repeating 3 chars is not ok
 * It had these 2 examples.
 * aaa111  expected answer is 2 (so even repeating digits is not ok)
 * ...     expected answer is 3 (WTH.. so repeating special chars is ok, but not digits?)
 */
public class StrongPasswords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String password = in.next();
        System.out.println(strongPasswordChecker(password));
    }

    private static int strongPasswordChecker(final String password) {
        int addCount = addCount(password.length());
        int delCount = delCount(password.length());
        int triplets = tripletCount(password);

        boolean hasLowerCase = hasLowerCase(password);
        boolean hasUpperCase = hasUpperCase(password);
        boolean hasDigit = hasDigit(password);

        int minChanges = 0;

        int opers = countFalses(hasLowerCase, hasUpperCase, hasDigit);
        for (int i = 0; i < opers; i++) {
            if (addCount > 0) {
                addCount--;
            } else if (triplets > 0) {
                triplets--;
            }
            minChanges++;
        }

        minChanges += addCount;
        minChanges += delCount > triplets ? delCount : triplets;

        return minChanges;
    }

    private static int countFalses(boolean... values) {
        int count = 0;
        for (boolean b : values) {
            if (!b) {
                count++;
            }
        }
        return count;
    }

    private static int tripletCount(String str) {
        int triplets = 0;
        int i = 0;
        while (i + 2 < str.length()) {
            char ch = str.charAt(i);
            if (ch == str.charAt(i + 1)
                    && ch == str.charAt(i + 2)) {
                triplets++;
                i += 3;
            } else {
                i++;
            }
        }
        return triplets;
    }

    private static boolean hasLowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String str) {
        for (int i = 0; i <= 9; i++) {
            if (str.contains(Integer.toString(i))) {
                return true;
            }
        }
        return false;
    }

    private static int addCount(int i) {
        return i < 6 ? 6 - i : 0;
    }

    private static int delCount(int i) {
        return i > 20 ? i - 20 : 0;
    }
}
