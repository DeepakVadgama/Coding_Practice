package leetcode;

/**
 * https://leetcode.com/problems/bomb-enemy
 * <p>
 * Blatantly stolen from here - https://discuss.leetcode.com/topic/48565/short-o-mn-solution
 */
public class BombEnemy {

    public static void main(String[] args) {
        System.out.println(maxKilledEnemies(new char[][]{
                {0, 'E', 0, 0},
                {'E', 0, 'W', 0},
                {0, 'E', 0, 0}
        }));
        System.out.println(maxKilledEnemies(new char[][]{
                {0, 'E', 0, 0},
                {'E', 'W', 'W', 0},
                {0, 'E', 0, 0}
        }));
        System.out.println(maxKilledEnemies(new char[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        }));
    }

    public static int maxKilledEnemies(char[][] grid) {

        int m = grid.length, n = grid[0].length;
        int maxHits = 0, rowHits = 0;
        int[] colHits = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        rowHits += grid[i][k] == 'E' ? 1 : 0;
                    }
                }

                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        colHits[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }

                if (grid[i][j] == 0) {
                    maxHits = Math.max(maxHits, rowHits + colHits[j]);
                }
            }
        }

        return maxHits;
    }
}
