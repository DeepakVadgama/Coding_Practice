package leetcode;

public class NQueenProblem {

    public static void main(String[] args) {

        System.out.println(new NQueenProblem().waysToPlaceQueen(0, new int[]{-1, -1, -1, -1}));
        System.out.println(new NQueenProblem().waysToPlaceQueen(0, new int[]{-1, -1, -1, -1, -1}));
        System.out.println(new NQueenProblem().waysToPlaceQueen(0, new int[]{-1, -1, -1, -1, -1, -1}));
        System.out.println(new NQueenProblem().waysToPlaceQueen(0, new int[]{-1, -1, -1, -1, -1, -1, -1}));
    }

    int waysToPlaceQueen(int n, int[] board) {

        if (n == board.length) {
//            print(board);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < board.length; i++) {
            board[n] = i;
            if (isBoardValid(n, board)) {
                count += waysToPlaceQueen(n + 1, board);
            }
            board[n] = -1;
        }
        return count;
    }

    private boolean isBoardValid(int n, int[] board) {

        for (int row = 0; row < n; row++) {
            if (board[n] == board[row]) {
                return false; // same column, different rows
            }
            if (Math.abs(board[n] - board[row]) == (n - row)) {
                return false;
            }
        }
        return true;
    }

    private void print(int[] board) {

        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i] == j) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

}
