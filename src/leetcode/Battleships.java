package leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class Battleships {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();

        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String string = in.next();
            for (int j = 0; j < string.length(); j++) {
                board[i][j] = string.charAt(j);
            }
        }

        System.out.println(countBattleships(board));
    }

    public static int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isX(board, i, j) && !isPreviousX(board, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPreviousX(char[][] board, int i, int j) {
        return ((i - 1 >= 0 && isX(board, i - 1, j)) || (j - 1) >= 0 && isX(board, i, j - 1));
    }

    private static boolean isX(char[][] board, int i, int j) {
        return board[i][j] == 'X';
    }
}
