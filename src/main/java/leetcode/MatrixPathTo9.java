package leetcode;

public class MatrixPathTo9 {

    public static void main(String[] args) {
        MatrixPathTo9 obj = new MatrixPathTo9();
        boolean ans = obj.pathToNine(
                new int[][]{{1, 1, 0, 1, 0},
                        {1, 0, 0, 1, 1},
                        {1, 0, 1, 9, 1},
                        {1, 1, 1, 0, 0},
                        {1, 0, 1, 1, 1}});
        System.out.println(ans);
    }

    public boolean pathToNine(int[][] A) {

        if (A == null || A.length == 0 || A[0].length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[A.length][A[0].length];
        return pathToNine(A, 0, 0, visited);
    }

    public boolean pathToNine(int[][] A, int row, int col, boolean[][] visited) {

        if (!isValidBound(A, row, col) || visited[row][col] == true || A[row][col] == 0) {
            return false;
        }

        visited[row][col] = true;
        if (A[row][col] == 9) {
            return true;
        }

        return pathToNine(A, row + 1, col, visited)
                || pathToNine(A, row, col + 1, visited)
                || pathToNine(A, row - 1, col, visited)
                || pathToNine(A, row, col - 1, visited);
    }

    public boolean isValidBound(int[][] A, int row, int col) {
        return !(row < 0 || row >= A.length || col < 0 || col >= A[0].length);
    }

}
