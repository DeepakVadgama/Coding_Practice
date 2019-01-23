package leetcode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * <p>
 * Wrong solution.
 * <p>
 * Can be fixed by using priority queue and adding indexes of neighbors
 */
public class KthSmallestFromMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] matrix = {{1, 3, 5}, {6, 7, 12}, {11, 14, 14}};
        System.out.println(kthSmallest(matrix, 5));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int val = 0;
        for (int i = 0; i < n; i++) {

            k--;
            if (k == 0) return matrix[i][i];

            int hi = i + 1;
            int vi = i + 1;
            while (hi < n || vi < n) {

                if (hi == n) {
                    val = matrix[vi][i];
                    vi++;
                } else if (vi == n) {
                    val = matrix[i][hi];
                    hi++;
                } else if (matrix[i][hi] < matrix[vi][i]) {
                    val = matrix[i][hi];
                    hi++;
                } else {
                    val = matrix[vi][i];
                    vi++;
                }

                k--;
                if (k == 0) {
                    return val;
                }
            }
        }
        return -1;
    }
}
