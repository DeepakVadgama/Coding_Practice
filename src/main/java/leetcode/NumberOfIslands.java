package leetcode;

public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands obj = new NumberOfIslands();
        int[][] matrix = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        System.out.println(obj.numberOfIslands(matrix));
    }

    public int numberOfIslands(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    islandCount++;
                    markAll(matrix, visited, i, j);
                }
            }
        }
        return islandCount;
    }

    private void markAll(int[][] matrix, boolean[][] visited, int row, int col) {

        visited[row][col] = true;
        if (isValid(matrix, row + 1, col) && matrix[row + 1][col] == 1) {
            markAll(matrix, visited, row + 1, col);
        }
        if (isValid(matrix, row, col + 1) && matrix[row][col + 1] == 1) {
            markAll(matrix, visited, row, col + 1);
        }
    }

    private boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

}
