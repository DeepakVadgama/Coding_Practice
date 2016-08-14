package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks
 */
public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Integer> sticks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sticks.add(in.nextInt());
        }
        cut(sticks);
    }

    private static void cut(List<Integer> sticks) {
        if (!sticks.isEmpty()) {
            Integer min = Collections.min(sticks);
            sticks.replaceAll(s -> s - min);
            System.out.println(sticks.size());
            sticks.removeIf(s -> s <= 0);
            cut(sticks);
        }
    }
}
