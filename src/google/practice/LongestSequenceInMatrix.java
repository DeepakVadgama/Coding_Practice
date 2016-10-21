package google.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a 2D matrix find the longest sequence of numbers.
 * <p>
 * Eg:
 * 0 1 4
 * 2 3 5
 * 8 7 6
 * <p>
 * Longest sequence is 4,5,6,7,8
 */
public class LongestSequenceInMatrix {

    private static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = getMatrix(in, n);

        List<Integer> longest = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!longest.contains(matrix[i][j])) {
                    List<Integer> current = findSequence(matrix, i, j);
                    if (current.size() > longest.size()) {
                        longest = current;
                    }
                }
            }
        }
        System.out.println(longest);
        System.out.println(longest.size());
    }

    private static List<Integer> findSequence(int[][] matrix, int i, int j) {
        List<Integer> sequence = new LinkedList<>();
        sequence.add(matrix[i][j]);
        findSequenceRecursive(matrix, i, j, sequence);
        return sequence;
    }

    private static void findSequenceRecursive(int[][] matrix, int i, int j, List<Integer> sequence) {
        for (int k = 0; k < delta.length; k++) {
            int rowIndex = i + delta[k][0];
            int colIndex = j + delta[k][1];
            if (isValidIndex(matrix, rowIndex, colIndex) && isSequence(matrix, i, j, rowIndex, colIndex)) {
                sequence.add(matrix[rowIndex][colIndex]);
                findSequenceRecursive(matrix, rowIndex, colIndex, sequence);
                return;
            }
        }
    }

    private static boolean isSequence(int[][] matrix, int i, int j, int k, int l) {
        return matrix[k][l] == matrix[i][j] + 1;
    }

    private static boolean isValidIndex(int[][] matrix, int i, int j) {
        return i < matrix.length && i >= 0 && j < matrix[0].length && j >= 0;
    }

    private static int[][] getMatrix(Scanner in, int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }
}
