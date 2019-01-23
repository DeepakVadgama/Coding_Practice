package leetcode;


/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
//        int[][] grid = new int[][]
//                {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int[][] grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int area = area(grid, i, j, visited);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private static int area(int[][] grid, int i, int j, boolean[][] visited) {
        if (!isValidBound(grid, i, j) || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + area(grid, i + 1, j, visited)
                + area(grid, i - 1, j, visited)
                + area(grid, i, j + 1, visited)
                + area(grid, i, j - 1, visited);
    }

    private static boolean isValidBound(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
