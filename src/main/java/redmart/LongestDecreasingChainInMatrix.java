package redmart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * http://geeks.redmart.com/2015/01/07/skiing-in-singapore-a-coding-diversion/
 * <p>
 * 1000x1000 grid
 * http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt
 */
public class LongestDecreasingChainInMatrix {

    private static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] matrix = getMatrix(in, m, n);

        System.out.println(findLongestSlope(matrix, m, n));
    }

    private static String findLongestSlope(int[][] matrix, int m, int n) {

        Map<String, Integer> lengths = new HashMap<>();
        Map<String, Integer> drops = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                populateSlopeLengthAndDrop(matrix, i, j, lengths, drops);
            }
        }
        return maxLengthAndDrop(m, n, lengths, drops);
    }

    private static String maxLengthAndDrop(int m, int n,
                                           Map<String, Integer> lengths,
                                           Map<String, Integer> drops) {
        int longest = -1;
        int drop = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String key = key(i, j);
                int currLength = lengths.get(key);
                int currDrop = drops.get(key);
                if (currLength > longest) {
                    longest = currLength;
                    drop = currDrop;
                } else if (currLength == longest) {
                    if (currDrop > drop) {
                        drop = currDrop;
                    }
                }
            }
        }
        return "Length=" + (longest + 1) + ", Drop=" + drop;
    }

    private static String key(int i, int j) {
        return i + "-" + j;
    }

    private static void populateSlopeLengthAndDrop(int[][] matrix, int i, int j,
                                                   Map<String, Integer> lengths,
                                                   Map<String, Integer> drops) {

        if (lengths.containsKey(key(i, j))) {
            return;
        }

        int longest = 0;
        int drop = 0;
        for (int k = 0; k < delta.length; k++) {
            int row = i + delta[k][0];
            int col = j + delta[k][1];
            if (isValidIndex(matrix, row, col) && isDecreasing(matrix, i, j, row, col)) {
                populateSlopeLengthAndDrop(matrix, row, col, lengths, drops);
                int currLength = 1 + lengths.get(key(row, col));
                int currDrop = calcDrop(matrix, i, j, row, col) + drops.get(key(row, col));
                if (currLength > longest) {
                    longest = currLength;
                    drop = currDrop;
                } else if (currLength == longest && currDrop > drop) {
                    drop = currDrop;
                }
            }

        }
        lengths.put(key(i, j), longest);
        drops.put(key(i, j), drop);
    }

    private static int calcDrop(int[][] matrix, int i, int j, int row, int col) {
        return matrix[i][j] - matrix[row][col];
    }

    private static boolean isDecreasing(int[][] matrix, int i, int j, int k, int l) {
        return matrix[k][l] < matrix[i][j];
    }

    private static boolean isValidIndex(int[][] matrix, int i, int j) {
        return i < matrix.length && i >= 0 && j < matrix[0].length && j >= 0;
    }

    private static int[][] getMatrix(Scanner in, int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }
}
