package leetcode;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class ValidMountainArray {

    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] A) {

        if (A == null || A.length < 3 || A[1] < A[0]) {
            return false;
        }

        boolean increasing = true;
        for (int i = 1; i < A.length; i++) {

            if (A[i] == A[i - 1]) {
                return false;
            }

            if (increasing) {
                if (A[i] < A[i - 1]) {
                    increasing = false;
                }
            } else {
                if (A[i] > A[i - 1]) {
                    return false;
                }
            }
        }

        return increasing == false;
    }
}
