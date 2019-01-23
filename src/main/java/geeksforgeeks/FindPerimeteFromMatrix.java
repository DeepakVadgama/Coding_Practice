package geeksforgeeks;

/**
 * http://www.geeksforgeeks.org/find-perimeter-shapes-formed-1s-binary-matrix/
 */
public class FindPerimeteFromMatrix {
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
                {0, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0},
        }));
    }

    private static int solve(int[][] values) {

        int m = values.length;
        int n = values[0].length;

        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (values[i][j] == 1) {
                    perimeter += 4;
                    if (isOne(values, i + 1, j)) {
                        perimeter--;
                    }
                    if (isOne(values, i, j + 1)) {
                        perimeter--;
                    }
                    if (isOne(values, i - 1, j)) {
                        perimeter--;
                    }
                    if (isOne(values, i, j - 1)) {
                        perimeter--;
                    }
                }
            }
        }

        return perimeter;
    }

    private static boolean isOne(int[][] values, int i, int j) {
        return i >= 0 && j >= 0
                && i < values.length && j < values[0].length
                && values[i][j] == 1;
    }
}
