package hackerrank.algorithms.implementation;

import java.io.IOException;
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

    public static void main(String[] args) throws IOException {

//        List<String> input = Files.readAllLines(Paths.get("/home/deepak/Desktop/input01.txt"));
//        List<String> output = Files.readAllLines(Paths.get("/home/deepak/Desktop/output01.txt"));
//
//        for (int i = 0; i < input.size(); i++) {
//            final String outputVal = solveThis(input.get(i));
//            if (!outputVal.equals(output.get(i))) {
//                System.out.println("Problem");
//                System.out.println("Input: " + input.get(i));
//                System.out.println("Actual   Output: " + outputVal);
//                System.out.println("Expected Output: " + output.get(i));
//                solveThis(input.get(i));
//                System.exit(0);
//            } 
//        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            final String string = in.next();
            final List<Character> list = string.chars()
                    .mapToObj(e -> (char) e)
                    .collect(Collectors.toList());
            System.out.println(solveThis(list));
        }
    }

    private static String solveThis(String string) {
        final List<Character> list = string.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
        return solveThis(list);
    }

    private static String solveThis(List<Character> list) {
        String result = "no answer";
        if (list.size() != 1 && !isDescending(list)) {
            int pivotIndex = getPivot(list);
            char pivot = list.get(pivotIndex);
            List<Character> l1 = new ArrayList<>();
            if (pivotIndex > 0) {
                l1 = new ArrayList<>(list.subList(0, pivotIndex));
            }
            List<Character> l2 = new ArrayList<>(list.subList(pivotIndex, list.size()));
            Collections.sort(l2);
            int newPivotIndex = newPivot(l2, pivot);
            char newPivot = l2.get(newPivotIndex);
            l2.remove(newPivotIndex);
            Collections.sort(l2);
            result = getString(l1) + newPivot + getString(l2);
        }
        return result;
    }

    private static int newPivot(List<Character> list, Character pivot) {
        for (Character character : list) {
            if (character > pivot) {
                return list.indexOf(character);
            }
        }
        return -1;
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
