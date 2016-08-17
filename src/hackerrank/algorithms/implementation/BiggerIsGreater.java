package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/
 * First attempt failed. Used this to rectify - https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class BiggerIsGreater {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<List<Character>> strings = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            final String string = in.next();
            final List<Character> list = string.chars()
                    .mapToObj(e -> (char) e)
                    .collect(Collectors.toList());
            strings.add(list);
        }

        for (List<Character> list : strings) {
            if (list.size() == 1 || isDescending(list)) {
                System.out.println("no answer");
            } else {
                int pivotIndex = getPivot(list);
                char pivot = list.get(pivotIndex);
                List<Character> firstPart = new ArrayList<>();
                if (pivotIndex > 0) {
                    firstPart = new ArrayList<>(list.subList(0, pivotIndex));
                }
                List<Character> secondPart = new ArrayList<>(list.subList(pivotIndex, list.size()));
                Collections.sort(secondPart);
                final int index = secondPart.indexOf(pivot);
                char newPivot = secondPart.get(index + 1);
                secondPart.remove(index + 1);
                Collections.sort(secondPart);
                System.out.println(getString(firstPart) + newPivot + getString(secondPart));
            }
        }
    }

    private static String getString(List<Character> chars) {
        StringBuilder result = new StringBuilder(chars.size());
        chars.forEach(result::append);
        return result.toString();
    }

    private static int getPivot(List<Character> list) {
        int i = list.size() - 1;
        while (i > 0) {
            if (list.get(i) > list.get(i - 1)) {
                return i - 1;
            }
            i--;
        }
        return -1;
    }

    // Eg: cbbba
    private static boolean isDescending(List<Character> string) {
        int i = 1;
        while (i < string.size()) {
            if (string.get(i) > string.get(i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
