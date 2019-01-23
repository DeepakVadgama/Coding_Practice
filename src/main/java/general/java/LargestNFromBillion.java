package general.java;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Find largest 10 integers from say, a billion integers.
 * <p>
 * Trick is not to store any of the billion integers neither to sort them.
 * Only thing to care about is the list of top 10 integers
 * <p>
 * Sample input
 * 14
 * 1 2 3 4 5 6 7 9 0 12 43 56 34 23
 */
public class LargestNFromBillion {

    private static final int THRESHOLD = 10;
    private static final TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int j = 0; j < n; j++) {
            int i = in.nextInt();
            addIfBigger(i);
        }

        System.out.println(set);
    }

    private static void addIfBigger(int i) {
        // If considering concurrency, then use read and write locks
        if (set.size() < THRESHOLD) {
            set.add(i);
        } else if (i > set.first() && !set.contains(i)) {
            // Contains check necessary to avoid adding duplicate and accidentally removing smallest
            set.pollFirst();
            set.add(i);
        }
    }
}
