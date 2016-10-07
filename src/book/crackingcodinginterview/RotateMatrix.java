package book.crackingcodinginterview;

import java.util.Scanner;

/**
 * Rotate n*n matrix in-place
 */
public class RotateMatrix {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m[][] = getInput(in, n);

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = m[i][j];
                m[i][j] = m[n - j - 1][i];
                m[n - j - 1][i] = m[n - j - 1][n - i - 1];
                m[n - j - 1][n - i - 1] = m[j][n - i - 1];
                m[j][n - i - 1] = temp;
            }
        }

        print(m);
    }

    private static void print(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getInput(Scanner in, int n) {
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = in.nextInt();
            }
        }
        return m;
    }
}
