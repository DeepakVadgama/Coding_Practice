package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bomber-man
 * Only partial test cases passing
 */
public class Bomberman {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int m = in.nextInt();
        final int n = in.nextInt();
        final int s = in.nextInt();

        char[][] g0 = new char[m][n];
        fillZero(g0, m, n);

        char[][] g1 = new char[m][n];
        fill(in, g1, m, n);

        char[][] g3 = detonate(g1, m, n);

        switch (s % 4) {
            case 2:
            case 0:
                print(g0);
                break;
            case 1:
                print(g1);
                break;
            case 3:
                print(g3);
                break;
        }
    }

    private static void fillZero(char[][] g0, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g0[i][j] = 'O';
            }
        }
    }

    private static char[][] detonate(char[][] g, int m, int n) {
        char[][] d = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bombed(g, i, j)) {
                    d[i][j] = '.';
                } else {
                    d[i][j] = 'O';
                }
            }
        }
        return d;
    }

    private static void print(char[][] g) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean bombed(char[][] g, int i, int j) {
        boolean bombed = false;
        if (g[i][j] == 'O') {
            bombed = true;
        } else if (i > 0 && g[i - 1][j] == 'O') {
            bombed = true;
        } else if (i < g.length - 1 && g[i + 1][j] == 'O') {
            bombed = true;
        } else if (j < g[0].length - 1 && g[i][j + 1] == 'O') {
            bombed = true;
        } else if (j > 0 && g[i][j - 1] == 'O') {
            bombed = true;
        }
        return bombed;
    }


    private static void fill(Scanner in, char[][] g, int m, int n) {
        for (int i = 0; i < m; i++) {
            String next = in.next();
            for (int j = 0; j < n; j++) {
                g[i][j] = next.charAt(j);
            }
        }
    }


}
// Pattern repeating
//
//N=1
//.......
//...O...
//....O..
//.......
//OO.....
//OO.....
//
//N=2
//OOOOOOO
//OOOOOOO
//OOOOOOO
//OOOOOOO
//OOOOOOO
//OOOOOOO
//
//N=3
//OOO.OOO
//OO...OO
//OOO...O
//..OO.OO
//...OOOO
//...OOOO
//
//N=4
//OOOOOOO
//OOOOOOO
//OOOOOOO
//OOOOOOO
//OOOOOOO
//OOOOOOO
//
//N=5
//.......
//...O...
//....O..
//.......
//OO.....
//OO.....
