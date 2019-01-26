package codechef;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.codechef.com/LTIME68B/problems/RKS#
 */
public class Rooks {


    static LinkedList<Integer> occupiedRows = new LinkedList<>();
    static LinkedList<Integer> occupiedCols = new LinkedList<>();
    static LinkedList<Integer> eligibleRows = new LinkedList<>();
    static LinkedList<Integer> eligibleCols = new LinkedList<>();
    static List<Integer> newRows = new LinkedList<>();
    static List<Integer> newCols = new LinkedList<>();
    static int p = 0;

    public static void main(String[] args) {

        int n = 5;
        int k = 2;
        occupiedRows.add(2);
        occupiedRows.add(3);
        occupiedCols.add(1);
        occupiedCols.add(3);

        solve(n, k, occupiedRows, occupiedCols);
    }

    private static void solve(int n, int k, LinkedList<Integer> occupiedRows, LinkedList<Integer> occupiedCols) {

        for (int i = 0; i < n; i++) {
            eligibleCols.add(i);
            eligibleRows.add(i);
        }
        eligibleCols.removeAll(occupiedCols);
        eligibleRows.removeAll(occupiedRows);

        for (int i = 0; i < (n - k); i++) {
            placeNextRook(n);
        }


        System.out.print(p + " ");
        for (int i = 0; i < newRows.size(); i++) {
            System.out.print(newRows.get(i) + " " + newCols.get(i) + " ");
        }
    }

    private static void placeNextRook(int n) {

        Iterator<Integer> rowItr = eligibleRows.iterator();
        Iterator<Integer> colItr = eligibleRows.iterator();

        while (rowItr.hasNext()) {
            int r = rowItr.next();
            while (colItr.hasNext()) {
                int c = colItr.next();
                if (!occupiedRows.contains(r) && !occupiedCols.contains(c)) {

                    newRows.add(r);
                    newCols.add(c);
                    p++;

                    rowItr.remove();
                    colItr.remove();

                    occupiedRows.add(r);
                    occupiedCols.add(c);

                    return;
                }
            }
        }
    }
}
