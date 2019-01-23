package google.codejam.y2016.round1a;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://code.google.com/codejam/contest/4304486/dashboard#s=p1
 */
public class RankAndFile {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            List<int[]> ip = getInput(in, n);
            sort(ip);

            List<int[]> op = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                op.add(nextRow(ip, op));
            }

            for (int j = 0; j < n; j++) {
                int[] col = getcol(op, j, n);
                if (!contains(ip, col)) {
                    StringJoiner sj = new StringJoiner(" ");
                    IntStream.of(col).forEach(x -> sj.add(String.valueOf(x)));
                    System.out.printf("Case #%d: %s\n", i + 1, sj.toString());
                    break;
                }
            }
        }
    }

    private static boolean contains(List<int[]> ip, int[] col) {
        for (int[] row : ip) {
            if (Arrays.equals(row, col)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getcol(List<int[]> op, int i, int n) {
        int[] col = new int[n];
        int j = 0;
        for (int[] row : op) {
            col[j] = row[i];
            j++;
        }
        return col;
    }

    private static int[] nextRow(List<int[]> ip, List<int[]> op) {
        for (Iterator<int[]> iterator = ip.iterator(); iterator.hasNext(); ) {
            int[] row = iterator.next();
            if (!conflict(op, row)) {
                iterator.remove();
                return row;
            }
        }
        System.err.println("Backtracking problem");
        return null;
    }

    private static boolean conflict(List<int[]> op, int[] row) {

        if (op.size() == 0) {
            return false;
        }

        for (int i = 0; i < row.length; i++) {
            int v = row[i];
            for (int[] oRow : op) {
                if (oRow[i] == v) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void sort(List<int[]> list) {
        Collections.sort(list, (o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] < o2[i]) {
                    return -1;
                } else if (o1[i] > o2[i]) {
                    return 1;
                }
            }
            return 0;
        });
    }

    private static List<int[]> getInput(Scanner in, int n) {
        List<int[]> v = new ArrayList<>();
        for (int j = 1; j < 2 * n; j++) {
            int[] a = new int[n];
            for (int k = 0; k < n; k++) {
                a[k] = in.nextInt();
            }
            v.add(a);
        }
        return v;
    }
}
